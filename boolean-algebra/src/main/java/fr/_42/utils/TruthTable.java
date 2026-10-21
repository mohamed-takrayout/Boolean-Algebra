package fr._42.utils;

import java.util.List;

public final class TruthTable {

    public static char[][] fillTruthTable(List<Character> variablesList, Expr formulaTree) throws IllegalArgumentException {
        int variableCount = variablesList.size();
        int rowCount = 1 << variableCount;
        char[][] truthTable = new char[rowCount + 1][variableCount + 1];
        for (int i = 0; i < variableCount; i++) {
            truthTable[0][i] = variablesList.get(i);
        }
        truthTable[0][variableCount] = '=';

        for (int column = 0; column < variableCount; column++) {
            int blockSize = 1 << (variableCount - column - 1);
            for (int row = 0; row < rowCount; row++) {
                int value = (row / blockSize) % 2;
                truthTable[row + 1][column] = (value == 0) ? '0' : '1';
            }
        }
        for (int row = 1; row <= rowCount; row++) {
            truthTable[row][variableCount] = Evaluate.evaluateTree(formulaTree, truthTable[row], variablesList) ? '1' : '0';
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
