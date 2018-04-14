package day03;

public class Test1 {

	public static void main(String[] args) {
	int i=1;
	String s="abc";  //string类型是引用类型
	
	String s2 =new String("qwe");
	String s3 =new String("qwe");
	System.out.println(s3.equals(s2));
	}

}
