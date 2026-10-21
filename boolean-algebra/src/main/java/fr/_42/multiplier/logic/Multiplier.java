package fr._42.multiplier.logic;

public class Multiplier {

    private Multiplier() {
    }

    public static int multiplier(int a, int b) {
        int result = 0;
        int i = 0;

        while (i < Integer.SIZE) {
            if (((b >> i) & 1) != 0) {
                result = Adder.adder(result, a << i);
            }
            i++;
        }
        return result;
    }
}
