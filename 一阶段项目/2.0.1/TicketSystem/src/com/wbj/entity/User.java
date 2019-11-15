package com.wbj.entity;

public class User {

	private Integer id ; //用户 id
	private String username;//用户名
	private String password;//密码	
	private String name;///用户姓名
	private String phone_number;//电话号码
	private String id_number;//身份证号
	private Double balance;//余额
	private String user_state;//用户状态标识 1用户，2：管理员，3：封禁
	
	
	
	public User() {
		super();
	}
	public User(Integer id, String username, String password, String name,
			String phoneNumber, String idNumber, Double balance,
			String userState) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		phone_number = phoneNumber;
		id_number = idNumber;
		this.balance = balance;
		user_state = userState;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phoneNumber) {
		phone_number = phoneNumber;
	}
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String idNumber) {
		id_number = idNumber;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getUser_state() {
		return user_state;
	}
	public void setUser_state(String userState) {
		user_state = userState;
	}



}
