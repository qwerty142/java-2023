package edu.project4.Servicies;

import edu.project4.Models.FractalImage;
import edu.project4.Models.ImageFormat;
import edu.project4.Models.Pixel;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import javax.imageio.ImageIO;

public final class ImageUtils {
    private ImageUtils() {}

    public static void getAndSave(FractalImage fractalImage, ImageFormat imageFormat, Path path) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(fractalImage.width(),
            fractalImage.height(), BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < fractalImage.width(); x++) {
            for (int y = 0; y < fractalImage.height(); y++) {
                Pixel pixel = fractalImage.getPixel(x, y);
                Color color = new Color(pixel.getR(), pixel.getG(), pixel.getB());
                bufferedImage.setRGB(x, y, color.getRGB());
            }
        }

        ImageIO.write(bufferedImage, imageFormat.name(), path.toFile());
    }
}
