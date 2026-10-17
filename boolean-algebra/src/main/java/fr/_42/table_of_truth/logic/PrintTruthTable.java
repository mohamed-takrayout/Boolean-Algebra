package fr._42.table_of_truth.logic;

import fr._42.utils.Expr;
import fr._42.utils.Operators;
import fr._42.utils.RpnParser;
import fr._42.utils.TruthTable;
import java.util.ArrayList;
import java.util.List;

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
        List<Character> variablesList = new ArrayList<>();
        Expr formulaTree = RpnParser.parseRpn(str);
        for (char c : str.toCharArray()) {
            if (TruthTable.isVariable(c) | Operators.isOperator(c)) {
                if (TruthTable.isVariable(c)) {
                    if (!variablesList.contains(c)) {
                        variablesList.add(c);
                    }
                }
            } else {
                throw new IllegalArgumentException("Entered non valid char symbol : [" + c + "]");
            }
        }
        try {
            char[][] truthTable = TruthTable.fillTruthTable(variablesList, formulaTree);
            printMatrix(truthTable);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Entered non valid sequence of operations : [" + str + "]");
        }

    }
}
