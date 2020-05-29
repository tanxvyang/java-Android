package exception;

/**
 * 用户被禁用异常
 *
 * @author 李恒
 */
public class UserDisabledException extends Exception {

    public UserDisabledException() {
    }

    public UserDisabledException(String message) {
        super(message);
    }

    public UserDisabledException(Throwable cause) {
        super(cause);
    }

    public UserDisabledException(String message, Throwable cause) {
        super(message, cause);
    }

}
