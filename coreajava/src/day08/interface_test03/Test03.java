package day08.interface_test03;

import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("用户登录");
        System.out.println("用户名:");
        String username = sc.nextLine();
        System.out.println("密码:");
        String password = sc.nextLine();


        //1UserServerImpl userServer=new UserServerImpl();

        //2UserService userServer=new UserServerImpl();
        UserService userServer = UserServiceFactory.getUserservice();

        boolean result = userServer.login(username, password);
        System.out.println((true == result) ? "登陆成功" : "用户名或密码错误");
    }
}
