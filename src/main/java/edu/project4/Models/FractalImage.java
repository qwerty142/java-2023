package edu.project4.Models;

public record FractalImage(Pixel[][] data, int width, int height) {
    public Pixel getPixel(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return null;
        }
        return data[y][x];
    }
}
