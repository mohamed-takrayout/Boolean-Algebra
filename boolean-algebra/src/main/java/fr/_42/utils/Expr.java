package fr._42.utils;

public final class Expr {
    public final char op;
    public final char variable;
    public final Expr left;
    public final Expr right;
    public boolean variableNegated = false;

    public Expr(char variable) {
        this.op = '\0';
        this.variable = variable;
        this.left = null;
        this.right = null;
    }

    public Expr(char op, Expr left, Expr right) {
        this.op = op;
        this.variable = '\0';
        this.left = left;
        this.right = right;
    }

    public Expr(char op, Expr child) {
        this.op = op;
        this.variable = '\0';
        this.left = child;
        this.right = null;
    }

    public static Expr variable(char c) {
        return new Expr(c);
    }

    public static Expr unary(char op, Expr child) {
        return new Expr(op, child);
    }

    public static Expr binary(char op, Expr left, Expr right) {
        return new Expr(op, left, right);
    }

    public boolean isVariable() {
        return op == '\0';
    }
}