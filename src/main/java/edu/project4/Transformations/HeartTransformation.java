package edu.project4.Transformations;

import edu.project4.Models.Point;

public class HeartTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = Math.sqrt(point.x() * point.x() + point.y() * point.y());
        double atan = Math.atan(point.x() / point.y());
        return new Point(r * Math.sin(atan * r),
            -r * Math.cos(atan * r));
    }
}
