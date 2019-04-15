package day08.interface_test03;

public class UserServiceFactory {
    public static UserService getUserservice(){

       // return  new UserServerImpl();  //
         return  new UservicesImpl02();  //

    }
}
