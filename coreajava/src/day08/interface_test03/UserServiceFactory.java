package day08.interface_test03;

public class UserServiceFactory {
                             //获得一个userservice
    public static UserService getUserservice(){

       // return  new UserServerImpl();  //
         return  new UservicesImpl02();  //返回一个userservice,子是父

    }
}
