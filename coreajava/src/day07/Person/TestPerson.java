package day07.Person;

public class TestPerson {
    public static void main(String[] args) {
        // Person b=new Boby("boby");
        // b.move();

        Person p=new Person("ppp");

        Plain plain=new Plain();

        p.move(plain);

        Train train=new Train();

        p.move(train);



    }
}
