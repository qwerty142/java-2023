package edu.project4.Transformations;

import edu.project4.Models.Point;

public class HorsehoeTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        return new Point(
            (point.x() - point.y()) * (point.x() + point.y()) / point.radius(),
            2 * point.x() * point.y() / point.radius()
        );
    }
}
