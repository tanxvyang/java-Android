package com.wbj.entity;

public class User {

	private Integer id ; //�û� id
	private String username;//�û���
	private String password;//����	
	private String name;///�û�����
	private String phone_number;//�绰����
	private String id_number;//���֤��
	private Double balance;//���
	private String user_state;//�û�״̬��ʶ 1�û���2������Ա��3�����
	
	
	
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
