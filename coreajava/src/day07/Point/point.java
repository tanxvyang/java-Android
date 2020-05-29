package day07.Point;

import com.sun.org.apache.bcel.internal.generic.RET;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import sun.security.util.Length;

import java.sql.SQLOutput;

public class point {
    private double x;
    private double y;

    public static int count = 0;

    public static void f() {
        System.out.println(count);
        // System.out.println(x);//调用失败,static是在类加载时开始的,   类加载时没有x,只有当类创建以后才有x
    }


    public point(double x, double y) {
        this.x = x;
        this.y = y;

        count++;

    }

    public point() {
        this(0, 0);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


    //计算距离
    public double distance(double x, double y) {
        return Math.sqrt(Math.pow(this.x - x, 2)) + Math.pow(this.y - y, 2);

    }

    //调用了上一个方法
    public double distance(point point) {
        return distance(point.getX(), point.getY());     //??????????

    }

    //到原点的距离
    public double distance() {
        return distance(new point());

    }
    /*
     */


    @Override
    public String toString() {
        return "point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
