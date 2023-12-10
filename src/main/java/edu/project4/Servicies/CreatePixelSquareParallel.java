package edu.project4.Servicies;

import edu.project4.Models.AffienCoefficient;
import edu.project4.Models.FractalImage;
import edu.project4.Models.Rect;
import edu.project4.Transformations.Transformation;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class CreatePixelSquareParallel {
    private CreatePixelSquareParallel() {}

    @SuppressWarnings("checkstyle:ConstantName")
    private static final ExecutorService service = Executors
        .newFixedThreadPool(Runtime.getRuntime().availableProcessors() - 1);

    public static void createPixelSquareParallel(
        FractalImage image,
        Rect rect,
        int symmetry,
        int it,
        AffienCoefficient[] coefficients,
        List<Transformation> transformations,
        int samples
    ) {
        for (int i = 0; i < samples; i++) {
            service.execute(() -> CreatePixelSquare.createPixelSquare(
                image,
                rect,
                symmetry,
                it,
                coefficients,
                transformations
            ));
        }
        service.shutdown();
    }
}
