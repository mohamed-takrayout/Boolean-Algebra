package fr._42.multiplier.logic;

public class Adder {

    private Adder() {
    }

    public static int adder(int a, int b) {
        return b == 0 ? a : adder(a ^ b, (a & b) << 1);
    }
}
