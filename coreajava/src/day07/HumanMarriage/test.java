package day07.HumanMarriage;

public class test {

    public static void main(String[] args) {
        person p1=new person("aaa",true) ;
        person p2=new person("aaa",true) ;
        person p3=new person("aaa",false) ;
      //  p1.marry(p2);
        boolean  b=p1.marry(p3);
        if (true==b){
            System.out.println("结婚");
        }

        p2.marry(p3);




    }


}
