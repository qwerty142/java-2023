package edu.project4.Transformations;

import edu.project4.Models.Point;

public class TangensTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        return new Point(
            Math.sin(point.x()) / Math.cos(point.y()),
            Math.tan(point.y())
        );
    }
}
