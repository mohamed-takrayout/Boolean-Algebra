package fr._42.boolean_evaluation.app;

import fr._42.boolean_evaluation.logic.EvalFormula;

public class Program {

    private static void printEvalFormula(String str) {
        try {
            boolean result = EvalFormula.evalFormula(str);
            System.out.printf("[%s] output result is [%b]", str, result);
        } catch (IllegalArgumentException e) {
            System.err.print(e.getMessage());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printEvalFormula("10&");
        printEvalFormula("10|");
        printEvalFormula("10|1&");
        printEvalFormula("101|&");
        printEvalFormula("11>");
        printEvalFormula("10>");
        printEvalFormula("10=");
        printEvalFormula("11>>");
        printEvalFormula("1011||=");
    }
}
