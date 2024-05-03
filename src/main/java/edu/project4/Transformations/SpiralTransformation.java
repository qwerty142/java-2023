package edu.project4.Transformations;

import edu.project4.Models.Point;

public class SpiralTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double c = 1.0 / point.radius();

        return new Point(
            c * (Math.cos(point.tang()) + Math.sin(point.radius())),
            c * (Math.sin(point.tang()) - Math.cos(point.radius()))
        );
    }
}
