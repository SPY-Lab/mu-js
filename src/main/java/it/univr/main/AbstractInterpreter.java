package it.univr.main;

import java.util.HashMap;
import java.util.Vector;

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
import it.univr.main.MuJsParser.BodyFunctionContext;
import it.univr.state.AbstractEnvironment;
import it.univr.state.AbstractState;
import it.univr.state.CallString;
import it.univr.state.CallStringAbstractEnvironment;
import it.univr.state.Function;
import it.univr.state.KCallStrings;
import it.univr.state.KeyAbstractState;
import it.univr.state.Variable;

public class AbstractInterpreter extends MuJsBaseVisitor<AbstractValue> {

	private CallStringAbstractEnvironment currentEnvironment;
	private AbstractDomain domain;
	private AbstractState state;

	private KCallStrings callStrings = new KCallStrings(new CallString(0,0));

	public AbstractInterpreter(AbstractDomain domain, boolean invariants) {
		this.currentEnvironment = new CallStringAbstractEnvironment(domain);
		this.state = new AbstractState(domain);
		currentEnvironment.put(new CallString(0,0), new AbstractEnvironment(domain));
	}

	public AbstractEnvironment getAbstractEnvironmentAtMainCallString() {
		return currentEnvironment.get(new CallString(0,0));
	}

	public CallStringAbstractEnvironment getCallStringAbstractEnvironment() {
		return currentEnvironment;
	}


	public AbstractState getAbstractState() {
		return state;
	}

	public void setAbstractEnvironement(CallStringAbstractEnvironment env) {
		this.currentEnvironment = env;
	}

	public AbstractDomain getAbstractDomain() {
		return domain;
	}

	public void setAbstractDomain(AbstractDomain domain) {
		this.domain = domain;
	}

	public HashMap<Variable, Function> getFunctions() {
		return state.getFunctions();
	}

	public void printFunctions() {

		if (!state.getFunctions().keySet().isEmpty()) {
			System.out.println("Declared function:");

			for (Function f : state.getFunctions().values())
				System.out.println(f);
		}
	}


