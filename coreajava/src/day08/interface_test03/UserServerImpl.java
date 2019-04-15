package day08.interface_test03;

public class UserServerImpl implements UserService {
    @Override
    public boolean login(String username, String password) {
        if ("abc".equals(username)&&"123".equals(password)){
            return true;
        }
        return false;
    }
 /*   public boolean login(String username,String password){
        if ("abc".equals(username)&&"123".equals(password)){
           return true;
        }
        return false;
    }*/


}
