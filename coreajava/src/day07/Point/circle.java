package day07.Point;

import java.awt.*;

public class circle {
    private point center;
    private double r;

    public circle(point center, double r) {
        this.center = center;
        this.r = r;
    }

    public circle(double x, double y, double r) {
        this(new point(x, y), r);

    }


    //单位圆
    public circle() {
        this(1);
    }


    public point getCenter() {
        return center;
    }

    public void setCenter(point center) {
        this.center = center;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public circle(double r) {
        this(new point(), r);
    }

    public double getX() {
        if (center != null) {
            return center.getX();
        }
        return 0;//不应该return 0 ,后面解决,暂时return0        ,因为如果这个圆没有圆心,也就不存在圆心,应该返回null

    }

    public void setX(double x) {   //非空保护
        if (center != null) {
            center.setX(x);
        }
    }

    public double getY() {         //改成Double 可解决
        if (center != null) {
            return center.getY();
        }
        return 0;//不应该return 0 ,后面解决,暂时return0        ,因为如果这个圆没有圆心,也就不存在圆心,应该返回null

    }

    public void setY(double y) {
        if (center != null) {
            center.setY(y);
        }
    }


    public double area() {
        return Math.PI * r * r;
    }


    public boolean contains(point point) {
        return point.distance(center) < r;
    }

    public boolean contains(double x, double y) {
        return contains(new point(x, y));
    }

}
