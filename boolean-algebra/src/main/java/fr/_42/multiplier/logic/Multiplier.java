package fr._42.multiplier.logic;

public class Multiplier {

    private Multiplier() {
    }

    private static int twoCompliment(int a) {
        a = a ^ (1 | Integer.MAX_VALUE << 1);
        return Adder.adder(a, 1);
    }

    public static int multiplier(int a, int b) {
        int shifter = 0;
        int result = 0;
        boolean isNegative = (a < 0) ^ (b < 0);
        if (a < 0) {
            a = twoCompliment(a);
        }
        if (b < 0) {
            b = twoCompliment(b);
        }
        while (b != 0) {
            if ((b & 1) != 0) {
                result = Adder.adder(result, a << shifter);
            }
            b = b >> 1;
            shifter++;
        }
        if (isNegative) {
            return twoCompliment(result);
        }
        return result;
    }
}
