package day05;

import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) {
        char[] c={'a','b'};

        System.out.println(c.length);
        char[] temp=new  char[c.length+1];  //新建一个数组

        //将c数组拷贝到temp数组中
     /*   for (int i=0;i<c.length;i++){
            temp[i]=c[i];
        }

        */

     System.arraycopy(c,0,temp,0,c.length);//copy函数  （原数组，原数组起始位置，目标数组，目标数组起始位置，拷贝长度）
        c = temp;
        //插入c【2】
        c[2]='c';


        System.out.println(c.length);
        System.out.println(Arrays.toString(c));
    }
}
