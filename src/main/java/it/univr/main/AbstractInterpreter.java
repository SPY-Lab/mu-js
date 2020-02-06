package it.univr.main;

import java.util.HashMap;

import org.apache.commons.collections15.multimap.MultiHashMap;

import it.univr.domain.AbstractDomain;
import it.univr.domain.AbstractValue;
import it.univr.domain.AllocationSite;
import it.univr.domain.coalasced.AbstractObject;
import it.univr.domain.coalasced.AllocationSites;
import it.univr.domain.coalasced.Bool;
import it.univr.domain.coalasced.Bottom;
import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.domain.coalasced.NaN;
import it.univr.main.MuJsParser.IdentifierContext;
import it.univr.main.MuJsParser.PrimitiveValueContext;
import it.univr.state.AbstractEnvironment;
import it.univr.state.AbstractState;
import it.univr.state.KeyAbstractState;
import it.univr.state.Variable;

public class AbstractInterpreter extends MuJsBaseVisitor<AbstractValue> {

	private AbstractEnvironment env;
	private AbstractDomain domain;
	private AbstractState state;

	private boolean narrowingIsEnabled;
	private boolean printInvariants;

	public AbstractInterpreter(AbstractDomain domain, boolean narrowing, boolean invariants) {
		this.env = new AbstractEnvironment(domain);
		this.state = new AbstractState();
		this.narrowingIsEnabled = narrowing;
		this.printInvariants = invariants;
	}

	public AbstractEnvironment getFinalAbstractMemory() {
		return env;
	}

	public AbstractState getAbstractState() {
		return state;
	}

	public void setAbstractState(AbstractEnvironment env) {
		this.env = env;
	}

	public AbstractDomain getAbstractDomain() {
		return domain;
	}

	public void setAbstractDomain(AbstractDomain domain) {
		this.domain = domain;
	}

	
	/**
	 * 
	 * MuJS Objects
	 * 
	 */
	@Override 
	public AbstractValue visitPropUpdate(MuJsParser.PropUpdateContext ctx) {
		
		Variable var = new Variable(ctx.ID().getText());
		AbstractValue allocationSites = env.getStore().get(var);
		
		if (allocationSites instanceof AllocationSites) {
			for (AllocationSite l : ((AllocationSites)allocationSites).getAllocationSites()) {

				FA key = new FA(ctx.expression(0).getText());
				AbstractValue value = visit(ctx.expression(1));
				
				AbstractValue obj = env.getHeap().get(l);
				if (obj instanceof AbstractObject) {	
					AbstractObject object = (AbstractObject)obj;
					object.put(key, object.get(key).leastUpperBound(value));
					object.normalize();
				}
			}
		}
		return new Bottom();
	}

	@Override 
	public AbstractValue visitPropLookup(MuJsParser.PropLookupContext ctx) { 
		
		Variable v = new Variable(ctx.ID().getText());
		AbstractValue abstractValue = new Bottom();
		
		if (env.getStore().containsKey(v)) {
			AbstractValue sites = env.getStore().get(v);
			
			if (sites instanceof AllocationSite) {
				for (AllocationSite site: ((AllocationSites)sites).getAllocationSites()) {
					FA key = new FA(ctx.expression().getText());
					AbstractValue obj = env.getHeap().get(site);
					
					if (obj instanceof AbstractObject) {
						AbstractValue val = ((AbstractObject)obj).get(key);
						abstractValue = abstractValue.leastUpperBound(val);
					}
				}
			}
		}
		
		return abstractValue;
	}
	
	@Override 
	public AbstractValue visitEmptyObject(MuJsParser.EmptyObjectContext ctx) {
		return new AbstractObject(); 
	}

