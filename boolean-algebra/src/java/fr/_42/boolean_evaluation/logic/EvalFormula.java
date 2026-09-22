package fr._42.boolean_evaluation.logic;

import java.util.Map;
import java.util.Stack;
import java.util.function.IntBinaryOperator;

public class EvalFormula {

    private final static Map<Character, IntBinaryOperator> OPERATORS = Map.of(
            '!', (a, b) -> a == 1 ? 0 : 1,
            '&', (a, b) -> a & b,
            '|', (a, b) -> a | b,
            '^', (a, b) -> a ^ b,
            '>', (a, b) -> (a == 0 || b == 1) ? 1 : 0,
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
}
