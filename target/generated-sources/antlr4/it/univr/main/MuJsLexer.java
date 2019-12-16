// Generated from MuJs.g4 by ANTLR 4.4

    package it.univr.main;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MuJsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__17=1, T__16=2, T__15=3, T__14=4, T__13=5, T__12=6, T__11=7, T__10=8, 
		T__9=9, T__8=10, T__7=11, T__6=12, T__5=13, T__4=14, T__3=15, T__2=16, 
		T__1=17, T__0=18, ASG=19, NAN=20, BOOL=21, SEMICOLON=22, ID=23, SIGN=24, 
		INT=25, STRING=26, LESS=27, WS=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'"
	};
	public static final String[] ruleNames = {
		"T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", 
		"T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", 
		"T__0", "ASG", "NAN", "BOOL", "SEMICOLON", "ID", "SIGN", "INT", "STRING", 
		"LESS", "WS"
	};


	public MuJsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MuJs.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u00b1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3"+
		"\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\5\26\u0084\n\26\3\27\3\27\3\30\6\30\u0089\n\30\r\30"+
		"\16\30\u008a\3\31\3\31\3\32\5\32\u0090\n\32\3\32\6\32\u0093\n\32\r\32"+
		"\16\32\u0094\3\33\3\33\7\33\u0099\n\33\f\33\16\33\u009c\13\33\3\33\3\33"+
		"\3\33\7\33\u00a1\n\33\f\33\16\33\u00a4\13\33\3\33\5\33\u00a7\n\33\3\34"+
		"\3\34\3\35\6\35\u00ac\n\35\r\35\16\35\u00ad\3\35\3\35\2\2\36\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36\3\2\b\3\2c|"+
		"\4\2--//\3\2\62;\5\2\f\f\17\17$$\4\2\f\f\17\17\5\2\13\f\17\17\"\"\u00b8"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3;\3"+
		"\2\2\2\5=\3\2\2\2\7?\3\2\2\2\tE\3\2\2\2\13H\3\2\2\2\rK\3\2\2\2\17N\3\2"+
		"\2\2\21P\3\2\2\2\23S\3\2\2\2\25[\3\2\2\2\27]\3\2\2\2\31b\3\2\2\2\33d\3"+
		"\2\2\2\35f\3\2\2\2\37l\3\2\2\2!n\3\2\2\2#p\3\2\2\2%r\3\2\2\2\'t\3\2\2"+
		"\2)v\3\2\2\2+\u0083\3\2\2\2-\u0085\3\2\2\2/\u0088\3\2\2\2\61\u008c\3\2"+
		"\2\2\63\u008f\3\2\2\2\65\u00a6\3\2\2\2\67\u00a8\3\2\2\29\u00ab\3\2\2\2"+
		";<\7\61\2\2<\4\3\2\2\2=>\7}\2\2>\6\3\2\2\2?@\7y\2\2@A\7j\2\2AB\7k\2\2"+
		"BC\7n\2\2CD\7g\2\2D\b\3\2\2\2EF\7~\2\2FG\7~\2\2G\n\3\2\2\2HI\7(\2\2IJ"+
		"\7(\2\2J\f\3\2\2\2KL\7?\2\2LM\7?\2\2M\16\3\2\2\2NO\7\177\2\2O\20\3\2\2"+
		"\2PQ\7k\2\2QR\7h\2\2R\22\3\2\2\2ST\7e\2\2TU\7q\2\2UV\7p\2\2VW\7e\2\2W"+
		"X\7c\2\2XY\7v\2\2YZ\7*\2\2Z\24\3\2\2\2[\\\7#\2\2\\\26\3\2\2\2]^\7g\2\2"+
		"^_\7n\2\2_`\7u\2\2`a\7g\2\2a\30\3\2\2\2bc\7*\2\2c\32\3\2\2\2de\7+\2\2"+
		"e\34\3\2\2\2fg\7v\2\2gh\7q\2\2hi\7P\2\2ij\7w\2\2jk\7o\2\2k\36\3\2\2\2"+
		"lm\7,\2\2m \3\2\2\2no\7-\2\2o\"\3\2\2\2pq\7.\2\2q$\3\2\2\2rs\7/\2\2s&"+
		"\3\2\2\2tu\7?\2\2u(\3\2\2\2vw\7P\2\2wx\7c\2\2xy\7P\2\2y*\3\2\2\2z{\7v"+
		"\2\2{|\7t\2\2|}\7w\2\2}\u0084\7g\2\2~\177\7h\2\2\177\u0080\7c\2\2\u0080"+
		"\u0081\7n\2\2\u0081\u0082\7u\2\2\u0082\u0084\7g\2\2\u0083z\3\2\2\2\u0083"+
		"~\3\2\2\2\u0084,\3\2\2\2\u0085\u0086\7=\2\2\u0086.\3\2\2\2\u0087\u0089"+
		"\t\2\2\2\u0088\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\60\3\2\2\2\u008c\u008d\t\3\2\2\u008d\62\3\2\2\2\u008e"+
		"\u0090\5\61\31\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3"+
		"\2\2\2\u0091\u0093\t\4\2\2\u0092\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\64\3\2\2\2\u0096\u009a\7$\2\2"+
		"\u0097\u0099\n\5\2\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098"+
		"\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u009a\3\2\2\2\u009d"+
		"\u00a7\7$\2\2\u009e\u00a2\7)\2\2\u009f\u00a1\n\6\2\2\u00a0\u009f\3\2\2"+
		"\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5"+
		"\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a7\7)\2\2\u00a6\u0096\3\2\2\2\u00a6"+
		"\u009e\3\2\2\2\u00a7\66\3\2\2\2\u00a8\u00a9\7>\2\2\u00a98\3\2\2\2\u00aa"+
		"\u00ac\t\7\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ab\3\2"+
		"\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\b\35\2\2\u00b0"+
		":\3\2\2\2\13\2\u0083\u008a\u008f\u0094\u009a\u00a2\u00a6\u00ad\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}