package day08.interface_test02.shibing;

import day08.interface_test02.able.Attachable;
import day08.interface_test02.able.Mobile;


public class Test_shibing {
    public static void main(String[] args) {

        Tank t1=new Tank();
        Tank t2=new Tank();
        Doctors d1=new Doctors();
        Marines m1=new Marines();
        Marines m2=new Marines();
        Marines m3=new Marines();

        Mobile[] mobiles={t1,t2,d1,m1,m2,m3};
        for (int i=0;i<mobiles.length; i++){
            mobiles[i].Move();
        if (mobiles[i] instanceof Attachable){
            ((Attachable)mobiles[i]).attack();
        }

    }

    }
}
