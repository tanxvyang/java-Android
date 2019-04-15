package day07.Person;

public abstract class Transport {
    public abstract void move(); //可以没有抽象方法

    public Transport() {   //有构造方法,但不是让外界new用的,是让子类构造方法使用的
    }


//抽象的方法和类,加abstract

  /*  {
        System.out.println("交通工具正在移动");
    }
*/

}
