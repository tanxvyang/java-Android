package day03;

public class Test4 {

	public static void main(String[] args) {
//		int i=1;
//		System.out.println(i);
		
		String 	username="abc";
		//String username=null 
		//如果（获得用户名 并且获得的用户名不是什么都没填）
		if(username!=null&&!username.equals("")){
			System.out.println("登录操作");
			//否则 
		}else{
			System.out.println("重新输入用户名");
		}

	}

}
