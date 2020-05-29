package day03;

import java.util.Scanner;

//��100���ڵ���������
public class Test10 {
    public static void main(String[] args) {
	/* for (int i=2;i<100;i++){
		 boolean b=true;
		 for (int j=2;j<i;j++){
			 
			 if(i%j==0){
				 b=false;
				 break;
				 
			 }
		 }
		 
		 if (true==b){
			 System.out.println(i);
		 }
	 }
*/


        Scanner sc = new Scanner(System.in);
        int score;

        do {
            System.out.println("������ɼ���");
            score = sc.nextInt();

        } while (score < 0 || score > 100);


        //�������������Ϸ���������Ч����ʾ����ֹͣ����
	/*  int score=sc.nextInt() 
	 * 
	 * while(score<0||score>100){
			System.out.println("������Ч ��");
		  //return;      //����ֹͣ
			System.exit(0);//  ֹͣ�����
		} 
		*/
        System.out.println(score);
        char lv;
        if (score >= 90) {
            lv = 'A';
        } else if (score >= 80) {
            lv = 'B';
        } else if (score >= 70) {
            lv = 'C';
        } else if (score >= 60) {
            lv = 'D';
        } else {
            lv = 'E';
        }
        System.out.println(lv);


    }
}
