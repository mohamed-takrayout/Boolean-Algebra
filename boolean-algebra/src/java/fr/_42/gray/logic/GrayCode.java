package fr._42.gray.logic;

public class GrayCode {

    private GrayCode() {
    }

    public static int gray(int a) {
        return a ^ (a >> 1);
    }
}
