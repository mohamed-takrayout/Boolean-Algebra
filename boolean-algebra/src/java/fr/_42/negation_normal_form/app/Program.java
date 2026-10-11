package fr._42.negation_normal_form.app;

import fr._42.negation_normal_form.logic.NegationNormalForm;

public class Program{
    public static void main(String[] args) {
        if (args.length > 0) {
            for (String formula : args) {
                System.out.println(NegationNormalForm.negation_normal_form(formula));
            }
            return;
        }

        String[] examples = {
            "AB&!",
            "AB|!",
            "AB>",
            "AB=",
            "AB|C&!",
            "AB=!"
        };

        for (String formula : examples) {
            System.out.println(formula + " -> " + NegationNormalForm.negation_normal_form(formula));
        }
    }
}