	/**
	 * 
	 * MuJS Objects
	 * 
	 */
	@Override 
	public AbstractValue visitPropUpdate(MuJsParser.PropUpdateContext ctx) {

		Variable var = new Variable(ctx.ID().getText());
		AbstractValue allocationSites = currentEnvironment.getStore(getCurrentCallString()).get(var);

		if (allocationSites instanceof AllocationSites) {
			for (AllocationSite l : ((AllocationSites)allocationSites).getAllocationSites()) {

				FA key = new FA(visit(ctx.expression(0)).toString());
				AbstractValue value = visit(ctx.expression(1));

				AbstractValue obj = currentEnvironment.getHeap(getCurrentCallString()).get(l);
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

		if (currentEnvironment.getStore(getCurrentCallString()).containsKey(v)) {
			AbstractValue sites = currentEnvironment.getStore(getCurrentCallString()).get(v);

			if (sites instanceof AllocationSites) {
				for (AllocationSite site: ((AllocationSites)sites).getAllocationSites()) {

					FA key = new FA(visit(ctx.expression()).toString());
					AbstractValue obj = currentEnvironment.get(getCurrentCallString()).getHeap().get(site);
					
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

		currentEnvironment.getStore(getCurrentCallString()).put(var, new AllocationSites(l));
		currentEnvironment.getHeap(getCurrentCallString()).put(l, visit(ctx.object()));

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

		// Get variable name
		Variable v = new Variable(ctx.getChild(0).getText());

		// Get line
		KeyAbstractState key = new KeyAbstractState(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
		CallString currentCallString = getCurrentCallString();

		//		if (!state.contains(key)) {
		//			state.createAbstractEnvironment(key, currentCallString);
		//			state.getCallStringEnvironment(key).put(currentCallString, currentEnvironment.get(currentCallString).clone());
		//		}

		state.add(key, currentEnvironment.get(currentCallString).clone(), currentCallString);

		state.getCallStringEnvironment(key).putVariable(v, visit(ctx.expression()), currentCallString);
		currentEnvironment = state.getCallStringEnvironment(key).clone();

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
		return visit(ctx.stmt(1));
	}

	@Override 
	public AbstractValue visitIfStmt(MuJsParser.IfStmtContext ctx) { 

		Bool evaluationGuard = (Bool) domain.juggleToBool(visit(ctx.expression()));

		if (evaluationGuard.isTrue()) 
			return visit(ctx.block(0));

		if (evaluationGuard.isFalse())
			return visit(ctx.block(1));

		CallStringAbstractEnvironment previous = (CallStringAbstractEnvironment) currentEnvironment.clone();

		visit(ctx.block(0));

		CallStringAbstractEnvironment trueBranch = (CallStringAbstractEnvironment) currentEnvironment.clone();
		currentEnvironment = previous;

		visit(ctx.block(1));

		currentEnvironment = currentEnvironment.leastUpperBound(trueBranch);

		KeyAbstractState key = new KeyAbstractState(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
		state.add(key, currentEnvironment.get(getCurrentCallString()).clone(), getCurrentCallString());

		return new Bottom();
	}

	@Override 
	public AbstractValue visitProgramExecution(MuJsParser.ProgramExecutionContext ctx) {
		return visit(ctx.stmt()); 
	}

	@Override 
	public AbstractValue visitWhileStmt(MuJsParser.WhileStmtContext ctx) { 

		CallStringAbstractEnvironment previous = (CallStringAbstractEnvironment) currentEnvironment.clone();

		AbstractValue guard = domain.juggleToBool(visit(ctx.expression()));

		do {
			/**
			 * True
			 */
			if (domain.isTrue(guard)) {
				visit(ctx.block());
				currentEnvironment = previous.widening(currentEnvironment);
			} 

			/**
			 * False
			 */
			else if (domain.isFalse(guard)) {
				break;
			} 

			/**
			 * Top
			 */
			else if (domain.isTopBool(guard)) {
				visit(ctx.block());
				currentEnvironment = previous.widening(previous.leastUpperBound(currentEnvironment));
			}

			if (previous.equals(currentEnvironment))
				break;
			else
				previous = currentEnvironment.clone();
		} while (true);

		KeyAbstractState key = new KeyAbstractState(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
		state.add(key, currentEnvironment.get(getCurrentCallString()).clone(), getCurrentCallString());

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
		CallString currentCallString = getCurrentCallString();



		if (currentEnvironment.getStore(currentCallString).containsKey(v))
			return currentEnvironment.getStore(currentCallString).get(v);
		else {
			System.out.println(v + " " + currentCallString + " " + currentEnvironment.getStore(currentCallString));
			return new Bottom();
		}
	}

	@Override 
	public AbstractValue visitParenthesis(MuJsParser.ParenthesisContext ctx) {
		return visit(ctx.expression()); 
	}

	@Override 
	public AbstractValue visitNaN(MuJsParser.NaNContext ctx) { 
		return domain.makeNaN(new NaN());
	}


	@Override
	public AbstractValue visitReturn(MuJsParser.ReturnContext ctx) {
		return visit(ctx.expression()); 
	}

	@Override 
	public AbstractValue visitFunctionDeclaration(MuJsParser.FunctionDeclarationContext ctx) { 

		Variable name = new Variable(ctx.ID(0).getText());
		BodyFunctionContext body = (BodyFunctionContext) ctx.bodyfunction();
		Vector<Variable> formalParameters = new Vector<Variable>();

		for (int i = 1; i < ctx.ID().size(); i++)
			formalParameters.add(new Variable(ctx.ID(i).getText()));

		Function function = new Function(name, formalParameters, body);

		state.addFunction(name, function);
		return new Bottom();
	}

	@Override 
	public AbstractValue visitBodyFunction(MuJsParser.BodyFunctionContext ctx) { 
		if (ctx.stmt() != null)
			visit(ctx.stmt());
		return visit(ctx.ret());
	}


	@Override 
	public AbstractValue visitFunctionCall(MuJsParser.FunctionCallContext ctx) { 
		CallStringAbstractEnvironment old = currentEnvironment.clone();

		CallString currentCallString = getCurrentCallString();

		Function f = state.getFunction(new Variable(ctx.ID().getText()));
		CallString newCallString = new CallString(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());


		KeyAbstractState key = new KeyAbstractState(f.getBody().getStart().getLine(), f.getBody().getStart().getCharPositionInLine());
		state.add(key, currentEnvironment.get(currentCallString).clone(), newCallString);

		for (int i = 0; i < f.getFormalParameters().size(); i++) {
			state.getCallStringEnvironment(key).putVariable(f.getFormalParameters().get(i), visit(ctx.expression(i)), newCallString);
		}

		currentEnvironment = state.getCallStringEnvironment(key).clone();

		incrementCallString(newCallString);
		AbstractValue returnValue = visit(f.getBody());
		decreaseCallString();

		for (int i = 0; i < f.getFormalParameters().size(); i++) 
			currentEnvironment.removeVariable(f.getFormalParameters().get(i), newCallString);


		currentEnvironment = old;
		return returnValue; 
	}

	private CallString getCurrentCallString() {
		return callStrings.get(callStrings.size() -1);
	}

	private void incrementCallString(CallString cs) {
		callStrings.add(cs);
	}

	private void decreaseCallString() {
		callStrings.removeElementAt(callStrings.size() -1);
	}

}
