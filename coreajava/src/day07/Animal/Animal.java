package day07.Animal;

public class Animal {

    private String name;
    private int age;

    //加构造方法后子类报错,是因为没有调用父类构造方法
    public Animal(String name) {
        this.name = name;
        age=1;
    }

    //方法的同样可以继承
     public void eat(){
         System.out.println("吃");
     }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
