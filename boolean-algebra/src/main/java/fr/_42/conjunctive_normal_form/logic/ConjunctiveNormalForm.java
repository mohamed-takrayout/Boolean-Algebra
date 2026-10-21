package fr._42.conjunctive_normal_form.logic;

import java.util.ArrayList;
import java.util.List;

import fr._42.negation_normal_form.logic.NegationNormalForm;
import fr._42.utils.Expr;
import fr._42.utils.RpnParser;

public class ConjunctiveNormalForm {

    public static String conjunctiveNormalForm(String formula) {
        String formulAsNNF = NegationNormalForm.negationNormalForm(formula);
        Expr root = RpnParser.parseNnfRpn(formulAsNNF);
        List<List<String>> clauses = toCnfClauses(root);
        StringBuilder result = new StringBuilder();
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
}
