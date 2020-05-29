package day11.Graphics;

public class Circle extends Graphics {
    private Double r;

    public Circle() {
    }

    public Circle(Double r) {
        this.r = r;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    @Override
    public Double area() {
        return Math.PI * r * r;
    }
}
