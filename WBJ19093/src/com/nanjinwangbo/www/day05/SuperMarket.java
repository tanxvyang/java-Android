package com.nanjinwangbo.www.day05;

import com.sun.javafx.robot.FXRobotImage;

import java.util.Scanner;

public class SuperMarket {
    public static void main(String[] args) {
//1、保存至少5个商品的信息，包括（商品名、价格、库存）
        //2、可以上货和下架（添加新的商品，删除已有商品）
        //3、可以出售商品（根据价格购买数量计算总价，购买完成后减少库存，库存不足时不能售卖）
        //4、可以浏览商品（展示所有商品信息）
        Scanner sc = new Scanner(System.in);
        //int input = sc.nextInt();
        String[] goodNames = new String[10];
        goodNames[0] = "面包";
        goodNames[1] = "矿泉水";
        double[] goodPrices = new double[10];
        goodPrices[0] = 4;
        goodPrices[1] = 2;
        int[] goodNums = new int[10];
        goodNums[0] = 200;
        goodNums[1] = 1000;
        // for (String i:goodNames
        // 	 ) {
        // 	System.out.println(i);
        // }
        while (true) {
            System.out.println("请输入指令：");
            System.out.println("1：查看所有商品");
            System.out.println("2：购买商品");
            System.out.println("3：上架商品");
            System.out.println("4：下架商品");

            int code = sc.nextInt();
            switch (code) {
                case 1:
                    //显示所有商品
                    for (String i : goodNames
                    ) {
                        System.out.println(i);
                    }
                    for (int i = 0; i < goodNums.length; i++) {
                        if (goodNames[i] == null) {
                            continue;
                        }
                        System.out.println("商品名： " + goodNames[i] +
                                "  价格：  " + goodPrices[i] + "  库存：" + goodNums[i]);
                    }

                    break;
                case 2:
                    //购买商品
                    System.out.println("要买那件商品？");
                    String goodNameTypeIn = sc.next();
                    System.out.println("要多少件商品？");
                    int nums = sc.nextInt();
                    boolean isGet = false;
                    for (int i = 0; i < goodNums.length; i++) {
                        if (goodNames[i] != null && goodNames[i].equals(goodNameTypeIn)) {
                            isGet = true;
                            if (goodNums[i] >= nums) {
                                goodNums[i] -= nums;
                                System.out.println("需要支付：" + goodPrices[i] * nums);
                                //goodNums[i]-=nums;
                            } else {
                                System.out.println("库存不足！");
                            }
                            break;
                        }
                    }
                    if (!isGet) {
                        System.out.println("未查询到名为:" + goodNameTypeIn + "的商品");
                    }

                    break;
                case 3:
                    //上架商品
                    System.out.println("请输入要上架的商品名");
                    String goodNameTypeUp = sc.next();
                    System.out.println("请输入要上架的商品价格");
                    double goodPriceTypeUp = sc.nextDouble();
                    System.out.println("请输入要上架的商品数量");
                    int goodNumTypeUp = sc.nextInt();
                    for (int i = 0; i < goodNames.length; i++) {

                        if (goodNames[i] != null) {
                            if (goodNames[i].equals(goodNameTypeUp)) {
                                System.out.println("上架失败!商品已存在,是否更新库存和库存");//可以加 更新价格和数量功能
                                System.out.println("选择all,价格,库存或任意键放弃");//
                                String instructions = sc.next();
                                switch (instructions) {
                                    case "all":
                                        goodNums[i] = goodNumTypeUp;
                                        goodPrices[i] = goodPriceTypeUp;
                                    case "价格":
                                        goodPrices[i] = goodPriceTypeUp;
                                    case "库存":
                                        goodNums[i] = goodNumTypeUp;

                                        System.out.println("已更新");
                                        break;
                                    default:
                                        System.out.println("放弃更新");
                                        break;

                                }



					/*
						if ("all".equals(instructions)){
							goodNums[i] = goodNumTypeUp;
							goodPrices[i] = goodPriceTypeUp;
							System.out.println("已更新");
						}else if("库存".equals(instructions)){
							goodNums[i] = goodNumTypeUp;
						}else  if ("价格".equals(instructions)){
							goodPrices[i] = goodPriceTypeUp;
						}else{
							System.out.println("放弃更新!");
						}
*/
                                break;
                            }
                            //continue;
                        } else {
                            goodNames[i] = goodNameTypeUp;
                            goodNums[i] += goodNumTypeUp;
                            goodPrices[i] += goodPriceTypeUp;
                            System.out.println(goodNames[i]);
                            System.out.println("商品" + goodNameTypeUp + "上架成功");
                            break;
                        }
                    }

                    break;
                case 4:
                    //下架商品
                    System.out.println("要下架那件商品？");
                    String goodNameTypeDown = sc.next();
                    //boolean isDown = false;
                    for (int i = 0; i < goodNums.length; i++) {

                        // if (goodNames[i]!=null) {
                        //isDown = true;
                        if (goodNames[i].equals(goodNameTypeDown)) {

                            for (int j = i; j < goodNums.length - 1; j++) {

                                if (goodNames[j + 2] == null && goodNames[j + 1] == null) {

                                    goodNames[j] = null;
                                    goodPrices[j] = 0;
                                    goodNums[j] = 0;
                                    //System.out.println("下架成功");
                                    break;
                                } else {

                                    goodNames[j] = goodNames[j + 1];
                                    //goodNames[i+1]=null;
                                    goodPrices[j] = goodPrices[j + 1];
                                    //goodPrices[i+1]=0;
                                    goodNums[j] = goodNums[j + 1];
                                    //goodNums[i+1]=0;
                                    //System.out.println("下架成功");
                                    //continue;
                                }
                            }
                            System.out.println("下架成功!");
                            break;
                        } else {
                            System.out.println("商品不存在!");
                            break;
                        }
                    }
                    //if (!isDown){
                    //	System.out.println("未查询到名为:"+goodNameTypeDown+"的商品");
                    //	}

                    break;

                default:
                    break;
            }
        }


        //察看全部商品
/*	if (1==sc.nextInt()) {
		
	
	for (int i = 0; i < goodNums.length; i++) {
		if (goodNames[i]==null) {
			continue;
		}
		System.out.println("商品名："+goodNames[i]+
				"价格："+goodPrices[i]+"库存："+goodNums[i]);
	}
	}
	*/
        //购买商品
	/*if (2==sc.nextInt()) {
		System.out.println("要买那件商品？");
		String goodNameTypeIn = sc.next();
		System.out.println("要多少件商品？");
		int nums = sc.nextInt();
		
		boolean isGet = false;
		for (int i = 0; i < goodNums.length; i++) {
		
			if (goodNames[i]!=null&&goodNames[i].equals(goodNameTypeIn)) {
				isGet = true;
				if (goodNums[i] >= nums) {
					goodNums[i] -= nums;
					System.out.println("需要支付：" + goodPrices[i]*nums);
				}else {
					System.out.println("库存不足！");
				}
				break;
			}else {
				System.out.println("库存不足");
			}
		}
	}
	*/
	
	
/*	System.out.println("====================欢迎光临===========================");
	System.out.println("===================================================");
	             
	System.out.println("===============================================");
	System.out.println("===============================================");
	*/

    }
}
