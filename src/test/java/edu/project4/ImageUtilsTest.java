package edu.project4;

import edu.project4.Models.FractalImage;
import edu.project4.Models.ImageFormat;
import edu.project4.Models.Pixel;
import edu.project4.Servicies.ImageUtils;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Path;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ImageUtilsTest {
    @Test
    public void ImageExistsTest() throws IOException {
        Pixel[][] pixels = new Pixel[1][1];
        pixels[0][0] = new Pixel(1, 1, 1, 0);
        Path path = Path.of("Image");
        ImageUtils.getAndSave(new FractalImage(pixels, 1, 1), ImageFormat.PNG, path);
        assertThat(path).exists();
    }
}
