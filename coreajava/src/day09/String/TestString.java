package day09.String;

import com.sun.deploy.util.StringUtils;
import org.omg.CORBA.ARG_OUT;
import sun.management.Agent;

import javax.sql.rowset.Joinable;
import java.util.Arrays;
import java.util.Scanner;

public class TestString {
    public static void main(String[] args) throws Exception {


        //转换字符串和编码
        // String string = "中";
        // System.out.println(string);
        // byte[] bytes = string.getBytes("utf-8");
        // System.out.println(bytes.length);


        // String s1=new String("abc");
        // String s2="abc";
        // String s3="ab"+"c";
        // String s4="ab";
        // String s5 = "c";
        // String s6 = s4+s5;   //是abc,但是是从缓冲区出来的,因此和其他的不一样
        // String s7= s1.toUpperCase();   //返回的是一个新的对象

        //
        // System.out.println(s2==s3);
        // System.out.println(s2==s1);
        // System.out.println(s2==s6);
        // System.out.println(s7);


        //
        // String s1 = "abc";          //1
        //
        // s1 = "aaaa";                //1
        // String s2 = new String("abc");  //1
        // String s3 = s1+s2;           //1
        // String s4 = "aaaaabc";      //1
        // String s5 = s1+s2;            //1
        //
        //
        //
        // System.out.println(s1.hashCode());
        // System.out.println(s3==s5);

// String s= "asdfafagdgtgretwrtgwrt233145 435625677s6";
//          System.out.println(s.length());
//         // System.out.println(s.charAt(2)); //根据下标找值
        //
        // System.out.println(s.substring(20));  //截取操作从这个位置一直到结尾
        //
        // System.out.println(s.substring(4,8));  //从4开始到8,但不包括8
        //
        // s.substring(0,3);   //一个新字符串,但么有赋值
        // System.out.println(s);


        // System.out.println(s.indexOf("s"));//根据字符返回位置,第一次出现s的位置
        // System.out.println(s.lastIndexOf("s"));//最后一次出现s的位置
        // String  s = "age:12";
        //     System.out.println(s.startsWith("age"));
        //
        // String  s1 = "a.jpg";
        //     System.out.println(s1.endsWith(".txt"));
        //
        //     String s2 = "abcd";
        //
        //     System.out.println(s2.contains("e"));//判断字符是否在字符串中,在则true
        //
        //     System.out.println(s2.indexOf("e"));  //不在则返回-1
        //     System.out.println(s2.toUpperCase());
        //     System.out.println(s2.toLowerCase());
        //     System.out.println("abc".equals("ABC"));
        //     System.out.println("abc".equalsIgnoreCase("ABC")); //忽略大小写


        // String s = "         asdg  afa         ";
        // System.out.println(s);
        // System.out.println(s.trim()); //删除两边的空格,注意,只删除两边的空白
        // System.out.println(s);        //trim并没有改变原有字符串

        //String s = "asdfaaghadg134125gewrehryhgfsdfage234325345";

        //  System.out.println(s.replaceAll("\\d+","x"));

        //System.out.println(s.replace("a","x")); //将原有的a都替换成x

        // String s2 = s.replace("a",""); //通过替换a为空,而计算a的个数
        // System.out.println(s.length()-s2.length());


        // 025-12345678
        //   Scanner sc = new Scanner(System.in);
        //
        //   String s1 = sc.nextLine();
        //
        //   String regex = "\\d{3,4}-\\d{8}";//"[a-z]"; //"[abc]"; "[\\d]";/输入的是数字,\d
        //
        //   System.out.println(s1.matches(regex));//判断s1是否属于abc
        //
        // // System.out.println("\\");

        // String s5 = "12345678909,09876543212,12354676543,25343456789,13182856528";
        //将中间几位替换成*  ,只替换一部分,$1表示位置
        //System.out.println(s5.replaceAll("(\\d{3})(\\d{5})(\\d{3})","$1*****$3"));

//******
//         String[] ss = s5.split(",");
//         for (int i = 0;i<ss.length;i++) {
//              System.out.println(ss[i]);
//     }
//
// String s7 = "adfaff";
//         char[] cs = s7.toCharArray();
//         System.out.println(Arrays.toString(cs));


        // String[] arr = {"a","b","c","d"};
        // String s = join(arr,","); //"a,b,c"


        // String[] arr = {"a", "b", "c", "d"};
        // String s=StringUtil.join(arr,",");
        // System.out.println(s);


    }
}
