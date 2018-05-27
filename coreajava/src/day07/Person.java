package day07;

public class Person {
    //特征 属性
    private String name;
    private int age;
    private boolean sex;
    private double money;

    //行为 方法

    //构造方法
    public Person(String n, boolean s) {
        name = n;
        sex = s;
        age = 1;
        money = 0.0;
    }

    public Person(boolean s) {
        sex = s;
        age = 1;
        money = 0.0;
    }

    //方法

    public void eat(String food) {
        System.out.println(name + "正在吃" + food);
    }

    public void sleep() {
        System.out.println(name + "正在睡觉");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int a) {
        if (a < 1 || a > 150) {
            System.out.println("年龄不符合现实逻辑");

            return;
        }

        age = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
     // name = name;
        System.out.println("setName THIS:"+this);
        this.name=name;//当前对象，谁调用这个方法谁就是this
    }

    public String getSex() {
        return true == sex ? "男" : "女";
    }
}

