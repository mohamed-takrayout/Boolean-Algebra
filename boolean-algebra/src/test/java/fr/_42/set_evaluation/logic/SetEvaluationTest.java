package fr._42.set_evaluation.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SetEvaluationTest {

    @Test
    @DisplayName("Conjunction ({0,1,2} & {3,4,5})")
    public void conjunction_Test() {
        List<List<Integer>> sets1 = Arrays.asList(
                Arrays.asList(0, 1, 2),
                Arrays.asList(0, 3, 4)
        );
        List<Integer> expected = List.of(0);
        String formulRpn = "AB&";
        List<Integer> result = SetEvaluation.eval_set(formulRpn, sets1);
        Collections.sort(result);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Union ({0,1,2} | {3,4,5})")
    public void union_Test() {
        List<List<Integer>> sets1 = Arrays.asList(
                Arrays.asList(0, 1, 2),
                Arrays.asList(3, 4, 5)
        );
        List<Integer> expected = List.of(0, 1, 2, 3, 4, 5);
        String formulRpn = "AB|";
        List<Integer> result = SetEvaluation.eval_set(formulRpn, sets1);
        Collections.sort(result);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Complement (!{0,1,2})")
    public void complement_Test() {
        List<List<Integer>> sets1 = Arrays.asList(
                Arrays.asList(0, 1, 2)
        );
        List<Integer> expected = new ArrayList<>();
        String formulRpn = "A!";
        List<Integer> result = SetEvaluation.eval_set(formulRpn, sets1);
        Collections.sort(result);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("complex formula ((!{1,2}) | {2,3})")
    public void complex_formula_Test() {
        List<List<Integer>> sets1 = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(2, 3)
        );
        List<Integer> expected = List.of(2, 3);
        String formulRpn = "A!B|";
        List<Integer> result = SetEvaluation.eval_set(formulRpn, sets1);
        Collections.sort(result);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("complex formula with tree variables (({1,2} & {2, 3}) | {4, 5})")
    public void complex_formula_using_tree_variables_Test() {
        List<List<Integer>> sets1 = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5)
        );
        List<Integer> expected = List.of(2, 4, 5);
        String formulRpn = "AB&C|";
        List<Integer> result = SetEvaluation.eval_set(formulRpn, sets1);
        Collections.sort(result);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("negation with union (!{1,2,3} | {4,5})")
    public void negation_with_union_Test() {
        List<List<Integer>> sets1 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5)
        );
        List<Integer> expected = List.of(4, 5);
        String formulRpn = "A!B|";
        List<Integer> result = SetEvaluation.eval_set(formulRpn, sets1);
        Collections.sort(result);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("double negation (!!{1,2})")
    public void double_negation_Test() {
        List<List<Integer>> sets1 = Arrays.asList(
                Arrays.asList(1, 2)
        );
        List<Integer> expected = List.of(1, 2);
        String formulRpn = "A!!";
        List<Integer> result = SetEvaluation.eval_set(formulRpn, sets1);
        Collections.sort(result);
        assertEquals(expected, result);
    }
}
