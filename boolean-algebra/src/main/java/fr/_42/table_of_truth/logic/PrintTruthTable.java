package fr._42.table_of_truth.logic;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import fr._42.utils.Expr;
import fr._42.utils.Operators;
import fr._42.utils.RpnParser;
import fr._42.utils.TruthTable;

public class PrintTruthTable {

    private PrintTruthTable() {
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("|%2c ", matrix[i][j]);
            }
            System.out.println("|");
            if (i == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.printf("|---");
                }
                System.out.println("|");
            }
        }
    }

    public static void printTruthTable(String str) {
        Set<Character> variablesSet = new LinkedHashSet<>();
        Expr formulaTree = RpnParser.parseRpn(str);
        for (char c : str.toCharArray()) {
            if (TruthTable.isVariable(c)) {
                variablesSet.add(c);
            } else if (!Operators.isOperator(c)) {
                throw new IllegalArgumentException("Entered non valid char symbol : [" + c + "]");
            }
        }
        try {
            List<Character> variablesList = new ArrayList<>(variablesSet);
            char[][] truthTable = TruthTable.fillTruthTable(variablesList, formulaTree);
            printMatrix(truthTable);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Entered non valid sequence of operations : [" + str + "]");
        }

    }
}
