package fr._42.table_of_truth.logic;

import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import java.util.function.IntBinaryOperator;

public class PrintTruthTable {

    private static final ArrayList<Character> symbolCharacters = new ArrayList<>();
    private static char[][] truthTable;
    private static String formula;

    private PrintTruthTable() {
    }

    private final static Map<Character, IntBinaryOperator> OPERATORS = Map.of(
            '!', (a, b) -> a == 1 ? 0 : 1,
            '&', (a, b) -> a & b,
            '|', (a, b) -> a | b,
            '^', (a, b) -> a ^ b,
            '>', (a, b) -> (a == 0 || b == 1) ? 1 : 0,
            '=', (a, b) -> a == b ? 1 : 0
    );

    private static boolean isOperator(char c) {
        return switch (c) {
            case '!' ->
                true;
            case '&' ->
                true;
            case '|' ->
                true;
            case '^' ->
                true;
            case '>' ->
                true;
            case '=' ->
                true;
            default ->
                false;
        };
    }

    /**
     * return true if char c is an uppercase letter
     */
    private static boolean isValidSymbol(char c) {
        return c >= 'A' & c <= 'Z';
    }

    private static boolean evalFormula(String str) throws IllegalArgumentException {
        Stack<Boolean> STACK_OPERATIONS = new Stack<>();
        boolean right;
        boolean left;
        for (char c : str.toCharArray()) {
            if (!isOperator(c)) {
                if (c == '1' || c == '0') {
                    STACK_OPERATIONS.addLast(c == '1');
                } else {
                    throw new IllegalArgumentException("Entered non valid sequence of operations : [" + str + "]");
                }
                continue;
            }
            if (c == '!') {
                if (STACK_OPERATIONS.size() < 1) {
                    throw new IllegalArgumentException("Entered non valid sequence of operations : [" + str + "]");
                }
                STACK_OPERATIONS.push(!STACK_OPERATIONS.pop());
            } else {
                if (STACK_OPERATIONS.size() < 2) {
                    throw new IllegalArgumentException("Entered non valid sequence of operations : [" + str + "]");
                }
                right = STACK_OPERATIONS.pop();
                left = STACK_OPERATIONS.pop();
                int newValue = OPERATORS.get(c).applyAsInt(left ? 1 : 0, right ? 1 : 0);
                STACK_OPERATIONS.push(newValue == 1);
            }
        }
        if (STACK_OPERATIONS.size() != 1) {
            throw new IllegalArgumentException("Entered non valid sequence of operations : [" + str + "]");
        }
        return STACK_OPERATIONS.pop();
    }

    private static int pow(int a, int power) {
        int result = 1;
        while (power >= 1) {
            if (a == 0) {
                return 1;
            }
            result = result * a;
            power--;
        }
        return result;
    }

    private static void fillTruthTable() throws IllegalArgumentException {
        int variableCount = truthTable[0].length - 1;
        int rowCount = truthTable.length - 1;
        for (int column = 0; column < variableCount; column++) {
            int blockSize = 1 << (variableCount - column - 1);
            for (int row = 0; row < rowCount; row++) {
                int value = (row / blockSize) % 2;
                truthTable[row + 1][column] = (value == 0) ? '0' : '1';
            }
        }
        for (int row = 1; row < truthTable.length; row++) {
            StringBuilder form = new StringBuilder();
            for (char token : formula.toCharArray()) {
                if (isValidSymbol(token)) {
                    int column = symbolCharacters.indexOf(token);
                    if (column == -1) {
                        throw new IllegalArgumentException("Unknown variable: " + token);
                    }
                    form.append(truthTable[row][column]);
                } else if (isOperator(token)) {
                    form.append(token);
                }
            }
            truthTable[row][truthTable[row].length - 1] = evalFormula(form.toString()) ? '1' : '0';
        }
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
        StringBuilder sb = new StringBuilder();

        symbolCharacters.clear();
        formula = str;
        for (char c : str.toCharArray()) {
            if (isValidSymbol(c) | isOperator(c)) {
                if (isValidSymbol(c)) {
                    sb.append('1');
                    if (!symbolCharacters.contains(c)) {
                        symbolCharacters.add(c);
                    }
                } else {
                    sb.append(c);
                }
            } else {
                throw new IllegalArgumentException("Entered non valid char symbol : [" + c + "]");
            }
        }
        try {
            evalFormula(sb.toString());
            truthTable = new char[pow(2, symbolCharacters.size()) + 1][symbolCharacters.size() + 1];
            for (int i = 0; i < truthTable[0].length - 1; i++) {
                truthTable[0][i] = symbolCharacters.get(i);
            }
            truthTable[0][truthTable[0].length - 1] = '=';
            fillTruthTable();
            printMatrix(truthTable);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Entered non valid sequence of operations : [" + str + "]");
        }

    }
}
