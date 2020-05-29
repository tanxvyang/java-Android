package day11.Graphics;

import java.util.Arrays;

public class TestGraphics {
    public static void main(String[] args) {
        Circle c1 = new Circle(6.0);
        Circle c2 = new Circle(2.0);
        Rectangle r1 = new Rectangle(6.0, 9.0);
        Rectangle r2 = new Rectangle(7.0, 5.0);
        Triangle t1 = new Triangle(44.0, 11.0);
        Triangle t2 = new Triangle(3.0, 8.0);

        Graphics[] graphics = {c1, c2, r1, r2, t1, t2};
        Arrays.sort(graphics);
        System.out.println(Arrays.toString(graphics));
    }
}
