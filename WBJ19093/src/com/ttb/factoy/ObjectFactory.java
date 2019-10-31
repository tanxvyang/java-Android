package com.ttb.factoy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ObjectFactory {
	static Map<String, Object> store = new HashMap<String, Object>();
	
	static{
		BufferedReader br = new BufferedReader(new InputStreamReader(
				ObjectFactory.class.getClassLoader().getResourceAsStream("object.properties")));
		try {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] params = line.split("=");
					store.put(params[0], Class.forName(params[1]).newInstance());			
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//		Properties prop = new Properties();
//		try {
//			prop.load(ObjectFactory.class.getClassLoader()
//					.getResourceAsStream("object.properties"));
//			Set keySet = prop.keySet();
//			for (Object key : keySet) {
//				Object value = prop.get(key);
//				Class clazz = Class.forName(value.toString());
//				Object obj = clazz.newInstance();
//				store.put(key.toString(), obj);
//			}
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
	}
	
	public static Object getObject(String name){
		return store.get(name);
	}
}
