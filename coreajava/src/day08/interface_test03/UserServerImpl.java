package day08.interface_test03;

import com.sun.org.apache.bcel.internal.generic.RETURN;
                          //实现  空心三角,虚线
public class UserServerImpl implements UserService {
    @Override
    public boolean login(String username, String password) {
        if ("abc".equals(username) && "123".equals(password)) {
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
