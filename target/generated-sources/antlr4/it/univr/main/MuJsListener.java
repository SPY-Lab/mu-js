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
	 * Enter a parse tree produced by the {@code AExp}
	 * labeled alternative in {@link MuJsParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterAExp(@NotNull MuJsParser.AExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AExp}
	 * labeled alternative in {@link MuJsParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitAExp(@NotNull MuJsParser.AExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull MuJsParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull MuJsParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdBExp}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void enterIdBExp(@NotNull MuJsParser.IdBExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdBExp}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void exitIdBExp(@NotNull MuJsParser.IdBExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Diff}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterDiff(@NotNull MuJsParser.DiffContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Diff}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitDiff(@NotNull MuJsParser.DiffContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SExpPar}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterSExpPar(@NotNull MuJsParser.SExpParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SExpPar}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitSExpPar(@NotNull MuJsParser.SExpParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterInt(@NotNull MuJsParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitInt(@NotNull MuJsParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BExpPar}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void enterBExpPar(@NotNull MuJsParser.BExpParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BExpPar}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void exitBExpPar(@NotNull MuJsParser.BExpParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Str}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterStr(@NotNull MuJsParser.StrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Str}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitStr(@NotNull MuJsParser.StrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Concat}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterConcat(@NotNull MuJsParser.ConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Concat}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitConcat(@NotNull MuJsParser.ConcatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void enterBool(@NotNull MuJsParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void exitBool(@NotNull MuJsParser.BoolContext ctx);
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
	 * Enter a parse tree produced by the {@code Less}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void enterLess(@NotNull MuJsParser.LessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Less}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void exitLess(@NotNull MuJsParser.LessContext ctx);
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
	 * Enter a parse tree produced by the {@code BExp}
	 * labeled alternative in {@link MuJsParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBExp(@NotNull MuJsParser.BExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BExp}
	 * labeled alternative in {@link MuJsParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBExp(@NotNull MuJsParser.BExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterMul(@NotNull MuJsParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitMul(@NotNull MuJsParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdAExp}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterIdAExp(@NotNull MuJsParser.IdAExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdAExp}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitIdAExp(@NotNull MuJsParser.IdAExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AExpPar}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterAExpPar(@NotNull MuJsParser.AExpParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AExpPar}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitAExpPar(@NotNull MuJsParser.AExpParContext ctx);
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
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterSum(@NotNull MuJsParser.SumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitSum(@NotNull MuJsParser.SumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SExp}
	 * labeled alternative in {@link MuJsParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSExp(@NotNull MuJsParser.SExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SExp}
	 * labeled alternative in {@link MuJsParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSExp(@NotNull MuJsParser.SExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Div}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterDiv(@NotNull MuJsParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitDiv(@NotNull MuJsParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void enterNot(@NotNull MuJsParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void exitNot(@NotNull MuJsParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void enterEquals(@NotNull MuJsParser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void exitEquals(@NotNull MuJsParser.EqualsContext ctx);
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
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void enterAnd(@NotNull MuJsParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void exitAnd(@NotNull MuJsParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToNum}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterToNum(@NotNull MuJsParser.ToNumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToNum}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitToNum(@NotNull MuJsParser.ToNumContext ctx);
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
	 * Enter a parse tree produced by the {@code IdSExp}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterIdSExp(@NotNull MuJsParser.IdSExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdSExp}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitIdSExp(@NotNull MuJsParser.IdSExpContext ctx);
}