package edu.project4.Transformations;

import edu.project4.Models.Point;

public class PolarTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        return new Point(
            Math.atan(point.x() / point.y()) / Math.PI,
            Math.sqrt(point.x() * point.x() + point.y() * point.y()) - 1
        );
    }
}
