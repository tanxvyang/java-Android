package jdbc.service;

import jdbc.entity.User;
import jdbc.exception.DuplicateUsernameException;
import jdbc.exception.UserDisableException;
import jdbc.exception.UserNotFoundException;

/**
 * 用户服务对象
 *
 * @author 谭旭洋
 */
public interface UserService {

    /**
     * 用户注册
     *
     * @param user 封装了用户注册信息的用户对象
     * @throws DuplicateUsernameException      重复的用户名异常，当用户注册的用户名在本系统中存在时，抛出此异常
     * @throws jdbc.exception.ServiceException 服务失败异常，当此业务处理未成功时，抛出此异常
     */
    public void regist(User user) throws DuplicateUsernameException;

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 封装了登录用户信息的用户对象
     * @throws UserNotFoundException           用户不存在异常，当用户输入的用户名或密码错误时，抛出此异常
     * @throws UserDisableException            用户被禁用异常，当登录的用户已被禁用时，抛出此异常
     * @throws jdbc.exception.ServiceException 服务失败异常，当此业务处理未成功时，抛出此异常
     */
    public User login(String username, String password) throws UserNotFoundException, UserDisableException;
}
