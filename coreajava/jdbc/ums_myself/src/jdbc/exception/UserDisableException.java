package jdbc.exception;

/**
 * 用户被禁用异常
 *
 * @author 谭旭洋
 */
public class UserDisableException extends Exception {
    public UserDisableException() {
    }

    public UserDisableException(String message) {
        super(message);
    }

    public UserDisableException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDisableException(Throwable cause) {
        super(cause);
    }

    public UserDisableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
