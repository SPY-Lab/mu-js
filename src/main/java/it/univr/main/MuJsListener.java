// Generated from MuJs.g4 by ANTLR 4.4
package it.univr.main;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MuJsParser}.
 */
public interface MuJsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Substring}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubstring(@NotNull MuJsParser.SubstringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Substring}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubstring(@NotNull MuJsParser.SubstringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Composition}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterComposition(@NotNull MuJsParser.CompositionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Composition}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitComposition(@NotNull MuJsParser.CompositionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Diff}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDiff(@NotNull MuJsParser.DiffContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Diff}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDiff(@NotNull MuJsParser.DiffContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMul(@NotNull MuJsParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMul(@NotNull MuJsParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexOf}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndexOf(@NotNull MuJsParser.IndexOfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexOf}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndexOf(@NotNull MuJsParser.IndexOfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(@NotNull MuJsParser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(@NotNull MuJsParser.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSum(@NotNull MuJsParser.SumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSum(@NotNull MuJsParser.SumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 */
	void enterString(@NotNull MuJsParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 */
	void exitString(@NotNull MuJsParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimitiveValue}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveValue(@NotNull MuJsParser.PrimitiveValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimitiveValue}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveValue(@NotNull MuJsParser.PrimitiveValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 */
	void enterInteger(@NotNull MuJsParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 */
	void exitInteger(@NotNull MuJsParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Div}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDiv(@NotNull MuJsParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDiv(@NotNull MuJsParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNot(@NotNull MuJsParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNot(@NotNull MuJsParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(@NotNull MuJsParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(@NotNull MuJsParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(@NotNull MuJsParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(@NotNull MuJsParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ProgramExecution}
	 * labeled alternative in {@link MuJsParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgramExecution(@NotNull MuJsParser.ProgramExecutionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ProgramExecution}
	 * labeled alternative in {@link MuJsParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgramExecution(@NotNull MuJsParser.ProgramExecutionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CharAt}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCharAt(@NotNull MuJsParser.CharAtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CharAt}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCharAt(@NotNull MuJsParser.CharAtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Length}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLength(@NotNull MuJsParser.LengthContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Length}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLength(@NotNull MuJsParser.LengthContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(@NotNull MuJsParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(@NotNull MuJsParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd(@NotNull MuJsParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd(@NotNull MuJsParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStmt(@NotNull MuJsParser.AssignmentStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStmt(@NotNull MuJsParser.AssignmentStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MuJsParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull MuJsParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MuJsParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull MuJsParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(@NotNull MuJsParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(@NotNull MuJsParser.BooleanContext ctx);
}