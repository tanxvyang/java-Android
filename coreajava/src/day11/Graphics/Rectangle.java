package day11.Graphics;

import java.awt.geom.RoundRectangle2D;

public class Rectangle extends Graphics {
    private Double w;
    private Double h;

    public Rectangle() {
    }

    public Rectangle(Double w, Double h) {
        this.w = w;
        this.h = h;
    }

    public Double getW() {
        return w;
    }

    public void setW(Double w) {
        this.w = w;
    }

    public Double getH() {
        return h;
    }

    public void setH(Double h) {
        this.h = h;
    }

    @Override
    public Double area() {
        return w * h;
    }
}
