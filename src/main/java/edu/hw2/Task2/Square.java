package edu.hw2.Task2;

public class Square extends Rectangle {
    public static Constructor constructor;

    public Square() {
        constructor = new Constructor();
    }

    public Square(int squareSide) {
        super(squareSide, squareSide);
        constructor = new Constructor();
    }

    public static final class Constructor {
        private int squareSide;

        public Constructor setSide(int squareSide) {
            this.squareSide = squareSide;
            return this;
        }

        public Square construct() {
            return new Square(squareSide);
        }
    }
}
