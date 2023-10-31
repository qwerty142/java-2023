package edu.hw2;

public sealed interface Expr {
    double evaluate();

    String toString();

    record Constant(double value) implements Expr {

        @Override
        public double evaluate() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    record Negate(Expr expr) implements Expr {

        @Override
        public double evaluate() {
            return -expr.evaluate();
        }

        @Override
        public String toString() {
            return "-" + expr;
        }
    }

    record Exponent(Expr expr, double step) implements Expr {

        @Override
        public double evaluate() {
            return Math.pow(expr.evaluate(), step);
        }

        @Override
        public String toString() {
            return expr.evaluate() + "^" + step;
        }
    }

     record Addition(Expr exprLeft, Expr exprRight) implements Expr {

        @Override
        public double evaluate() {
            return exprLeft.evaluate() + exprRight.evaluate();
        }

        @Override
        public String toString() {
            return exprLeft + "+" + exprRight;
        }
    }

    record Multiplication(Expr exprLeft, Expr exprRight) implements Expr {

        @Override
        public double evaluate() {
            return exprLeft.evaluate() * exprRight.evaluate();
        }

        @Override
        public String toString() {
            return exprLeft + "*" + exprRight;
        }
    }
}
