package entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体
 *
 * @author 李恒
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private Date registDate;
    private Integer status;

    public User() {
        super();
    }


    public Date getRegistDate() {
        return registDate;
    }


    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
