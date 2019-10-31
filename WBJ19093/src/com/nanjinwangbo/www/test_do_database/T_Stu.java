package com.nanjinwangbo.www.test_do_database;

public class T_Stu {//表中对应的类
	private String name;
	private Integer age;
	
	public T_Stu(String data){
		String[] datas = data.split(Constants.FN_GE_FU);
		this.name = datas[0];
		this.age = Integer.valueOf(datas[1]);
	}
	
	public T_Stu(String name, Integer age) {
		
		this.name = name;
		this.age = age;
	}
	public T_Stu() {
	
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
	@Override
	public String toString() {
		return name+Constants.FN_GE_FU+age;
	}
	
	
	
	
	
	
	

}
