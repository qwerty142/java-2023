package edu.project4.Models;

public record Point(double x, double y) {
    public double radius() {
        return Math.sqrt(x * x + y * y);
    }

    public double tang() {
        return Math.atan(x / y);
    }
}
