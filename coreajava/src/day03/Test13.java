package day03;
//	 打印乘法口诀表
public class Test13 {

	public static void main(String[] args) {
		
		for(int i=1;i<9;i++){//控制行
			
			for(int j=1;j<i;j++){//控制列
				System.out.print(j+"X"+i+"="+(j*i)+"\t");
				
				
			}
			System.out.println();//换行
		}
		
	}

}
