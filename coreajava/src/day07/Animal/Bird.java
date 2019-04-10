package day07.Animal;
//鸟是动物
public class Bird extends Animal{

    private String color;

    public Bird(String name, String color) {
        super(name);
        this.color = color;  //不能写在super()前
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void sing(){
        System.out.println("singsong");
    }
}
