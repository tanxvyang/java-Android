package day07.Person;

public class Person {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }


    public  void move(){
        System.out.println(name+"在走路");
    }

    public void move(Transport t){

        System.out.print(name+"乘坐");
        t.move();
    }



}
