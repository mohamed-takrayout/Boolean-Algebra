package fr._42.boolean_evaluation.logic;

import java.util.LinkedList;
import java.util.Map;
import java.util.function.IntBinaryOperator;

public class EvalFormula {

    private final static Map<Character, IntBinaryOperator> OPERATORS = Map.of(
            '!', (a, b) -> a == 1 ? 0 : 1,
            '&', (a, b) -> a & b,
            '|', (a, b) -> a | b,
            '^', (a, b) -> a ^ b,
            '>', (a, b) -> a == b ? 1 : 0,
            '=', (a, b) -> a == b ? 1 : 0
    );

    private EvalFormula() {
    }

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

    public static boolean evalFormula(String str) throws IllegalArgumentException {
        LinkedList<Boolean> LINKED_LIST_OPERATIONS = new LinkedList<>();
        boolean first;
        boolean second;
        for (char c : str.toCharArray()) {
            if (isOperator(c)) {
                if (LINKED_LIST_OPERATIONS.size() < 2 & c != '!') {
                    throw new IllegalArgumentException("Entered non valid sequence of operations : [" + str + "]");
                }
                first = LINKED_LIST_OPERATIONS.remove();
                if (c == '!') {
                    LINKED_LIST_OPERATIONS.addFirst(!first);
                    continue;
                }
                second = LINKED_LIST_OPERATIONS.remove();
                int newValue = OPERATORS.get(c).applyAsInt(first ? 1 : 0, second ? 1 : 0);
                LINKED_LIST_OPERATIONS.addFirst(newValue == 1);
            } else {
                if (c == '1') {
                    LINKED_LIST_OPERATIONS.addLast(true);
                } else if (c == '0') {
                    LINKED_LIST_OPERATIONS.addLast(false);
                } else {
                    throw new IllegalArgumentException("Entered non valid sequence of operations : [" + str + "]");
                }
            }
        }
        if (LINKED_LIST_OPERATIONS.size() != 1) {
            throw new IllegalArgumentException("Entered non valid sequence of operations : [" + str + "]");
        }
        return LINKED_LIST_OPERATIONS.remove();

    }
}
