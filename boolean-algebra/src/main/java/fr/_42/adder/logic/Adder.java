package fr._42.adder.logic;

public class Adder {

    private Adder() {
    }

    public static int adder(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
