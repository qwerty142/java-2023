package edu.project4.Models;

public class Pixel {
    protected int r;
    protected int g;
    protected int b;
    protected int hitCount;
    protected double nValue;

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public int getHitCount() {
        return hitCount;
    }

    public double getNormal() {
        return nValue;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void incrementHitCount() {
        hitCount++;
    }

    public Pixel(int r, int g, int b, int hit) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.hitCount = hit;
        nValue = 0;
    }

    public void setNormal(double normal) {
        nValue = normal;
    }
}
