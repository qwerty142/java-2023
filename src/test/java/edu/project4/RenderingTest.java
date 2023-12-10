package edu.project4;

import edu.project4.Models.AffienCoefficient;
import edu.project4.Models.FractalImage;
import edu.project4.Models.Pixel;
import edu.project4.Models.Rect;
import edu.project4.Servicies.CreatePixelSquare;
import edu.project4.Servicies.CreatePixelSquareParallel;
import edu.project4.Transformations.HandkerchiefTransformation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.awt.Color;
import java.util.List;

public class RenderingTest {
    @Test
    public void worksWithoutExceptionsTest() {
        Pixel[][] pixels = new Pixel[1][1];
        AffienCoefficient[] coefficients = new AffienCoefficient[1];
        coefficients[0] = new AffienCoefficient(new double[] {1.0, 1, 1, 1, 1, 1}, Color.BLUE);
        Assertions.assertDoesNotThrow(() -> CreatePixelSquare.createPixelSquare(
            new FractalImage(pixels, 6, 6),
            new Rect(1, 1, 1, 1),
            1,
            1,
            coefficients,
            List.of(new HandkerchiefTransformation())
        ));

        Assertions.assertDoesNotThrow(() -> CreatePixelSquareParallel.createPixelSquareParallel(
            new FractalImage(pixels, 6, 6),
            new Rect(1, 1, 1, 1),
            1,
            1,
            coefficients,
            List.of(new HandkerchiefTransformation()),
            3
        ));
    }
}
