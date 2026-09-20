package fr._42.adder.app;

import fr._42.adder.logic.Adder;

public class Program {

    private static void printSum(int a, int b) {
        System.out.printf("(%d) + (%d) = %d", a, b, Adder.adder(a, b));
        System.out.println();
    }

    public static void main(String[] args) {
        printSum(1, 5);
        printSum(1, -5);
        printSum(-1, 5);
        printSum(-1, -5);
        printSum(0, 9);
        printSum(9, 0);
        printSum(101, 10);
    }
}
