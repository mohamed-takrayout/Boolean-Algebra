package fr._42.negation_normal_form.logic;

import java.util.ArrayDeque;
import java.util.Deque;
import fr._42.utils.Expr;

public class NegationNormalForm {

    public static String negation_normal_form(String formula) {
        Deque<Expr> stack = new ArrayDeque<>();
        for (char token : formula.toCharArray()) {
            if (Character.isWhitespace(token)) {
                continue;
            }
            if (token >= 'A' && token <= 'Z') {
                stack.push(Expr.variable(token));
            } else if (token == '!') {
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("Invalid formula");
                }
                stack.push(Expr.unary(token, stack.pop()));
            } else if (token == '&' || token == '|' || token == '^'
                    || token == '>' || token == '=') {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid formula");
                }
                Expr right = stack.pop();
                Expr left = stack.pop();
                stack.push(Expr.binary(token, left, right));
            } else {
                throw new IllegalArgumentException("Unknown token: " + token);
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid formula");
        }
        StringBuilder result = new StringBuilder();
        emitNnf(stack.pop(), false, result);
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
            case '!':
                emitNnf(expr.left, !negated, out);
                break;
            case '&':
                emitNnf(expr.left, negated, out);
                emitNnf(expr.right, negated, out);
                out.append(negated ? '|' : '&');
                break;
            case '|':
                emitNnf(expr.left, negated, out);
                emitNnf(expr.right, negated, out);
                out.append(negated ? '&' : '|');
                break;
            case '>':
                if (negated) {
                    emitNnf(expr.left, false, out);
                    emitNnf(expr.right, true, out);
                    out.append('&');
                } else {
                    emitNnf(expr.left, true, out);
                    emitNnf(expr.right, false, out);
                    out.append('|');
                }
                break;
            case '^': // XOR
                emitXorOrEquivalence(expr.left, expr.right, negated, true, out);
                break;
            case '=': // equivalence
                emitXorOrEquivalence(expr.left, expr.right, negated, false, out);
                break;
            default:
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
