package fr._42.negation_normal_form.logic;

import fr._42.utils.Expr;
import fr._42.utils.RpnParser;

public class NegationNormalForm {

    public static String negationNormalForm(String formula) {
        Expr formulaTree = RpnParser.parseRpn(formula);
        StringBuilder result = new StringBuilder();
        emitNnf(formulaTree, false, result);
        return result.toString();
    }

    private static void emitNnf(Expr expr, boolean negated, StringBuilder out) {
        if (expr.isVariable()) {
            out.append(expr.variable);
            if (negated) {
                out.append('!');
            }
            return;
        }
        switch (expr.op) {
            case '!' ->
                emitNnf(expr.left, !negated, out);
            case '&' -> {
                emitNnf(expr.left, negated, out);
                emitNnf(expr.right, negated, out);
                out.append(negated ? '|' : '&');
            }
            case '|' -> {
                emitNnf(expr.left, negated, out);
                emitNnf(expr.right, negated, out);
                out.append(negated ? '&' : '|');
            }
            case '>' -> {
                if (negated) {
                    emitNnf(expr.left, false, out);
                    emitNnf(expr.right, true, out);
                    out.append('&');
                } else {
                    emitNnf(expr.left, true, out);
                    emitNnf(expr.right, false, out);
                    out.append('|');
                }
            }
            case '^' -> // XOR
                emitXorOrEquivalence(expr.left, expr.right, negated, true, out);
            case '=' -> // equivalence
                emitXorOrEquivalence(expr.left, expr.right, negated, false, out);
            default ->
                throw new IllegalArgumentException("Unsupported operator: " + expr.op);
        }
    }

    private static void emitXorOrEquivalence(Expr left, Expr right, boolean negated, boolean isXor, StringBuilder out) {
        // XOR is true when the inputs differ; equivalence is true when they match.
        boolean inputsShouldMatch = isXor ? negated : !negated;
        if (inputsShouldMatch) {
            // (left & right) | (!left & !right)
            emitNnf(left, false, out);
            emitNnf(right, false, out);
            out.append('&');
            emitNnf(left, true, out);
            emitNnf(right, true, out);
            out.append('&');
        } else {
            // (left & !right) | (!left & right)
            emitNnf(left, false, out);
            emitNnf(right, true, out);
            out.append('&');
            emitNnf(left, true, out);
            emitNnf(right, false, out);
            out.append('&');
        }
        out.append('|');
    }
}
