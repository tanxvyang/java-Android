package com.ttb.entity;

public class User {
	private Integer uid;
	private String username;
	private String password;
	private Double usermoney;
	
	public User() {
		
	}
	public User(Integer uid, String username, String password, Double usermoney) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.usermoney = usermoney;
	}
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
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
	public Double getUsermoney() {
		return usermoney;
	}
	public void setUsermoney(Double usermoney) {
		this.usermoney = usermoney;
	}
	
}
