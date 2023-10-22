package edu.hw2.Task2;

public class Rectangle {
    public static Constructor constructor;
    private final int height;
    private final int width;

    public Rectangle(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("width and height should be more then 0");
        }
        this.width = width;
        this.height = height;
        constructor = new Constructor();
    }

    public Rectangle() {
        constructor = new Constructor();
        height = 0;
        width = 0;
    }

    public int area() {
        return height * width;
    }

    public final static class Constructor {
        private int height;
        private int width;

        public Constructor setWidth(int width) {
            this.width = width;
            return this;
        }

        public Constructor setHeight(int height) {
            this.height = height;
            return this;
        }

        public Rectangle construct() {
            if (width > 0 && height > 0) {
                return new Rectangle(width, height);
            }
            throw new IllegalArgumentException("Incorrect parameters of width or height");
        }
    }

}
