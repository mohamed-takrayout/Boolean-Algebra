package fr._42.utils;

import java.util.Map;
import java.util.function.IntBinaryOperator;

public final class Operators {

    public final static Map<Character, IntBinaryOperator> OPERATORS = Map.of(
            '!', (a, b) -> a == 1 ? 0 : 1,
            '&', (a, b) -> a & b,
            '|', (a, b) -> a | b,
            '^', (a, b) -> a ^ b,
            '>', (a, b) -> (a == 0 || b == 1) ? 1 : 0,
            '=', (a, b) -> a == b ? 1 : 0
    );
}
