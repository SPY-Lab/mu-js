// Generated from ./venice/mu-js/src/main/java/it/univr/main/MuJs.g4 by ANTLR 4.7.2

    package it.univr.main;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MuJsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		EOL_COMMENT=32, NAN=33, BOOL=34, ID=35, SIGN=36, INT=37, STRING=38, WS=39;
	public static final int
		RULE_program = 0, RULE_val = 1, RULE_object = 2, RULE_expression = 3, 
		RULE_stmt = 4, RULE_block = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "val", "object", "expression", "stmt", "block"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "':'", "';'", "'.'", "'substring'", "'('", "','", 
			"')'", "'charAt'", "'indexOf'", "'length'", "'=='", "'+'", "'-'", "'*'", 
			"'/'", "'>'", "'<'", "'&&'", "'||'", "'!'", "'['", "']'", "'='", "'if'", 
			"'else'", "'while'", "'return'", "'new'", "'function'", null, "'NaN'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "EOL_COMMENT", "NAN", 
			"BOOL", "ID", "SIGN", "INT", "STRING", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MuJs.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MuJsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	 
		public ProgramContext() { }
		public void copyFrom(ProgramContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ProgramExecutionContext extends ProgramContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MuJsParser.EOF, 0); }
		public ProgramExecutionContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterProgramExecution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitProgramExecution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitProgramExecution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			_localctx = new ProgramExecutionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			stmt(0);
			setState(13);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValContext extends ParserRuleContext {
		public ValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val; }
	 
		public ValContext() { }
		public void copyFrom(ValContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntegerContext extends ValContext {
		public TerminalNode INT() { return getToken(MuJsParser.INT, 0); }
		public IntegerContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NaNContext extends ValContext {
		public TerminalNode NAN() { return getToken(MuJsParser.NAN, 0); }
		public NaNContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterNaN(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitNaN(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitNaN(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends ValContext {
		public TerminalNode STRING() { return getToken(MuJsParser.STRING, 0); }
		public StringContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanContext extends ValContext {
		public TerminalNode BOOL() { return getToken(MuJsParser.BOOL, 0); }
		public BooleanContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_val);
		try {
			setState(19);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(15);
				match(INT);
				}
				break;
			case BOOL:
				_localctx = new BooleanContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(16);
				match(BOOL);
				}
				break;
			case STRING:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(17);
				match(STRING);
				}
				break;
			case NAN:
				_localctx = new NaNContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(18);
				match(NAN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectContext extends ParserRuleContext {
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
	 
		public ObjectContext() { }
		public void copyFrom(ObjectContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EmptyObjectContext extends ObjectContext {
		public EmptyObjectContext(ObjectContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterEmptyObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitEmptyObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitEmptyObject(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ObjContext extends ObjectContext {
		public List<TerminalNode> ID() { return getTokens(MuJsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MuJsParser.ID, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ObjContext(ObjectContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitObj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitObj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_object);
		int _la;
		try {
			setState(39);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new EmptyObjectContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(21);
				match(T__0);
				setState(22);
				match(T__1);
				}
				break;
			case 2:
				_localctx = new ObjContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
				match(T__0);
				{
				setState(24);
				match(ID);
				setState(25);
				match(T__2);
				setState(26);
				expression(0);
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(28);
					match(T__3);
					setState(29);
					match(ID);
					setState(30);
					match(T__2);
					setState(31);
					expression(0);
					}
					}
					setState(36);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(37);
				match(T__1);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubstringContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SubstringContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterSubstring(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitSubstring(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitSubstring(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DiffContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DiffContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterDiff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitDiff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitDiff(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MulContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitMul(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitMul(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndexOfContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IndexOfContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterIndexOf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitIndexOf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitIndexOf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SumContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SumContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitSum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitSum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimitiveValueContext extends ExpressionContext {
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public PrimitiveValueContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterPrimitiveValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitPrimitiveValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitPrimitiveValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DivContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesisContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualsContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EqualsContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterEquals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitEquals(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitEquals(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(MuJsParser.ID, 0); }
		public IdentifierContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PropLookupContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(MuJsParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PropLookupContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterPropLookup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitPropLookup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitPropLookup(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharAtContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CharAtContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterCharAt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitCharAt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitCharAt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LengthContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LengthContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterLength(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitLength(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitLength(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public GreaterContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterGreater(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitGreater(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitGreater(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(MuJsParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunctionCallContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ObjectExpressionContext extends ExpressionContext {
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public ObjectExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterObjectExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitObjectExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitObjectExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterLess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitLess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitLess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(42);
				match(T__6);
				setState(43);
				expression(0);
				setState(44);
				match(T__8);
				}
				break;
			case 2:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(46);
				match(ID);
				}
				break;
			case 3:
				{
				_localctx = new PrimitiveValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(47);
				val();
				}
				break;
			case 4:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48);
				match(T__21);
				setState(49);
				expression(4);
				}
				break;
			case 5:
				{
				_localctx = new ObjectExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(50);
				object();
				}
				break;
			case 6:
				{
				_localctx = new PropLookupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51);
				match(ID);
				setState(52);
				match(T__22);
				setState(53);
				expression(0);
				setState(54);
				match(T__23);
				}
				break;
			case 7:
				{
				_localctx = new FunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				match(ID);
				setState(57);
				match(T__6);
				setState(58);
				expression(0);
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(59);
					match(T__7);
					setState(60);
					expression(0);
					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(66);
				match(T__8);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(125);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(123);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new EqualsContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(70);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(71);
						match(T__12);
						setState(72);
						expression(16);
						}
						break;
					case 2:
						{
						_localctx = new SumContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(73);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(74);
						match(T__13);
						setState(75);
						expression(13);
						}
						break;
					case 3:
						{
						_localctx = new DiffContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(76);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(77);
						match(T__14);
						setState(78);
						expression(12);
						}
						break;
					case 4:
						{
						_localctx = new MulContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(79);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(80);
						match(T__15);
						setState(81);
						expression(11);
						}
						break;
					case 5:
						{
						_localctx = new DivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(82);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(83);
						match(T__16);
						setState(84);
						expression(10);
						}
						break;
					case 6:
						{
						_localctx = new GreaterContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(85);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(86);
						match(T__17);
						setState(87);
						expression(9);
						}
						break;
					case 7:
						{
						_localctx = new LessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(88);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(89);
						match(T__18);
						setState(90);
						expression(8);
						}
						break;
					case 8:
						{
						_localctx = new AndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(91);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(92);
						match(T__19);
						setState(93);
						expression(7);
						}
						break;
					case 9:
						{
						_localctx = new OrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(94);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(95);
						match(T__20);
						setState(96);
						expression(6);
						}
						break;
					case 10:
						{
						_localctx = new SubstringContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(97);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(98);
						match(T__4);
						setState(99);
						match(T__5);
						setState(100);
						match(T__6);
						setState(101);
						expression(0);
						setState(102);
						match(T__7);
						setState(103);
						expression(0);
						setState(104);
						match(T__8);
						}
						break;
					case 11:
						{
						_localctx = new CharAtContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(106);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(107);
						match(T__4);
						setState(108);
						match(T__9);
						setState(109);
						match(T__6);
						setState(110);
						expression(0);
						setState(111);
						match(T__8);
						}
						break;
					case 12:
						{
						_localctx = new IndexOfContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(113);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(114);
						match(T__4);
						setState(115);
						match(T__10);
						setState(116);
						match(T__6);
						setState(117);
						expression(0);
						setState(118);
						match(T__8);
						}
						break;
					case 13:
						{
						_localctx = new LengthContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(120);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(121);
						match(T__4);
						setState(122);
						match(T__11);
						}
						break;
					}
					} 
				}
				setState(127);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunctionDeclarationContext extends StmtContext {
		public List<TerminalNode> ID() { return getTokens(MuJsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MuJsParser.ID, i);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public FunctionDeclarationContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PropUpdateContext extends StmtContext {
		public TerminalNode ID() { return getToken(MuJsParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PropUpdateContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterPropUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitPropUpdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitPropUpdate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompositionContext extends StmtContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public CompositionContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterComposition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitComposition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitComposition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStmtContext extends StmtContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStmtContext extends StmtContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStmtContext extends StmtContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterBlockStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitBlockStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitBlockStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentStmtContext extends StmtContext {
		public TerminalNode ID() { return getToken(MuJsParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterAssignmentStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitAssignmentStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitAssignmentStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStmtContext extends StmtContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ObjectAsgContext extends StmtContext {
		public TerminalNode ID() { return getToken(MuJsParser.ID, 0); }
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public ObjectAsgContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterObjectAsg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitObjectAsg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitObjectAsg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		return stmt(0);
	}

	private StmtContext stmt(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StmtContext _localctx = new StmtContext(_ctx, _parentState);
		StmtContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_stmt, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new AssignmentStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(129);
				match(ID);
				setState(130);
				match(T__24);
				setState(131);
				expression(0);
				setState(132);
				match(T__3);
				}
				break;
			case 2:
				{
				_localctx = new IfStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(134);
				match(T__25);
				setState(135);
				match(T__6);
				setState(136);
				expression(0);
				setState(137);
				match(T__8);
				setState(138);
				block();
				setState(139);
				match(T__26);
				setState(140);
				block();
				}
				break;
			case 3:
				{
				_localctx = new WhileStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				match(T__27);
				setState(143);
				match(T__6);
				setState(144);
				expression(0);
				setState(145);
				match(T__8);
				setState(146);
				block();
				}
				break;
			case 4:
				{
				_localctx = new BlockStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148);
				block();
				}
				break;
			case 5:
				{
				_localctx = new ReturnStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149);
				match(T__28);
				setState(150);
				expression(0);
				setState(151);
				match(T__3);
				}
				break;
			case 6:
				{
				_localctx = new ObjectAsgContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153);
				match(ID);
				setState(154);
				match(T__24);
				setState(155);
				match(T__29);
				setState(156);
				object();
				setState(157);
				match(T__3);
				}
				break;
			case 7:
				{
				_localctx = new PropUpdateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				match(ID);
				setState(160);
				match(T__22);
				setState(161);
				expression(0);
				setState(162);
				match(T__23);
				setState(163);
				match(T__24);
				setState(164);
				expression(0);
				setState(165);
				match(T__3);
				}
				break;
			case 8:
				{
				_localctx = new FunctionDeclarationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167);
				match(T__30);
				setState(168);
				match(ID);
				setState(169);
				match(T__6);
				setState(170);
				match(ID);
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(171);
					match(T__7);
					setState(172);
					match(ID);
					}
					}
					setState(177);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(178);
				match(T__8);
				setState(179);
				match(T__0);
				setState(180);
				stmt(0);
				setState(181);
				match(T__1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CompositionContext(new StmtContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_stmt);
					setState(185);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(186);
					stmt(4);
					}
					} 
				}
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MuJsListener ) ((MuJsListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MuJsVisitor ) return ((MuJsVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		try {
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				match(T__0);
				setState(193);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				match(T__0);
				setState(195);
				stmt(0);
				setState(196);
				match(T__1);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 4:
			return stmt_sempred((StmtContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 20);
		case 10:
			return precpred(_ctx, 19);
		case 11:
			return precpred(_ctx, 18);
		case 12:
			return precpred(_ctx, 17);
		}
		return true;
	}
	private boolean stmt_sempred(StmtContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u00cb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3"+
		"\26\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4#\n\4\f\4\16\4"+
		"&\13\4\3\4\3\4\5\4*\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5@\n\5\f\5\16\5C\13\5\3\5\3\5\5\5"+
		"G\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\7\5~\n\5\f\5\16\5\u0081\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\7\6\u00b0\n\6\f\6\16\6\u00b3\13\6\3\6\3\6\3\6\3\6\3\6\5\6\u00ba"+
		"\n\6\3\6\3\6\7\6\u00be\n\6\f\6\16\6\u00c1\13\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\5\7\u00c9\n\7\3\7\2\4\b\n\b\2\4\6\b\n\f\2\2\2\u00e7\2\16\3\2\2\2\4\25"+
		"\3\2\2\2\6)\3\2\2\2\bF\3\2\2\2\n\u00b9\3\2\2\2\f\u00c8\3\2\2\2\16\17\5"+
		"\n\6\2\17\20\7\2\2\3\20\3\3\2\2\2\21\26\7\'\2\2\22\26\7$\2\2\23\26\7("+
		"\2\2\24\26\7#\2\2\25\21\3\2\2\2\25\22\3\2\2\2\25\23\3\2\2\2\25\24\3\2"+
		"\2\2\26\5\3\2\2\2\27\30\7\3\2\2\30*\7\4\2\2\31\32\7\3\2\2\32\33\7%\2\2"+
		"\33\34\7\5\2\2\34\35\5\b\5\2\35$\3\2\2\2\36\37\7\6\2\2\37 \7%\2\2 !\7"+
		"\5\2\2!#\5\b\5\2\"\36\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\'\3\2\2"+
		"\2&$\3\2\2\2\'(\7\4\2\2(*\3\2\2\2)\27\3\2\2\2)\31\3\2\2\2*\7\3\2\2\2+"+
		",\b\5\1\2,-\7\t\2\2-.\5\b\5\2./\7\13\2\2/G\3\2\2\2\60G\7%\2\2\61G\5\4"+
		"\3\2\62\63\7\30\2\2\63G\5\b\5\6\64G\5\6\4\2\65\66\7%\2\2\66\67\7\31\2"+
		"\2\678\5\b\5\289\7\32\2\29G\3\2\2\2:;\7%\2\2;<\7\t\2\2<A\5\b\5\2=>\7\n"+
		"\2\2>@\5\b\5\2?=\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2"+
		"\2\2DE\7\13\2\2EG\3\2\2\2F+\3\2\2\2F\60\3\2\2\2F\61\3\2\2\2F\62\3\2\2"+
		"\2F\64\3\2\2\2F\65\3\2\2\2F:\3\2\2\2G\177\3\2\2\2HI\f\21\2\2IJ\7\17\2"+
		"\2J~\5\b\5\22KL\f\16\2\2LM\7\20\2\2M~\5\b\5\17NO\f\r\2\2OP\7\21\2\2P~"+
		"\5\b\5\16QR\f\f\2\2RS\7\22\2\2S~\5\b\5\rTU\f\13\2\2UV\7\23\2\2V~\5\b\5"+
		"\fWX\f\n\2\2XY\7\24\2\2Y~\5\b\5\13Z[\f\t\2\2[\\\7\25\2\2\\~\5\b\5\n]^"+
		"\f\b\2\2^_\7\26\2\2_~\5\b\5\t`a\f\7\2\2ab\7\27\2\2b~\5\b\5\bcd\f\26\2"+
		"\2de\7\7\2\2ef\7\b\2\2fg\7\t\2\2gh\5\b\5\2hi\7\n\2\2ij\5\b\5\2jk\7\13"+
		"\2\2k~\3\2\2\2lm\f\25\2\2mn\7\7\2\2no\7\f\2\2op\7\t\2\2pq\5\b\5\2qr\7"+
		"\13\2\2r~\3\2\2\2st\f\24\2\2tu\7\7\2\2uv\7\r\2\2vw\7\t\2\2wx\5\b\5\2x"+
		"y\7\13\2\2y~\3\2\2\2z{\f\23\2\2{|\7\7\2\2|~\7\16\2\2}H\3\2\2\2}K\3\2\2"+
		"\2}N\3\2\2\2}Q\3\2\2\2}T\3\2\2\2}W\3\2\2\2}Z\3\2\2\2}]\3\2\2\2}`\3\2\2"+
		"\2}c\3\2\2\2}l\3\2\2\2}s\3\2\2\2}z\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2"+
		"\177\u0080\3\2\2\2\u0080\t\3\2\2\2\u0081\177\3\2\2\2\u0082\u0083\b\6\1"+
		"\2\u0083\u0084\7%\2\2\u0084\u0085\7\33\2\2\u0085\u0086\5\b\5\2\u0086\u0087"+
		"\7\6\2\2\u0087\u00ba\3\2\2\2\u0088\u0089\7\34\2\2\u0089\u008a\7\t\2\2"+
		"\u008a\u008b\5\b\5\2\u008b\u008c\7\13\2\2\u008c\u008d\5\f\7\2\u008d\u008e"+
		"\7\35\2\2\u008e\u008f\5\f\7\2\u008f\u00ba\3\2\2\2\u0090\u0091\7\36\2\2"+
		"\u0091\u0092\7\t\2\2\u0092\u0093\5\b\5\2\u0093\u0094\7\13\2\2\u0094\u0095"+
		"\5\f\7\2\u0095\u00ba\3\2\2\2\u0096\u00ba\5\f\7\2\u0097\u0098\7\37\2\2"+
		"\u0098\u0099\5\b\5\2\u0099\u009a\7\6\2\2\u009a\u00ba\3\2\2\2\u009b\u009c"+
		"\7%\2\2\u009c\u009d\7\33\2\2\u009d\u009e\7 \2\2\u009e\u009f\5\6\4\2\u009f"+
		"\u00a0\7\6\2\2\u00a0\u00ba\3\2\2\2\u00a1\u00a2\7%\2\2\u00a2\u00a3\7\31"+
		"\2\2\u00a3\u00a4\5\b\5\2\u00a4\u00a5\7\32\2\2\u00a5\u00a6\7\33\2\2\u00a6"+
		"\u00a7\5\b\5\2\u00a7\u00a8\7\6\2\2\u00a8\u00ba\3\2\2\2\u00a9\u00aa\7!"+
		"\2\2\u00aa\u00ab\7%\2\2\u00ab\u00ac\7\t\2\2\u00ac\u00b1\7%\2\2\u00ad\u00ae"+
		"\7\n\2\2\u00ae\u00b0\7%\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b1\3\2"+
		"\2\2\u00b4\u00b5\7\13\2\2\u00b5\u00b6\7\3\2\2\u00b6\u00b7\5\n\6\2\u00b7"+
		"\u00b8\7\4\2\2\u00b8\u00ba\3\2\2\2\u00b9\u0082\3\2\2\2\u00b9\u0088\3\2"+
		"\2\2\u00b9\u0090\3\2\2\2\u00b9\u0096\3\2\2\2\u00b9\u0097\3\2\2\2\u00b9"+
		"\u009b\3\2\2\2\u00b9\u00a1\3\2\2\2\u00b9\u00a9\3\2\2\2\u00ba\u00bf\3\2"+
		"\2\2\u00bb\u00bc\f\6\2\2\u00bc\u00be\5\n\6\6\u00bd\u00bb\3\2\2\2\u00be"+
		"\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\13\3\2\2"+
		"\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3\7\3\2\2\u00c3\u00c9\7\4\2\2\u00c4\u00c5"+
		"\7\3\2\2\u00c5\u00c6\5\n\6\2\u00c6\u00c7\7\4\2\2\u00c7\u00c9\3\2\2\2\u00c8"+
		"\u00c2\3\2\2\2\u00c8\u00c4\3\2\2\2\u00c9\r\3\2\2\2\r\25$)AF}\177\u00b1"+
		"\u00b9\u00bf\u00c8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}