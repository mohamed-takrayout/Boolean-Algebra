package fr._42.utils;

public final class Expr {
    public final char op;
    public final char variable;
    public final Expr left;
    public final Expr right;
    public boolean variableNegated = false;
    private int size = 0;

    public Expr(char variable) {
        this.op = '\0';
        this.variable = variable;
        this.left = null;
        this.right = null;
        size++;
    }

    public Expr(char op, Expr left, Expr right) {
        this.op = op;
        this.variable = '\0';
        this.left = left;
        this.right = right;
        size++;
    }

    public Expr(char op, Expr child) {
        this.op = op;
        this.variable = '\0';
        this.left = child;
        this.right = null;
        size++;
    }
    public int size(){
        return size;
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
    // @Override
    // public String toString(){
        
    // }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Expr{");
        sb.append("op=").append(op);
        sb.append(", variable=").append(variable);
        // sb.append(", left=").append(left);
        // sb.append(", right=").append(right);
        sb.append(", variableNegated=").append(variableNegated);
        sb.append('}');
        return sb.toString();
    }
}