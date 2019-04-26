package day09.object_clone;

public class person implements Cloneable{
    private String id;
    private  String name;
    private  int age;
    private boolean sex;
    private Addres addr;

    public Addres getAddr() {
        return addr;
    }

    public void setAddr(Addres addr) {
        this.addr = addr;
    }

    public person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return id+" "+name;
    }
}
