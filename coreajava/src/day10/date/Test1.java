package day10.date;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Test1 {
    public static void main(String[] args) {
        //int i=1;
        //Object i=1;  //object 并不是int的父类型,但却可以


        // Integer  i=1;        //Integer 包装类型      //auto Boxing 自动装箱  基本类型->引用类型
        // System.out.println(i+1);//auto unboxing  //主动解箱

        // System.out.println(Integer.MIN_VALUE);
        // System.out.println(Integer.MAX_VALUE);


        // String s="123";
        // int i=Integer.parseInt(s);  //字符串转int
        // System.out.println(i+1);

        //        int i=1;
        //        String s =i+"";   //int 转字符串
        //        System.out.println(s+1);
        //
        //int ->String


        //int -> Integer
        //   Integer i=1;  //auto boxing
        //  System.out.println(i+1);

//integer -> int
        // int i= new Integer(1);//auto unboxing
        //System.out.println(i+1);


//Long -> Integer
// integer.intValue();
        //int i= (int) 1L;
        //Integer i=1L;
        //Integer i=new  Long(1).intValue();


//Integer ->string
//         Integer i=1;
//         String s=i.toString();
//         System.out.println(s);
//

//BigDecimal 精确计算
        BigDecimal b1 = new BigDecimal("12.345");
        BigDecimal b2 = new BigDecimal("12");
        System.out.println(b1.subtract(b2));

//BigInteger  大整数计算
        BigInteger b3 = new BigInteger("12121212312312331231231313");
        BigInteger b4 = new BigInteger("12121212312312331231231313");
        System.out.println(b3.subtract(b4));
    }
}


