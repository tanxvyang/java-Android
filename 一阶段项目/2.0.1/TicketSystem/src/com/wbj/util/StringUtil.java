package com.wbj.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
	
	public static boolean checkString(String str){
		return str == null || str.equals("")
				|| str.equals(ProjectStaticFinal.INFO_DATE)
				|| str.equals(ProjectStaticFinal.INFO_PRICE)
				|| str.equals(ProjectStaticFinal.INFO_TICKET_STATE);
	}
	
	public static boolean cheickPhoneNumber(String str){
		
		String phoneNumber = "1\\d{10}";
		return str.matches(phoneNumber);
		
	}
	public static boolean cheickIdNumber(String str){
		String IdNumber  = "\\d{18}";
		String IdNUmberChar = "\\d{17}[x]{1}";
		return str.matches(IdNumber)||str.matches(IdNUmberChar);
	}
	public static boolean cheickDate(String str) {
//		SimpleDateFormat sdf  = new SimpleDateFormat("yyyyMMddHH");
//		int i = sdf.parse(sdf.format(new Date())).compareTo(sdf.parse(str));
		String dateChar = "^(?<year>\\d{2,4})-(?<month>\\d{1,2})-(?<day>\\d{1,2})$ ";
		return str.matches(dateChar);
	}
	public static boolean cheickMoney(String str){
		String money = "^[0-9]*+([.]{1}[0-9]{0,2}){0,1}$";;
		
		return str.matches(money);
		
	}


}
