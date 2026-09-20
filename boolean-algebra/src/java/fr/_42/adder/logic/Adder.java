package fr._42.adder.logic;

public class Adder {

    private Adder() {
    }

    public static int adder(int a, int b) {
        return b == 0 ? a : adder(a ^ b, (a & b) << 1);
    }
}
