package edu.project4.Models;

import java.util.concurrent.ThreadLocalRandom;

public record Rect(double x, double y, double width, double height) {
    public Point getPoint() {
        return new Point(
            ThreadLocalRandom.current().nextDouble(0, width),
            ThreadLocalRandom.current().nextDouble(0, height)
        );
    }

    public boolean inBoards(Point point) {
        return point.x() >= x
            && point.x() < width + x
            && point.y() >= y
            && point.y() < height + y;
    }
}
