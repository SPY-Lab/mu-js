// Generated from MuJs.g4 by ANTLR 4.4

    package it.univr.main;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MuJsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MuJsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code AExp}
	 * labeled alternative in {@link MuJsParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAExp(@NotNull MuJsParser.AExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(@NotNull MuJsParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdBExp}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdBExp(@NotNull MuJsParser.IdBExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Diff}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiff(@NotNull MuJsParser.DiffContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SExpPar}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSExpPar(@NotNull MuJsParser.SExpParContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(@NotNull MuJsParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BExpPar}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBExpPar(@NotNull MuJsParser.BExpParContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Str}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStr(@NotNull MuJsParser.StrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Concat}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcat(@NotNull MuJsParser.ConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(@NotNull MuJsParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(@NotNull MuJsParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MuJsParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull MuJsParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Less}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLess(@NotNull MuJsParser.LessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Composition}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComposition(@NotNull MuJsParser.CompositionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BExp}
	 * labeled alternative in {@link MuJsParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBExp(@NotNull MuJsParser.BExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(@NotNull MuJsParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdAExp}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAExp(@NotNull MuJsParser.IdAExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AExpPar}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAExpPar(@NotNull MuJsParser.AExpParContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(@NotNull MuJsParser.BlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum(@NotNull MuJsParser.SumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SExp}
	 * labeled alternative in {@link MuJsParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSExp(@NotNull MuJsParser.SExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(@NotNull MuJsParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(@NotNull MuJsParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquals(@NotNull MuJsParser.EqualsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(@NotNull MuJsParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ProgramExecution}
	 * labeled alternative in {@link MuJsParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramExecution(@NotNull MuJsParser.ProgramExecutionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(@NotNull MuJsParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToNum}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToNum(@NotNull MuJsParser.ToNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStmt(@NotNull MuJsParser.AssignmentStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdSExp}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdSExp(@NotNull MuJsParser.IdSExpContext ctx);
}