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
	 * Visit a parse tree produced by the {@code PropUpdate}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropUpdate(@NotNull MuJsParser.PropUpdateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(@NotNull MuJsParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Diff}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiff(@NotNull MuJsParser.DiffContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(@NotNull MuJsParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(@NotNull MuJsParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(@NotNull MuJsParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PropLookup}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropLookup(@NotNull MuJsParser.PropLookupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyObject}
	 * labeled alternative in {@link MuJsParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyObject(@NotNull MuJsParser.EmptyObjectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(@NotNull MuJsParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Obj}
	 * labeled alternative in {@link MuJsParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObj(@NotNull MuJsParser.ObjContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NaN}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNaN(@NotNull MuJsParser.NaNContext ctx);
	/**
	 * Visit a parse tree produced by {@link MuJsParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull MuJsParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(@NotNull MuJsParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Less}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLess(@NotNull MuJsParser.LessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Substring}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstring(@NotNull MuJsParser.SubstringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Composition}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComposition(@NotNull MuJsParser.CompositionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(@NotNull MuJsParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexOf}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOf(@NotNull MuJsParser.IndexOfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(@NotNull MuJsParser.BlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum(@NotNull MuJsParser.SumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimitiveValue}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveValue(@NotNull MuJsParser.PrimitiveValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(@NotNull MuJsParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(@NotNull MuJsParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(@NotNull MuJsParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link MuJsParser#expression}.
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
	 * Visit a parse tree produced by the {@code CharAt}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharAt(@NotNull MuJsParser.CharAtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Length}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLength(@NotNull MuJsParser.LengthContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(@NotNull MuJsParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Greater}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreater(@NotNull MuJsParser.GreaterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStmt(@NotNull MuJsParser.AssignmentStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectExpression}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectExpression(@NotNull MuJsParser.ObjectExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectAsg}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectAsg(@NotNull MuJsParser.ObjectAsgContext ctx);
}