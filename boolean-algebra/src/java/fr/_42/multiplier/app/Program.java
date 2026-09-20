package fr._42.multiplier.app;

import fr._42.multiplier.logic.Multiplier;

public class Program {

    private static void printMultiplier(int a, int b) {
        System.out.printf("(%d) * (%d) = %d", a, b, Multiplier.multiplier(a, b));
        System.out.println();
    }

    public static void main(String[] args) {
        printMultiplier(3, 5);
        printMultiplier(3, -5);
        printMultiplier(-3, 5);
        printMultiplier(-3, -5);
        printMultiplier(0, 9);
        printMultiplier(9, 0);
        printMultiplier(101, 10);
    }
}
