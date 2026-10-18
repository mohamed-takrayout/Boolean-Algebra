package fr._42.set_evaluation.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr._42.conjunctive_normal_form.logic.ConjunctiveNormalForm;
import fr._42.utils.Evaluate;
import fr._42.utils.Expr;
import fr._42.utils.RpnParser;
import fr._42.utils.SetOperations;

public class SetEvaluation {

    private static Map<Character, List<Integer>> assignSetToVariables(String formula, List<List<Integer>> sets) {
        Map<Character, List<Integer>> mapSets = new HashMap<>();
        int i = 0;
        for (char c : formula.toCharArray()) {
            if ((c >= 'A' && c <= 'Z') && !mapSets.containsKey(c)) {
                mapSets.put(c, sets.get(i));
                i++;
            }
        }
        return mapSets;
    }

    public static List<Integer> eval_set(String formula, List<List<Integer>> sets) {
        Map<Character, List<Integer>> mapSets;
        mapSets = assignSetToVariables(formula, sets);
        List<Integer> universalSet = SetOperations.getUniversalSet(sets);
        String formulaAsCNF = ConjunctiveNormalForm.conjunctive_normal_form(formula);
        Expr exprTree = RpnParser.parseNnfRpn(formulaAsCNF);
        return Evaluate.evaluateSetTree(exprTree, mapSets, universalSet);
    }
}
