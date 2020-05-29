package day09.object_equals;

import com.sun.org.apache.xpath.internal.operations.Equals;

import java.util.Objects;

public class person implements Cloneable {
    private String id;
    private String name;
    private int age;
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

    // @Override
    // public boolean equals(Object obj) {
    //     if (this==obj) {
    //         return true;
    //     }
    //     if (obj==null){
    //         return false;
    //     }
    //
    //     if (obj instanceof person){
    //
    //         //少了保护操作,  比如,这些属性为空怎么办
    //         person p=(person) obj;
    //         return  this.id.equals(p.id)&&this.name.equals(p.name);
    //     }
    //     return false;
    //
    //
    // }

    // @Override
    // public int hashCode() {
    //     //return 1;
    //     return id.hashCode()*46+name.hashCode()/32;
    // }

    // @Override
    // public int hashCode() {
    //     return super.hashCode();
    // }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        person person = (person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("person.finalize");
        super.finalize();
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}
