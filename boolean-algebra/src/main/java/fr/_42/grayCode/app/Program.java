package fr._42.grayCode.app;

import fr._42.grayCode.logic.GrayCode;

public class Program {

    private static void printGrayCode(int a) {
        System.out.printf("gray code of : (%d) =>  %d", a, GrayCode.gray(a));
        System.out.println();
    }

    public static void main(String[] args) {
        printGrayCode(-9);
        printGrayCode(-8);
        printGrayCode(-7);
        printGrayCode(-6);
        printGrayCode(-5);
        printGrayCode(-4);
        printGrayCode(-3);
        printGrayCode(-2);
        printGrayCode(-1);
        printGrayCode(0);
        printGrayCode(1);
        printGrayCode(2);
        printGrayCode(3);
        printGrayCode(4);
        printGrayCode(5);
        printGrayCode(6);
        printGrayCode(7);
        printGrayCode(8);
        printGrayCode(9);
    }
}
