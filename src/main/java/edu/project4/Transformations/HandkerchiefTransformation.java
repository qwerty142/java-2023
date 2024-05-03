package edu.project4.Transformations;

import edu.project4.Models.Point;

public class HandkerchiefTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        return new Point(
            point.radius() * Math.sin(point.tang() + point.radius()),
            point.radius() * Math.cos(point.tang() - point.radius())
        );
    }
}
