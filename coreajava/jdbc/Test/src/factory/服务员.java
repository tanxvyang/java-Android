package factory;

public class 服务员 {
    public static 菜单 get菜() {
        return new 厨师();
    }
}
