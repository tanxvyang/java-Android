package day07.test6;

//属性是不能重写的
public class test08 {
    public static void main(String[] args) {
        E e = new E();
        //e.setI(3);
        System.out.println(e.getI());


    }
}

class D {

    //  private int i=1;  //使打印2
    public int i = 1;   //使打印 1

    public void setI(int i) {
        this.i = i;
    }


}

class E extends D {
    private int i = 2;

    // @Override
    // public void setI(int i) {
    //     this.i = i;
    // }     //可打印出   3


    // public int getI() {   //使打印2
    //     return i;
    // }


    public int getI() {
        return super.i;   //使打印 1
    }

}

