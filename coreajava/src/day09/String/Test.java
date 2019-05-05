package day09.String;
public class Test {
    public static void main(String[] args) {
        //String s = "";
       // StringBuffer s=new StringBuffer();
        StringBuilder s1 = new StringBuilder();
long start =System.currentTimeMillis();
        for (int i = 0;i < 9999999;i++) {
            //s+=1;
           // s.append("1");
            s1.append("1");
        }

        long end=System.currentTimeMillis();
       // System.out.println(s.length());
        System.out.println(s1.length());
        System.out.println(end-start);
    }
}
