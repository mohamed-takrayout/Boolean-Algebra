package fr._42.conjunctive_normal_form.logic;

import fr._42.negation_normal_form.logic.NegationNormalForm;
import fr._42.utils.Expr;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ConjunctiveNormalForm {

    private static Expr parseNnfRpn(String formula) {
        Deque<Expr> stack = new ArrayDeque<>();
        for (char token : formula.toCharArray()) {
            if (Character.isWhitespace(token)) {
                continue;
            }
            if (token >= 'A' && token <= 'Z') {
                stack.push(Expr.variable(token));
            } else if (token == '!') {
                if (stack.isEmpty() || !stack.peek().isVariable()) {
                    throw new IllegalArgumentException("In NNF, ! must follow a variable");
                }
                stack.peek().variableNegated = true;
            } else if (token == '&' || token == '|') {
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

    private static List<List<String>> toCnfClauses(Expr expr) {
        if (expr.isVariable()) {
            String literal = String.valueOf(expr.variable);
            if (expr.variableNegated) {
                literal += "!";
            }
            return singletonClause(literal);
        }
        List<List<String>> left = toCnfClauses(expr.left);
        List<List<String>> right = toCnfClauses(expr.right);
        if (expr.op == '&') {
            List<List<String>> result = new ArrayList<>(left);
            result.addAll(right);
            return result;
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> leftClause : left) {
            for (List<String> rightClause : right) {
                List<String> combined = new ArrayList<>(leftClause);
                combined.addAll(rightClause);
                result.add(combined);
            }
        }
        return result;
    }

    private static List<List<String>> singletonClause(String literal) {
        List<String> clause = new ArrayList<>();
        clause.add(literal);
        List<List<String>> clauses = new ArrayList<>();
        clauses.add(clause);
        return clauses;
    }

    public static String conjunctive_normal_form(String formula) {
        String formulAsNNF = NegationNormalForm.negation_normal_form(formula);
        Expr root = parseNnfRpn(formulAsNNF);
        List<List<String>> clauses = toCnfClauses(root);
        StringBuilder result = new StringBuilder();
        // Write each clause as an RPN OR expression.
        for (List<String> clause : clauses) {
            for (int i = 0; i < clause.size(); i++) {
                result.append(clause.get(i));
            }
            for (int i = 1; i < clause.size(); i++) {
                result.append('|');
            }
        }
        for (int i = 1; i < clauses.size(); i++) {
            result.append('&');
        }
        return result.toString();
    }
}
