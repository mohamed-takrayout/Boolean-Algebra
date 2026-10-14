package fr._42.conjunctive_normal_form.app;

import fr._42.conjunctive_normal_form.logic.ConjunctiveNormalForm;

public class Program {

    public static void main(String[] args) {
        String[][] TESTS = {
            {"A!B!|", "A!B!|"},
            {"A!B!&", "A!B!&"},
            {"AB|C&", "AB|C&"},
            {"ABCD&|&", "ABC|BD|&&"},
            {"AB|C|D|", "ABCD|||"},
            {"AB&C&D&", "ABCD&&&"}
        };
        for (String[] test : TESTS) {
            String input = test[0];
            String expected = test[1];
            String output = ConjunctiveNormalForm.conjunctive_normal_form(input);
            System.out.println("input :" +input + "  -> output: " + output +"-> expected: "+ expected);
        }
    }
}
