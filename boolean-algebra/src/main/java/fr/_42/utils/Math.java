package fr._42.utils;

public final class Math {

    public static int pow(int a, int power) {
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
}
