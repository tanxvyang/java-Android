package day03;

import java.util.Scanner;

public class Test7 {

    public static void main(String[] args) {
/*		//�������һ����-10~10�����������
  int num=(int) (Math.random()*(10-(-10+1))+(-10));
  //
  System.out.println(num);
   /*  //ʵ�ʿ�������Ҫʹ��  ���׶������׳���
 
  if(num>0){
	   //
    	System.out.println("����");
    }
   if(num<0){
	   System.out.println("����");   
   }
   if(num==0){
	   System.out.println("0");
   }
   */
  
  
 /* 
  if(num>0){
	  System.out.println("+");
  }else{
	  if(num<0){
		  System.out.println("-");
	  }else{
		  System.out.println("0");
	  }
  }
  */
  
  /*
  if(num>0){
	  System.out.println("+");
  }else if(num<0){
	  System.out.println("-");
  }else{
	  System.out.println("0");
  }
  */
  
		/*
		// ��ϰ������һ���� ���ж��Ƿ�������
		//�����ܱ�400����  ���ܱ�4�����Ҳ��ܱ�100������
		
		Scanner sc=new Scanner(System.in);
		System.out.println("��������ݣ�");
		//��ȡ�û�����
		int num=sc.nextInt();
		
		System.out.println("���������ǣ�"+num);
		//
		if((num%400==0)
				||(num%4==0&&num%100!=0)){
			//������
			System.out.println(num+"������");
		}else{
			//����������
			System.out.println(num+"��������");
		}
  */

        /*  ����һ���ɼ� 0-100֮�䣬�жϵȼ�

         */
        System.out.println("������ɼ���");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();

        //�������������Ϸ���������Ч����ʾ����ֹͣ����
		 /*   if(score<0||score>100){
				System.out.println("������Ч ��");
			  //return;      //����ֹͣ
				System.exit(0);//  ֹͣ�����
			}
			
			System.out.println(score);
			char lv;
			if(score>=90){
				lv='A';
			}else if(score>=80){
				lv='B';
			}else if(score>=70){
				lv='C';
			}else if(score>=60){
				lv='D';
			}else{
				lv='E';
			}
			System.out.println(lv);
  
  */

        //switch���������ʽ��{
//			case ����1��
//		����1  }	
        char lv;

        switch (score / 10) {
            case 10:
                lv = 'A';
                break;
            case 9:
                lv = 'A';
                break;
            case 8:
                lv = 'B';
                break;
            case 7:
                lv = 'C';
                break;
            case 6:
                lv = 'D';
                break;
            default:
                lv = 'E';
                break;
        }

        System.out.println(lv);
    }

}
