package com.wbj.entity;

public class Student {
	private Integer id;
	private String name;
	private String city;
	private Integer age;
	private String password;
	public Student() {
	}
	public Student(Integer id, String name, String city, Integer age,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.age = age;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