	@Override 
	public AbstractValue visitObj(MuJsParser.ObjContext ctx) {
		HashMap<FA, AbstractValue> objectMap = new HashMap<>();
		
		for (int i = 0; i < ctx.ID().size(); i++) {
			AbstractValue expression = visit(ctx.expression(i));
			FA id = new FA(ctx.ID(i).toString());
			objectMap.put(id, expression);
		}
		
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		for (FA key : objectMap.keySet()) {
			abstractObjectMap.put(key, objectMap.get(key));
		}
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		return obj;
	}

	@Override 
	public AbstractValue visitObjectExpression(MuJsParser.ObjectExpressionContext ctx) { 
		return visitChildren(ctx);
	}
	
	@Override 
	public AbstractValue visitObjectAsg(MuJsParser.ObjectAsgContext ctx) {
		
		int row = ctx.getStart().getLine();
		int col = ctx.getStart().getCharPositionInLine();
		AllocationSite l = new AllocationSite(row, col);
		Variable var = new Variable(ctx.ID().getText());
		
		env.getStore().put(var, new AllocationSites(l));
		env.getHeap().put(l, visit(ctx.object()));
		
		return new Bottom();
	}
	
	/**
	 * 
	 * MuJS Statements
	 * 
	 */
	@Override 
	public AbstractValue visitBlockStmt(MuJsParser.BlockStmtContext ctx) { 
		return visitChildren(ctx); 
	}

