package com.nanjinwangbo.www.day06;

import java.util.Scanner;

public class SuperMarket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�75�1�7�1�7�1�7�1�7�0�3�1�7�1�7�1�7�1�7�0�4�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�0�3�1�7�1�7�1�7�1�7�1�7�1�8�5�5�1�7��
        //2�1�7�1�7�1�7�1�7�1�7�1�7�1�7�0�9�1�7�1�7�1�7�1�7�0�4�1�1�1�7�1�7�1�7�1�7�1�7�0�8�1�7�1�7�1�7�0�3�1�7�1�7�0�1�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�0�3�1�7�1�7
        //3�1�7�1�7�1�7�1�7�1�7�0�5�1�7�1�7�1�7�1�7�1�7�0�3�1�7�1�7�1�7�1�7�1�7�1�0�1�8�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�6�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�0�7�1�7�1�7�1�7�1�7�1�7���1�7�1�7�΄1�7�1�7�0�2�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7
        //4�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�0�3�1�7�1�7�0�5�0�5�1�7�1�7�1�7�1�7�1�7�1�7�0�3�1�7�1�7�0�4�1�7�1�7
        //5�1�7�1�7�1�7�0�3�1�7�0�3�0�1�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7
        System.out.println("�1�7�1�7�0�5�1�7�1�7�1�7�1�3�1�7�1�7�1�7�1�7�1�7");
        String[] goodNames = new String[10];//�1�7�1�7�0�3�1�7�1�7�1�7�1�7
        goodNames[0] = "�1�7�1�7�1�7";
        goodNames[1] = "�1�7�1�7�0�9�0�8";
        goodNames[2] = "�1�7�ل1�7";
        double[] goodPrices = new double[10];//�1�7�1�7�0�3�1�7�1�8�1�7
        goodPrices[0] = 4.5;
        goodPrices[1] = 2;
        goodPrices[2] = 12;
        int[] goodNums = new int[10];//�1�7�1�7�0�3�1�7�1�7�1�7�1�7
        goodNums[0] = 200;
        goodNums[1] = 1000;
        goodNums[2] = 1;
        while (true) {
            System.out.println(" �1�7�1�7�1�7�1�7�1�7�1�7�0�8�1�7�6�9 ");
            System.out.println(" 1�1�7�1�7�1�7�5�1�1�7�1�7�1�7�1�7�1�7�1�7�0�3");
            System.out.println(" 2�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�0�3");
            System.out.println(" 3�1�7�1�7�1�7�1�7�1�7�1�7�1�7�0�3");
            System.out.println(" 4�1�7�1�7�0�1�1�7�1�7�1�7�1�7�0�3");
            System.out.println(" 5�1�7�1�7�1�7�0�3�1�7�0�3�0�1");
            int code = sc.nextInt();
            switch (code) {
                case 1:
                    for (int i = 0; i < goodNames.length; i++) {
                        if (goodNames[i] == null) {
                            continue;
                        }
                        System.out.println("�1�7�1�7�0�3�1�7�1�7�1�7�1�7" + goodNames[i] +
                                ",�1�7�1�8�1�7�0�2�1�7�1�7" + goodPrices[i] + ",�1�7�1�7��" + goodNums[i]);
                    }
                    break;
                case 2:
                    //�1�7�1�7�1�7�1�7�1�7�1�7�0�3
                    System.err.println("�0�8�1�7�1�7�1�7�0�4�1�7�1�7�1�7�0�3�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�0�8�1�7�1�7�1�7�1�7�1�7�1�7�1�7�0�3�1�7�1�7�1�7�1�7");
                    String goodNameTypeIn = sc.next();
                    System.out.println("�0�8�1�7�1�7�1�7�1�7�1�4�1�7�1�7�1�7");
                    int nums = sc.nextInt();
                    boolean isGet = false;
                    for (int i = 0; i < goodNums.length; i++) {
                        if (goodNames[i] != null && goodNames[i].equals(goodNameTypeIn)) {
                            isGet = true;
                            if (goodNums[i] >= nums) {
                                goodNums[i] -= nums;
                                System.out.println("�1�7�1�7�1�7�1�7�0�8�0�1�1�7�1�7�1�7�1�7" + goodPrices[i] * nums);
                            } else {
                                System.out.println("�1�7�1�7�΄1�7�1�7");
                            }
                            break;
                        }
                    }
                    if (!isGet) {
                        System.out.println("�Ą1�7�1�7�0�9�1�7�1�7�1�7�1�7�0�2�1�7�1�7" + goodNameTypeIn + "�1�7�1�7�1�7�1�7�0�3�1�7�1�7�0�4");
                    }
                    break;
                case 3:
                    int emptyIndex = -1;
                    for (int i = 0; i < goodNums.length; i++) {
                        if (goodNames[i] == null) {
                            emptyIndex = i;
                            break;
                        }
                    }
                    if (emptyIndex == -1) {
                        System.out.println("�1�7�0�0�1�9�0�8�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�9�1�7�1�7�1�7�1�7�1�7�1�7�0�3");
                    }
                    //�1�7�1�7�1�7�1�7
                    String newGoodName;
                    double newGoodPrice;
                    int newGoodNum;
                    //�0�0�0�5�1�7�1�7���1�7�
                    while (true) {
                        System.out.println("�1�7�1�7�1�7�1�7�1�7�1�7�0�8�1�7�1�7�0�3�1�7�1�7�1�7�0�3�1�7�1�7�1�7�0�3�1�7");
                        newGoodName = sc.next();
                        if (newGoodName == null || newGoodName.equals("")) {//�1�7�1�7�1�7�1�7���1�7�1�7
                            System.out.println("�1�7�1�7�0�3�1�7�1�7�1�7�1�7�1�7�1�7�0�2�1�7�0�3�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7");
                            continue;
                        }
                        boolean hasSameName = false;
                        for (int i = 0; i < goodNames.length; i++) {//�0�9�1�7�1�7�1�7�1�8�1�7�1�7�؄1�7
                            if (newGoodName.equals(goodNames[i])) {
                                System.out.println("�1�7�1�7�0�3�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�6�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7");
                                hasSameName = true;
                                break;
                            }
                        }
                        if (hasSameName) {
                            continue;
                        }
                        break;
                    }
                    while (true) {
                        System.out.println("�1�7�1�7�1�7�1�7�1�7�1�7�0�8�1�7�1�7�0�3�1�7�1�7�1�7�0�3�1�7�1�8�1�7");
                        newGoodPrice = sc.nextDouble();
                        if (newGoodPrice < 0) {
                            System.out.println("�1�7�1�7�0�3�1�7�1�8�1�7�1�7�1�7�0�2�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7");
                            continue;
                        }
                        break;
                    }
                    while (true) {
                        System.out.println("�1�7�1�7�1�7�1�7�1�7�1�7�0�8�1�7�1�7�0�3�1�7�1�7�1�7�0�3�1�7�1�7�1�7�1�7�1�7�1�7");
                        newGoodNum = sc.nextInt();
                        if (newGoodNum < 0) {
                            System.out.println("�1�7�1�7�0�3�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�0�2�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7");
                            continue;
                        }
                        break;
                    }
                    //�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�0�0�1�7�1�7���1�7�1�7
                    //�1�7�1�7�1�7�1�7�0�0�1�7�1�7��
                    //�1�7�1�7�0�5
                    goodNames[emptyIndex] = newGoodName;
                    goodPrices[emptyIndex] = newGoodPrice;
                    goodNums[emptyIndex] = newGoodNum;
                    System.out.println("�1�7�1�7�0�0�1�7�1�7�1�7�0�4�1�7�ԁ0�6�1�7");
                    break;
                case 4:
                    //�1�7�1�7�0�0�1�7�1�7�0�8�0�1�1�7�1�7�1�7�1�7�1�7�1�7�0�3
                    int deleteIndex;
                    while (true) {
                        System.out.println("�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�0�8�0�1�1�7�1�7�1�7�1�7�1�7�1�7�0�3�1�7�1�7�1�7�1�7");
                        String deleteGoodName = sc.next();//�1�7�0�4�1�7�1�7�1�7�1�7�1�7�1�7
                        deleteIndex = -1;//�0�6�1�7�1�7�0�0�1�7�0�1�1�7

                        for (int i = 0; i < goodNames.length; i++) {//�0�9�1�7�1�7�1�7�1�8�1�7�1�7�؄1�7
                            if (deleteGoodName.equals(goodNames[i])) {
                                deleteIndex = i;
                                break;
                            }
                        }
                        if (deleteIndex == -1) {
                            System.out.println("�1�7�1�7�1�7�1�7�1�7�1�7�0�3�1�7�1�7�Ą1�7�0�9�1�7�1�7�1�7�0�8�1�7�1�7�0�3�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�0�2");
                            continue;
                        }
                        break;
                    }
                    if (deleteIndex == goodNames.length - 1) {//�1�7�؄1�7�1�7�0�9�1�7�0�2�1�7�1�7�1�7�0�5��
                        goodNames[deleteIndex] = null;
                        goodNums[deleteIndex] = 0;
                        goodPrices[deleteIndex] = 0.0;
                    }
                    for (int i = deleteIndex; i < goodNums.length - 1; i++) {
                        if (goodNames[i + 1] == null) {
                            goodNames[i] = null;
                            goodNums[i] = 0;
                            goodPrices[i] = 0.0;
                            break;
                        } else {
                            goodNames[i] = goodNames[i + 1];
                            goodPrices[i] = goodPrices[i + 1];
                            goodNums[i] = goodNums[i + 1];
                        }
                    }
                    System.out.println("�0�1�1�7�1�7�1�7�1�7�1�7�1�7�0�4�1�7�ԁ0�6�1�7");
                    break;
                case 5:
                    System.out.println("�1�7�1�7�݁0�0�1�7�0�9�1�7�0�3�0�1�1�7�1�7�1�7�1�0�1�7�1�7�1�7�1�7�1�7�1�7�0�7�1�7�1�7�1�7�1�7�1�7");
                    return;
            }
        }


        //�1�7�1�7�0�3�1�7�1�7�1�7�1�7�0�0�1�7�1�7�1�7�0�3�1�7�1�7�1�7�1�7�1�7�1�8�2�7�1�7��
        //insert   delete
        //update    select num*
        //select *
    }
}
