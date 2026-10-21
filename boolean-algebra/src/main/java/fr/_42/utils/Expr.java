package fr._42.utils;

import java.util.Objects;

public final class Expr {

    public final char op;
    public final char variable;
    public final Expr left;
    public final Expr right;
    public boolean variableNegated = false;

    private Expr(char variable) {
        this.op = '\0';
        this.variable = variable;
        this.left = null;
        this.right = null;
    }

    private Expr(char op, Expr left, Expr right) {
        this.op = op;
        this.variable = '\0';
        this.left = left;
        this.right = right;
    }

    private Expr(char op, Expr child) {
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

    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Expr{");
        sb.append("op=").append(op);
        sb.append(", variable=").append(variable);
        sb.append(", variableNegated=").append(variableNegated);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(op, variable, left, right, variableNegated);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Expr other = (Expr) obj;
        if (this.op != other.op) {
            return false;
        }
        if (this.variable != other.variable) {
            return false;
        }
        if (this.variableNegated != other.variableNegated) {
            return false;
        }
        if (!Objects.equals(this.left, other.left)) {
            return false;
        }
        return Objects.equals(this.right, other.right);
    }
}
