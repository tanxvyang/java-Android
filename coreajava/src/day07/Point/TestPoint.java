package day07.Point;

import com.sun.xml.internal.bind.v2.util.EditDistance;
import sun.security.util.DisabledAlgorithmConstraints;

public class TestPoint {
    public static void main(String[] args) {

        point p1=new point(0,0);
        point p2=new point(1,1);
        circle c1=new circle(p1,p1.distance(0,1));

        System.out.println(p1+"\n"+"distance="+p1.distance(0,1)+"\n center="+c1.getCenter()+"\n r="+c1.getR()+"\n  area="+c1.area());

      /*  point{x=0.0, y=0.0}
        distance=1.0
        center=point{x=0.0, y=0.0}
        r=1.0
        area=3.141592653589793*/



        System.out.println(p2);


      /*  point{x=1.0, y=1.0}

        */
        System.out.println(p1.distance(0,6));       //42.0        ???????????





    }
}
