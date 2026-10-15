package fr._42.sat.logic;

import fr._42.conjunctive_normal_form.logic.ConjunctiveNormalForm;
import fr._42.negation_normal_form.logic.NegationNormalForm;
import fr._42.utils.Expr;
import fr._42.utils.Operators;
import java.util.HashMap;
import java.util.Map;

public class Sat {

    public static boolean sat(String formul) {
        String formulAsNnf = NegationNormalForm.negation_normal_form(formul);
        Expr formulTree = ConjunctiveNormalForm.parseNnfRpn(formulAsNnf);
        return evaluateTree(formulTree);
    }
    private static Map<Character, Boolean> variablesMap = new HashMap<>();

    private static boolean evaluateTree(Expr formulTree) {
        if (formulTree.left == null && formulTree.right == null)
            return true;
        if (formulTree.left.isVariable() && formulTree.right.isVariable()) {
            return evaluateSingletonExpression(formulTree.left, formulTree.right, formulTree);
        }
        boolean left = evaluateTree(formulTree.left);
        if (formulTree.left.variableNegated) {
            left = !left;
        }
        boolean right = evaluateTree(formulTree.right);
        if (formulTree.right.variableNegated) {
            right = !right;
        }
        return Operators.OPERATORS.get(formulTree.op).applyAsInt(left == true ? 1 : 0, right == true ? 1 : 0) == 1;
    }

    private static boolean evaluateSingletonExpression(Expr left, Expr right, Expr operator) {
        // System.out.println("left : "+ left);
        // System.out.println("right : "+ right);
        // System.out.println("operator : "+ operator);
        if (!variablesMap.containsKey(left.variable)) {
            variablesMap.put(left.variable, true);
        }
        if (!variablesMap.containsKey(right.variable)) {
            variablesMap.put(right.variable, true);
        }
        boolean leftVariable = variablesMap.get(left.variable);
        if (left.variableNegated) {
            leftVariable = !leftVariable;
        }
        boolean rightVariable = variablesMap.get(right.variable);
        if (right.variableNegated) {
            rightVariable = !rightVariable;
        }
        return Operators.OPERATORS.get(operator.op).applyAsInt(leftVariable == true ? 1 : 0, rightVariable == true ? 1 : 0) == 1;
    }
}
