package fr._42.sat.app;

import fr._42.sat.logic.Sat;

public class Program {

    public static void main(String[] args) {
        String[][] TESTS = {
            {"AB|", "true"},
            {"B!", "true"},
            {"AA!&", "false"},
            {"AA^", "false"},
            {"A", "true"},
            {"A!", "true"},
            {"AA&", "true"},
            {"AA|", "true"},
            {"AA^", "false"},
            {"AA!&", "false"},
            {"A!A&", "false"},
            {"AA!|", "true"},
            {"AA!|!", "false"},
            {"AB&", "true"},
            {"AB|!", "true"},
            {"AB^", "true"},
            {"AB^A&", "true"},
            {"AB&AB&!&", "false"},
            {"AB|AB&!&", "true"},
            {"AB|C&", "true"},
            {"AB&C|", "true"}
        };
        for (String[] test : TESTS) {
            String input = test[0];
            String expected = test[1];
            String output = String.valueOf(Sat.sat(input));
            System.out.print("input :" + input);
            System.out.print("  -> output: " + output);
            System.out.print("  -> expected: " + expected);
            if(output.equals(expected))
                System.out.println("  V");
            else 
                System.out.println("  X");
        }
    }
}
