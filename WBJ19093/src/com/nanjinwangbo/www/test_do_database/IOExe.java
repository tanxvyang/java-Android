package com.nanjinwangbo.www.test_do_database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IOExe {
	public static void main(String[] args) {
		List<T_Stu> relist = select(null,null);
		for (T_Stu tStu : relist) {
			System.out.println(tStu.getName());
		}
	}




	/**
	 * 查寻方法,通过name 或 age进行查询
	 * @param name
	 * @param age
	 * @return
	 */
	public static List<T_Stu> select(String name,Integer age){
		List<T_Stu> result = new ArrayList<T_Stu>();
		BufferedReader br = null;//整行读取，一行表示一个student对象
		try {
			br = new BufferedReader(new FileReader("/home/soft01/io/a/T_stu.txt"));
			String line = null;//每行数据
			while ((line = br.readLine())!=null) {
				//根据读到的一行数据生成一个学生对象，生成方法在T_stu的构造方法中
				T_Stu stu = new T_Stu(line);
				//当对名字有要求，但查到的不符合要求时，直接进入下一循环
				if (name != null&&!stu.getName().equals(name)) {
					continue;
				}
				//当对名字有要求，但查到的不符合要求时，直接进入下一循环
				if (age != null && !stu.getAge().equals(age) ) {
					continue;
				}
				//满足条件
				result.add(stu);
				
			}
			
		} catch (Exception e) {
			
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}


}