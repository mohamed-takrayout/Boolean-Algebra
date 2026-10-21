package fr._42.set_evaluation.app;

import java.util.Arrays;
import java.util.List;

import fr._42.set_evaluation.logic.SetEvaluation;

public class Program {

    public static void main(String[] args) {
        System.out.println("=== Set Evaluation Tests ===\n");
        
        // Test case 1: Conjunction (intersection)
        System.out.println("Test 1: Conjunction (A & B)");
        List<List<Integer>> sets1 = Arrays.asList(
            Arrays.asList(0, 1, 2),
            Arrays.asList(0, 3, 4)
        );
        List<Integer> result1 = SetEvaluation.evaluateSet("AB&", sets1);
        System.out.println("Sets: A={0, 1, 2}, B={0, 3, 4}");
        System.out.println("Formula: AB&");
        System.out.println("Result: " + result1);
        System.out.println("Expected: [0]\n");
        
        // Test case 2: Disjunction (union)
        System.out.println("Test 2: Disjunction (A | B)");
        List<List<Integer>> sets2 = Arrays.asList(
            Arrays.asList(0, 1, 2),
            Arrays.asList(3, 4, 5)
        );
        List<Integer> result2 = SetEvaluation.evaluateSet("AB|", sets2);
        System.out.println("Sets: A={0, 1, 2}, B={3, 4, 5}");
        System.out.println("Formula: AB|");
        System.out.println("Result: " + result2);
        System.out.println("Expected: [0, 1, 2, 3, 4, 5]\n");
        
        // Test case 3: Negation
        System.out.println("Test 3: Negation (!A)");
        List<List<Integer>> sets3 = Arrays.asList(
            Arrays.asList(0, 1, 2)
        );
        List<Integer> result3 = SetEvaluation.evaluateSet("A!", sets3);
        System.out.println("Sets: A={0, 1, 2}");
        System.out.println("Formula: A!");
        System.out.println("Result: " + result3);
        System.out.println("Expected: []\n");
        
        // Test case 4: Complex formula (!A B |)
        System.out.println("Test 4: Complex formula (!A B |)");
        List<List<Integer>> sets4 = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(2, 3)
        );
        List<Integer> result4 = SetEvaluation.evaluateSet("A!B|", sets4);
        System.out.println("Sets: A={1, 2}, B={2, 3}");
        System.out.println("Formula: A!B|");
        System.out.println("Result: " + result4);
        System.out.println("Expected: [2, 3] (!A union B)\n");
        
        // Test case 5: Three variables with complex formula
        System.out.println("Test 5: Three variables (A B & C |)");
        List<List<Integer>> sets5 = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(2, 3),
            Arrays.asList(4, 5)
        );
        List<Integer> result5 = SetEvaluation.evaluateSet("AB&C|", sets5);
        System.out.println("Sets: A={1, 2}, B={2, 3}, C={4, 5}");
        System.out.println("Formula: AB&C|");
        System.out.println("Result: " + result5);
        System.out.println("Expected: [2, 4, 5] ((A & B) | C)\n");
        
        // Test case 6: Negation with union
        System.out.println("Test 6: Negation with union (A! B |)");
        List<List<Integer>> sets6 = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5)
        );
        List<Integer> result6 = SetEvaluation.evaluateSet("A!B|", sets6);
        System.out.println("Sets: A={1, 2, 3}, B={4, 5}");
        System.out.println("Formula: A!B|");
        System.out.println("Result: " + result6);
        System.out.println("Expected: [4, 5] (!A | B = {} | {4,5} = {4,5})\n");
        
        // Test case 7: Double negation
        System.out.println("Test 7: Double negation (A!!)");
        List<List<Integer>> sets7 = Arrays.asList(
            Arrays.asList(1, 2)
        );
        List<Integer> result7 = SetEvaluation.evaluateSet("A!!", sets7);
        System.out.println("Sets: A={1, 2}");
        System.out.println("Formula: A!!");
        System.out.println("Result: " + result7);
        System.out.println("Expected: [1, 2]\n");
    }
}
