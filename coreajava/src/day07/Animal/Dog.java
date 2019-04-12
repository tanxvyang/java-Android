package day07.Animal;
//狗是动物
public class Dog extends Animal{
    public Dog(String name) {
        super(name);    //调用父类构造方法
    }
    public void eat(){
        System.out.println(getName()+"正在吃肉");
    }
}
