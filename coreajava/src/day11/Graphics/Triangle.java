package day11.Graphics;

public class Triangle extends Graphics {
    private Double a;
    private Double h;

    public Triangle() {
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getH() {
        return h;
    }

    public void setH(Double h) {
        this.h = h;
    }

    public Triangle(Double a, Double h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public Double area() {
        return a * h / 2;
    }
}