	@Override 
	public AbstractValue visitAssignmentStmt(MuJsParser.AssignmentStmtContext ctx) { 

		Variable v = new Variable(ctx.getChild(0).getText());
		env.put(v, visit(ctx.expression()));

		if (printInvariants) {
			KeyAbstractState key = new KeyAbstractState(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
			state.add(key, env.clone());
		}
		return new Bottom(); 
	}

	@Override 
	public AbstractValue visitBlock(MuJsParser.BlockContext ctx) { 
		if (ctx.stmt() != null)
			visit(ctx.stmt());

		return new Bottom();
	}

	@Override 
	public AbstractValue visitComposition(MuJsParser.CompositionContext ctx) { 
		visit(ctx.stmt(0));	
		visit(ctx.stmt(1));
		return new Bottom();
	}

	@Override 
	public AbstractValue visitIfStmt(MuJsParser.IfStmtContext ctx) { 

		Bool evaluationGuard = (Bool) domain.juggleToBool(visit(ctx.expression()));

		if (evaluationGuard.isTrue()) 
			return visit(ctx.block(0));

		if (evaluationGuard.isFalse())
			return visit(ctx.block(1));

		AbstractEnvironment previous = (AbstractEnvironment) env.clone();

		visit(ctx.block(0));

		AbstractEnvironment trueBranch = (AbstractEnvironment) env.clone();
		env = previous;

		visit(ctx.block(1));

		env = env.leastUpperBound(trueBranch);

		if (printInvariants) {
			KeyAbstractState key = new KeyAbstractState(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
			state.add(key, env.clone());
		}		

		return new Bottom();
	}

	@Override 
	public AbstractValue visitProgramExecution(MuJsParser.ProgramExecutionContext ctx) {
		return visit(ctx.stmt()); 
	}

	@Override 
	public AbstractValue visitWhileStmt(MuJsParser.WhileStmtContext ctx) { 

		AbstractEnvironment lastExecution = new AbstractEnvironment(domain);
		AbstractEnvironment previous = (AbstractEnvironment) env.clone();

		do {

			/**
			 * True
			 */
			if (domain.isTrue(domain.juggleToBool(visit(ctx.expression())))) {
				visit(ctx.block());

				if (narrowingIsEnabled)
					lastExecution =  env.clone();
				env = previous.widening(env);
			} 

			/**
			 * False
			 */
			else if (domain.isFalse(domain.juggleToBool(visit(ctx.expression())))) {
				if (narrowingIsEnabled)

					lastExecution =  env.clone();
				break;
			} 

			/**
			 * Top
			 */
			else if (domain.isTopBool(domain.juggleToBool(visit(ctx.expression())))) {
				if (narrowingIsEnabled)
					env.intersect(projectTrueState(ctx.expression()));
				
				visit(ctx.block());
				if (narrowingIsEnabled)
					lastExecution = env.clone();
				env = previous.widening(previous.leastUpperBound(env));
			}

			AbstractEnvironment s =  env.clone();
			if (narrowingIsEnabled)
				s.intersect(projectTrueState(ctx.expression()));	

			if (previous.equals(s))
				break;
			else
				previous = s.clone();
		} while (true);

		if (narrowingIsEnabled) {
			env.intersect(projectFalseState(ctx.expression()));
			env = env.narrowing(lastExecution);
		}

		if (printInvariants) {
			KeyAbstractState key = new KeyAbstractState(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
			state.add(key, env.clone());
		}

		return new Bottom(); 
	}

	/**
	 * 
	 * MuJS Expression
	 * 
	 */
	@Override 
	public AbstractValue visitGreater(MuJsParser.GreaterContext ctx) { 
		AbstractValue left = visit(ctx.expression(0));
		AbstractValue right = visit(ctx.expression(1));

		return domain.greater(left, right);
	}

	@Override public AbstractValue visitEquals(MuJsParser.EqualsContext ctx) { 
		AbstractValue left = visit(ctx.expression(0));
		AbstractValue right = visit(ctx.expression(1));

		return domain.equals(left, right);
	}

	@Override 
	public AbstractValue visitLess(MuJsParser.LessContext ctx) { 
		AbstractValue left = visit(ctx.expression(0));
		AbstractValue right = visit(ctx.expression(1));

		return domain.less(left, right);
	}

	@Override 
	public AbstractValue visitSubstring(MuJsParser.SubstringContext ctx) { 
		AbstractValue string = visit(ctx.expression(0));
		AbstractValue init = visit(ctx.expression(1));
		AbstractValue end = visit(ctx.expression(2));

		return domain.substring(string, init, end);	
	}

	@Override 
	public AbstractValue visitDiff(MuJsParser.DiffContext ctx) { 
		AbstractValue left = visit(ctx.expression(0));
		AbstractValue right = visit(ctx.expression(1));

		return domain.diff(left, right);
	}

	@Override 
	public AbstractValue visitMul(MuJsParser.MulContext ctx) {
		AbstractValue left = visit(ctx.expression(0));
		AbstractValue right = visit(ctx.expression(1));

		return domain.mul(left, right);
	}

	@Override 
	public AbstractValue visitIndexOf(MuJsParser.IndexOfContext ctx) {
		AbstractValue string = visit(ctx.expression(0));
		AbstractValue search = visit(ctx.expression(1));

		return domain.indexOf(string, search);
	}

	@Override 
	public AbstractValue visitSum(MuJsParser.SumContext ctx) { 
		AbstractValue left = visit(ctx.expression(0));
		AbstractValue right = visit(ctx.expression(1));

		return domain.sum(left, right);
	}

	@Override 
	public AbstractValue visitPrimitiveValue(MuJsParser.PrimitiveValueContext ctx) { 
		return visitChildren(ctx); 
	}

	@Override 
	public AbstractValue visitInteger(MuJsParser.IntegerContext ctx) { 
		return domain.makeInterval(new Interval(ctx.INT().getText(), ctx.INT().getText()));
	}

	@Override 
	public AbstractValue visitBoolean(MuJsParser.BooleanContext ctx) { 
		return domain.makeBool(new Bool(ctx.BOOL().getText().equals("true") ? 1 : 0));
	}

	@Override 
	public AbstractValue visitString(MuJsParser.StringContext ctx) { 
		return domain.makeFA(new FA(ctx.STRING().getText().substring(0, ctx.STRING().getText().length()-1).substring(1)));
	}

	//TODO: division
	@Override 
	public AbstractValue visitDiv(MuJsParser.DivContext ctx) { 
		AbstractValue left = visit(ctx.expression(0));
		AbstractValue right = visit(ctx.expression(1));

		return domain.div(left, right);
	}

	@Override 
	public AbstractValue visitNot(MuJsParser.NotContext ctx) { 
		AbstractValue v = visit(ctx.expression());
		return domain.not(v);		
	}


	@Override 
	public AbstractValue visitCharAt( MuJsParser.CharAtContext ctx) { 
		AbstractValue string = visit(ctx.expression(0));
		AbstractValue index = visit(ctx.expression(1));

		return domain.charAt(string, index);
	}

	@Override public AbstractValue visitLength(MuJsParser.LengthContext ctx) { 
		AbstractValue string = visit(ctx.expression());

		return domain.length(string);
	}

	@Override 
	public AbstractValue visitAnd(MuJsParser.AndContext ctx) { 
		AbstractValue first = visit(ctx.expression(0));
		AbstractValue second = visit(ctx.expression(1));

		return domain.and(first, second);
	}

	@Override 
	public AbstractValue visitOr(MuJsParser.OrContext ctx) { 
		AbstractValue first = visit(ctx.expression(0));
		AbstractValue second = visit(ctx.expression(1));

		return domain.or(first, second);
	}

	@Override 
	public AbstractValue visitIdentifier(MuJsParser.IdentifierContext ctx) { 

		Variable v = new Variable(ctx.ID().getText());

		if (env.getStore().containsKey(v))
			return env.getStore().get(v);
		else
			return new Bottom();
	}

	@Override 
	public AbstractValue visitParenthesis(MuJsParser.ParenthesisContext ctx) {
		return visit(ctx.expression()); 
	}

	@Override 
	public AbstractValue visitNaN(MuJsParser.NaNContext ctx) { 
		return domain.makeNaN(new NaN());
	}

	public AbstractEnvironment projectTrueState(MuJsParser.ExpressionContext exp) {
		AbstractEnvironment state = new AbstractEnvironment(domain);

		// A > B
		if (exp instanceof MuJsParser.GreaterContext) {
			if (((MuJsParser.GreaterContext) exp).expression(0) instanceof IdentifierContext && ((MuJsParser.GreaterContext) exp).expression(1) instanceof PrimitiveValueContext) {

				String bound = ((PrimitiveValueContext) ((MuJsParser.GreaterContext) exp).expression(1)).getText();

				long numericBound = 0;

				try {
					numericBound = Long.parseLong(bound);
				} catch (Exception e){

					return new AbstractEnvironment(domain);
				}

				state.put(new Variable(((MuJsParser.GreaterContext) exp).expression(0).getChild(0).getText()), domain.makeInterval(new Interval(String.valueOf(numericBound + 1), "+Inf")));
				return state;
			}

			else if (((MuJsParser.GreaterContext) exp).expression(1) instanceof IdentifierContext && ((MuJsParser.GreaterContext) exp).expression(0) instanceof PrimitiveValueContext) {

				String bound = ((PrimitiveValueContext) ((MuJsParser.GreaterContext) exp).expression(0)).getText();
				long numericBound = 0;

				try {
					numericBound = Long.parseLong(bound);
				} catch (Exception e){

					return new AbstractEnvironment(domain);
				}

				state.put(new Variable(((MuJsParser.GreaterContext) exp).expression(1).getChild(0).getText()), domain.makeInterval(new Interval("-Inf", String.valueOf(numericBound -1))));
				return state;
			}

		}

		// A < B
		if (exp instanceof MuJsParser.LessContext) {
			if (((MuJsParser.LessContext) exp).expression(0) instanceof IdentifierContext && ((MuJsParser.LessContext) exp).expression(1) instanceof PrimitiveValueContext) {

				String bound = ((PrimitiveValueContext) ((MuJsParser.LessContext) exp).expression(1)).getText();

				long numericBound = 0;

				try {
					numericBound = Long.parseLong(bound);
				} catch (Exception e){

					return new AbstractEnvironment(domain);
				}

				state.put(new Variable(((MuJsParser.LessContext) exp).expression(0).getChild(0).getText()), domain.makeInterval(new Interval("-Inf", String.valueOf(numericBound - 1))));
				return state;
			}

			else if (((MuJsParser.LessContext) exp).expression(1) instanceof IdentifierContext && ((MuJsParser.LessContext) exp).expression(0) instanceof PrimitiveValueContext) {

				String bound = ((PrimitiveValueContext) ((MuJsParser.LessContext) exp).expression(0)).getText();
				long numericBound = 0;

				try {
					numericBound = Long.parseLong(bound);
				} catch (Exception e){

					return new AbstractEnvironment(domain);
				}

				state.put(new Variable(((MuJsParser.LessContext) exp).expression(1).getChild(0).getText()), domain.makeInterval(new Interval(String.valueOf(numericBound + 1), "+Inf")));
				return state;
			}

		}

		return new AbstractEnvironment(domain);
	}

	public AbstractEnvironment projectFalseState(MuJsParser.ExpressionContext exp) {
		AbstractEnvironment state = new AbstractEnvironment(domain);

		// A < B
		if (exp instanceof MuJsParser.LessContext) {
			if (((MuJsParser.LessContext) exp).expression(0) instanceof IdentifierContext && ((MuJsParser.LessContext) exp).expression(1) instanceof PrimitiveValueContext) {

				String bound = ((PrimitiveValueContext) ((MuJsParser.LessContext) exp).expression(1)).getText();

				long numericBound = 0;

				try {
					numericBound = Long.parseLong(bound);
				} catch (Exception e){

					return new AbstractEnvironment(domain);
				}

				state.put(new Variable(((MuJsParser.LessContext) exp).expression(0).getChild(0).getText()), domain.makeInterval(new Interval(String.valueOf(numericBound), "+Inf")));
				return state;
			}

			else if (((MuJsParser.LessContext) exp).expression(1) instanceof IdentifierContext && ((MuJsParser.LessContext) exp).expression(0) instanceof PrimitiveValueContext) {

				String bound = ((PrimitiveValueContext) ((MuJsParser.LessContext) exp).expression(0)).getText();
				long numericBound = 0;

				try {
					numericBound = Long.parseLong(bound);
				} catch (Exception e){

					return new AbstractEnvironment(domain);
				}

				state.put(new Variable(((MuJsParser.LessContext) exp).expression(1).getChild(0).getText()), domain.makeInterval(new Interval("-Inf", String.valueOf(numericBound))));
				return state;
			}

		}

		// A > B
		if (exp instanceof MuJsParser.GreaterContext) {
			if (((MuJsParser.GreaterContext) exp).expression(0) instanceof IdentifierContext && ((MuJsParser.GreaterContext) exp).expression(1) instanceof PrimitiveValueContext) {

				String bound = ((PrimitiveValueContext) ((MuJsParser.GreaterContext) exp).expression(1)).getText();

				long numericBound = 0;

				try {
					numericBound = Long.parseLong(bound);
				} catch (Exception e){

					return new AbstractEnvironment(domain);
				}

				state.put(new Variable(((MuJsParser.GreaterContext) exp).expression(0).getChild(0).getText()), domain.makeInterval(new Interval("-Inf", String.valueOf(numericBound))));
				return state;
			}

			else if (((MuJsParser.GreaterContext) exp).expression(1) instanceof IdentifierContext && ((MuJsParser.GreaterContext) exp).expression(0) instanceof PrimitiveValueContext) {

				String bound = ((PrimitiveValueContext) ((MuJsParser.GreaterContext) exp).expression(0)).getText();
				long numericBound = 0;

				try {
					numericBound = Long.parseLong(bound);
				} catch (Exception e){

					return new AbstractEnvironment(domain);
				}

				state.put(new Variable(((MuJsParser.GreaterContext) exp).expression(1).getChild(0).getText()), domain.makeInterval(new Interval(String.valueOf(numericBound), "+Inf")));
				return state;
			}

		}

		return new AbstractEnvironment(domain);
	}
}
