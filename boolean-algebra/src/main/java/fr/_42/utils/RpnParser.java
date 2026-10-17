package fr._42.utils;

import java.util.ArrayDeque;
import java.util.Deque;

public final class RpnParser {

    public static Expr parseRpn(String formula) {
        Deque<Expr> stack = new ArrayDeque<>();
        for (char token : formula.toCharArray()) {
            if (Character.isWhitespace(token)) {
                continue;
            }
            if (TruthTable.isVariable(token)) {
                stack.push(Expr.variable(token));
            } else if (token == '!') {
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("Invalid RPN formula");
                }
                stack.push(Expr.unary(token, stack.pop()));
            } else if (token == '&' || token == '|' || token == '^' || token == '>' || token == '=') {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid RPN formula");
                }
                Expr right = stack.pop();
                Expr left = stack.pop();
                stack.push(Expr.binary(token, left, right));
            } else {
                throw new IllegalArgumentException("Unknown token: " + token);
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid RPN formula");
        }
        return stack.pop();
    }
}
