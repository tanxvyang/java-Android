package exception;

/**
 * 用户不存在异常
 * @author 李恒
 *
 */
public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
	}

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
