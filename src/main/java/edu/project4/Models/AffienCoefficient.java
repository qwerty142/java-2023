package edu.project4.Models;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("checkstyle:MagicNumber")
public class AffienCoefficient {
    private static final int COLOR_BLOCK = 256;
    public double[] values = new double[6];
    // values <=> a b c d e f in afien transformation
    public Color color;

    public AffienCoefficient(double[] values, Color color) {
        this.values = values;
        this.color = color;
    }

    public static AffienCoefficient createCoefs() {
        boolean isValid = false;
        double[] val = new double[6];
        while (!isValid) {
            for (int i = 0; i < 6; i++) {
                val[i] = ThreadLocalRandom.current().nextDouble(-1, 1);
            }
            isValid = checkValues(val);
        }

        return new AffienCoefficient(val, getColor());
    }

    private static Color getColor() {
        return new Color(
            ThreadLocalRandom.current().nextInt(0, COLOR_BLOCK),
            ThreadLocalRandom.current().nextInt(0, COLOR_BLOCK),
            ThreadLocalRandom.current().nextInt(0, COLOR_BLOCK));
    }

    static boolean checkValues(double[] values) {
        return (Math.pow(values[0], 2) + Math.pow(values[3], 2) < 1)
            && (Math.pow(values[1], 2) + Math.pow(values[4], 2) < 1)
            && (Math.pow(values[0], 2) + Math.pow(values[1], 2) + Math.pow(values[3], 2) + Math.pow(values[4], 2)
        < 1 + Math.pow(values[0] * values[4] - values[1] * values[3], 2));
    }

    public Point transPointByAffine(Point point) {
        double newX = values[0] * point.x() + values[1] * point.y() + values[2];
        double newY = values[3] * point.x() + values[4] * point.y() + values[5];
        return new Point(newX, newY);
    }
}
