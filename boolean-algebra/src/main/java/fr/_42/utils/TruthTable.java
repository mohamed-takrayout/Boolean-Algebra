package fr._42.utils;

import java.util.List;

public final class TruthTable {

    public static char[][] fillTruthTable(List<Character> variablesList, Expr formulaTree) throws IllegalArgumentException {
        char[][] truthTable = new char[Math.pow(2, variablesList.size()) + 1][variablesList.size() + 1];
        int variableCount = truthTable[0].length - 1;
        int rowCount = truthTable.length - 1;
        for (int i = 0; i < truthTable[0].length - 1; i++) {
            truthTable[0][i] = variablesList.get(i);
        }
        truthTable[0][truthTable[0].length - 1] = '=';
        for (int column = 0; column < variableCount; column++) {
            int blockSize = 1 << (variableCount - column - 1);
            for (int row = 0; row < rowCount; row++) {
                int value = (row / blockSize) % 2;
                truthTable[row + 1][column] = (value == 0) ? '0' : '1';
            }
        }
        for (int row = 1; row < truthTable.length; row++) {
            truthTable[row][truthTable[row].length - 1] = Evaluate.evaluateTree(formulaTree, truthTable[row], variablesList) ? '1' : '0';
        }
        return truthTable;
    }

    /**
     * return true if char c is an uppercase letter
     */
    public static boolean isVariable(char c) {
        return c >= 'A' & c <= 'Z';
    }
}
