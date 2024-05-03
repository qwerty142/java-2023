package edu.project4.Servicies;

import edu.project4.Models.FractalImage;
import edu.project4.Models.Pixel;

public class GammaCorrection implements ImageProcessor {
    private static final double GAMMA_VALUE = 0.38;

    @Override
    public void gammaCorrect(FractalImage image) {
        double maxVal = 0;
        for (int x = 0; x < image.width(); x++) {
            for (int y = 0; y < image.height(); y++) {
                Pixel current = image.getPixel(x, y);
                if (current.getHitCount() != 0) {
                    current.setNormal(Math.log10(current.getHitCount()));
                    maxVal = Math.max(maxVal, current.getNormal());
                }
            }
        }

        for (int x = 0; x < image.width(); x++) {
            for (int y = 0; y < image.height(); y++) {
                Pixel current = image.getPixel(x, y);
                current.setNormal(current.getNormal() / maxVal);
                current.setR((int) (current.getR() * Math.pow(current.getNormal(), 1.0 / GAMMA_VALUE)));
                current.setG((int) (current.getG() * Math.pow(current.getNormal(), 1.0 / GAMMA_VALUE)));
                current.setB((int) (current.getB() * Math.pow(current.getNormal(), 1.0 / GAMMA_VALUE)));
            }
        }
    }
}
