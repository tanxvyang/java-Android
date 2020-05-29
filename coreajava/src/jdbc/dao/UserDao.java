package jdbc.dao;

import jdbc.entity.User;

/**
 * 用户数据访问对象
 *
 * @author 谭旭洋
 */
public interface UserDao {
    /**
     * 根据用户名查询一个用户
     *
     * @param username 用户名
     * @return 封装用户信息的用户对象，如果用户不存在，返回null
     * @throws DataAccessException 数据访问失败异常，当此持久化操作未成功时，抛出此异常
     */
    public User selectByUsername(String username);

    /**
     * 保存一个用户
     *
     * @param user 封装用户信息的用户对象
     * @throws DataAccessException 数据访问失败异常，当此持久化操作未成功时，抛出此异常
     */
    public void insert(User user);

    /**
     * 根据用户名和密码查询一个用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 封装用户信息的用户对象，如果不存在，返回null
     * @throws DataAccessException 数据访问失败异常，当此持久化操作未成功时，抛出此异常
     */
    public User selectByUsernameAndPassword(String username, String password);
}
