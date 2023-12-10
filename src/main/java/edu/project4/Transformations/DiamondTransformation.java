package edu.project4.Transformations;

import edu.project4.Models.Point;

public class DiamondTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        return new Point(
            Math.sin(point.tang()) * Math.cos(point.radius()),
            Math.cos(point.tang()) * Math.sin(point.radius())
        );
    }
}
