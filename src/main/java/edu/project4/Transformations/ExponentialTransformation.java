package edu.project4.Transformations;

import edu.project4.Models.Point;

public class ExponentialTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double c = Math.exp(point.x() - 1);
        return new Point(
            c * Math.cos(Math.PI * point.y()),
            c * Math.sin(Math.PI * point.y())
        );
    }
}
