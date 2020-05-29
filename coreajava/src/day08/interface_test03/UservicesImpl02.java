package day08.interface_test03;

public class UservicesImpl02 implements UserService {
    @Override
    public boolean login(String username, String password) {
        if ("aaa".equals(username) && "123".equals(password)) {
            return true;
        }
        return false;
    }
}
