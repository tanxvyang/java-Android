package day07.Person;

public class Boby extends Person {

    public Boby(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println(getName() + "在爬");
    }
}
