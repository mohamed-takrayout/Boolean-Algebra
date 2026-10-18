package fr._42.utils;

import java.util.List;
import java.util.Map;

public final class Evaluate {

    public static boolean evaluateTree(Expr expr, char[] valuesBySymbol, List<Character> variablesList) {
        if (expr.isVariable()) {
            int column = variablesList.indexOf(expr.variable);
            if (column == -1) {
                throw new IllegalArgumentException("Unknown variable: " + expr.variable);
            }
            boolean value = valuesBySymbol[column] == '1';
            return expr.variableNegated ? !value : value;
        }
        if (expr.op == '!') {
            return !evaluateTree(expr.left, valuesBySymbol, variablesList);
        }
        boolean left = evaluateTree(expr.left, valuesBySymbol, variablesList);
        boolean right = evaluateTree(expr.right, valuesBySymbol, variablesList);
        int newValue = Operators.OPERATORS.get(expr.op).applyAsInt(left ? 1 : 0, right ? 1 : 0);
        return newValue == 1;
    }

    public static List<Integer> evaluateSetTree(Expr expr, Map<Character, List<Integer>> setByVariable, List<Integer> universalSet) throws IllegalArgumentException {
        if (expr.isVariable()) {
            List<Integer> value = setByVariable.get(expr.variable);
            if (expr.variableNegated) {
                return SetOperations.complement(value, universalSet);
            }
            return value;
        }
        List<Integer> left = evaluateSetTree(expr.left, setByVariable, universalSet);
        List<Integer> right = evaluateSetTree(expr.right, setByVariable, universalSet);
        return switch (expr.op) {
            case '|' ->
                SetOperations.union(left, right);
            case '&' ->
                SetOperations.intersection(left, right);
            default ->
                throw new IllegalArgumentException("Unkown operator[" + expr.op + "] , it should not be here !!!!");
        };
    }
}
