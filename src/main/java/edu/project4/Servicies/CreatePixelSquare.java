package edu.project4.Servicies;

import edu.project4.Models.AffienCoefficient;
import edu.project4.Models.FractalImage;
import edu.project4.Models.Pixel;
import edu.project4.Models.Point;
import edu.project4.Models.Rect;
import edu.project4.Transformations.Transformation;
import java.awt.Color;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class CreatePixelSquare {
    @SuppressWarnings("checkstyle:MagicNumber")
    private static int firstIterations = -20;

    private CreatePixelSquare() {}


    public static void createPixelSquare(
        FractalImage image,
        Rect rect,
        int symmetry,
        int it,
        AffienCoefficient[] coefficients,
        List<Transformation> transformations
        ) {
        Color color = null;
        Point point = rect.getPoint();
        for (int i = firstIterations; i < it; i++) {
            AffienCoefficient randAfienCoef = coefficients[ThreadLocalRandom.current().nextInt(0, coefficients.length)];
            point = randAfienCoef.transPointByAffine(point);
            Transformation transformation = transformations
                .get(ThreadLocalRandom.current().nextInt(0, transformations.size()));
            point = transformation.apply(point);
            if (i >= 0) {
                double t = 0;
                for (int j = 0; j < symmetry; j++) {
                    t += 2 * Math.PI / symmetry;
                    Point rPoint = new Point(
                        point.x() * Math.cos(t) - point.y() * Math.sin(t),
                        point.x() * Math.sin(t) + point.y() * Math.cos(t)
                    );
                    if (!rect.inBoards(rPoint)) {
                        continue;
                    }
                    Pixel pixel = image.getPixel(
                        (int) ((rPoint.x() - rect.x()) * image.width() / rect.width()),
                        (int) ((rPoint.y() - rect.y()) * image.height() / rect.height())
                    );
                    if (pixel == null) {
                        continue;
                    }
                    synchronized (pixel) {
                        setColor(pixel, randAfienCoef, color);
                        pixel.incrementHitCount();
                    }
                }
            }
        }
    }

    @SuppressWarnings("checkstyle:ParameterAssignment")
    private static void setColor(Pixel pixel, AffienCoefficient coefficient, Color color) {
        if (color == null) {
            color = coefficient.color;
        }
        if (pixel.getHitCount() == 0) {
            pixel.setR(color.getRed());
            pixel.setG(color.getGreen());
            pixel.setB(color.getBlue());
        } else {
            pixel.setR((color.getRed() + coefficient.color.getRed()) / 2);
            pixel.setG((color.getGreen() + coefficient.color.getGreen()) / 2);
            pixel.setB((color.getBlue() + coefficient.color.getBlue()) / 2);
        }
    }
}
