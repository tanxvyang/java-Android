package com.nanjinwangbo.www.day06;

import java.util.Scanner;

public class SuperMarket {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		//1����������5����Ʒ����Ϣ����������Ʒ�����۸񡢿�棩
		//2�������ϻ����¼ܣ�����µ���Ʒ��ɾ��������Ʒ��
		//3�����Գ�����Ʒ�����ݼ۸������������ܼۣ�������ɺ���ٿ�棬��治��ʱ����������
		//4�����������Ʒ��չʾ������Ʒ��Ϣ��
		//5���˳�ϵͳ����������
		System.out.println("��ӭ���ٱ�����");
		String[] goodNames = new String[10];//��Ʒ����
		goodNames[0] = "���";
		goodNames[1] = "��Ȫˮ";
		goodNames[2] = "�з�";
		double[] goodPrices = new double[10];//��Ʒ�۸�
		goodPrices[0] = 4.5;
		goodPrices[1] = 2;
		goodPrices[2] = 12;
		int[] goodNums = new int[10];//��Ʒ����
		goodNums[0] = 200;
		goodNums[1] = 1000;
		goodNums[2] = 1;
		while (true) {
			System.out.println(" ������ָ� ");
			System.out.println(" 1���鿴������Ʒ");
			System.out.println(" 2��������Ʒ");
			System.out.println(" 3�������Ʒ");
			System.out.println(" 4��ɾ����Ʒ");
			System.out.println(" 5���˳�ϵͳ");
			int code = sc.nextInt();
			switch (code) {
			case 1:
				for (int i = 0; i < goodNames.length; i++) {
					if(goodNames[i] == null){
						continue;
					}
					System.out.println("��Ʒ����"+goodNames[i]+
							",�۸�Ϊ��"+goodPrices[i]+",��棺"+goodNums[i]);
				}
				break;
			case 2:
				//������Ʒ
				System.err.println("Ҫ���ļ���Ʒ��������Ҫ�������Ʒ����");
				String goodNameTypeIn = sc.next();
				System.out.println("Ҫ����ټ���");
				int nums = sc.nextInt();
				boolean isGet = false;
				for (int i = 0; i < goodNums.length; i++) {
					if(goodNames[i] != null && goodNames[i].equals(goodNameTypeIn)){
						isGet = true;
						if(goodNums[i] >= nums){
							goodNums[i] -= nums;
							System.out.println("����Ҫ֧����"+goodPrices[i]*nums);
						}else{
							System.out.println("��治��");
						}
						break;
					}
				}
				if(!isGet){
					System.out.println("δ��ѯ����Ϊ��"+goodNameTypeIn+"����Ʒ��Ϣ");
				}
				break;
			case 3:
				int emptyIndex = -1;
				for (int i = 0; i < goodNums.length; i++) {
					if(goodNames[i] == null){
						emptyIndex = i;
						break;
					}
				}
				if(emptyIndex == -1){
					System.out.println("�ϼܿռ��������޷������Ʒ");
				}
				//����
				String newGoodName;
				double newGoodPrice;
				int newGoodNum;
				//ȡֵ��У�飩
				while (true) {
					System.out.println("������Ҫ��ӵ���Ʒ���ƣ�");
					newGoodName = sc.next();
					if(newGoodName==null||newGoodName.equals("")){//����У��
						System.out.println("��Ʒ������Ϊ�գ�����������");
						continue;
					}
					boolean hasSameName = false;
					for (int i = 0; i < goodNames.length; i++) {//ҵ���߼��ж�
						if(newGoodName.equals(goodNames[i])){
							System.out.println("��Ʒ�������ظ�������������");
							hasSameName = true;
							break;
						}
					}
					if(hasSameName){
						continue;
					}
					break;
				}
				while (true) {
					System.out.println("������Ҫ��ӵ���Ʒ�۸�");
					newGoodPrice = sc.nextDouble();
					if(newGoodPrice < 0){
						System.out.println("��Ʒ�۸���Ϊ��������������");
						continue;
					}
					break;
				}
				while (true) {
					System.out.println("������Ҫ��ӵ���Ʒ������");
					newGoodNum = sc.nextInt();
					if(newGoodNum < 0) {
						System.out.println("��Ʒ��������Ϊ��������������");
						continue;
					}
					break;
				}
				//��������ʹ�÷�Χ��
				//����ʹ�÷�Χ
				//��ֵ
				goodNames[emptyIndex] = newGoodName;
				goodPrices[emptyIndex] = newGoodPrice;
				goodNums[emptyIndex] = newGoodNum;
				System.out.println("��Ӳ���ִ�гɹ�");
				break;
			case 4:
				//��ȡ��Ҫɾ������Ʒ
				int deleteIndex;
				while(true){
					System.out.println("��������Ҫɾ������Ʒ����");
					String deleteGoodName = sc.next();//�û������
					deleteIndex = -1;//ʵ��ʹ�õ�
					
					for (int i = 0; i < goodNames.length; i++) {//ҵ���߼��ж�
						if(deleteGoodName.equals(goodNames[i])){
							deleteIndex = i;
							break;
						}
					}
					if(deleteIndex == -1){
						System.out.println("������Ʒ��δ�ҵ���Ӧ��Ʒ�����������룡");
						continue;
					}
					break;
				}
				if(deleteIndex == goodNames.length - 1){//�ж��Ƿ�Ϊ���һλ
					goodNames[deleteIndex] = null;
					goodNums[deleteIndex] = 0;
					goodPrices[deleteIndex] = 0.0;
				}
				for (int i = deleteIndex;i < goodNums.length - 1;i++) {
					if(goodNames[i+1] == null){
						goodNames[i] = null;
						goodNums[i] = 0;
						goodPrices[i] = 0.0;
						break;
					}else{
						goodNames[i] = goodNames[i+1];
						goodPrices[i] = goodPrices[i+1];
						goodNums[i] = goodNums[i+1];
					}
				}
				System.out.println("ɾ������ִ�гɹ�");
				break;
			case 5:
				System.out.println("��лʹ�ñ�ϵͳ���ڴ������´�����");
				return;
			}
		}
		
		
		
		//��Ʒ����ţ���Ʒ�����۸񣬿�棩
		//insert   delete
		//update    select num*
		//select * 
	}
}
