package com.nanjinwangbo.www.SuperMarketUseMap;

public class Good {
	private String title;//商品名
	private Double price;//价格
	private String introduct;//商品说明
	public Good(){
		//无参构造
	}
	public Good(String title,Double price){
		this.title = title;
		this.price = price;
	}//有参构造，只传入必须含有的数据
	public Good(String title, Double price, String introduct) {
		this.title = title;
		this.price = price;
		this.introduct = introduct;
	}//全参构造

	/**
	 *  修改系统对于相同商品的定义
	 *  从内存地址是否相同的判断转为商品名称是否相同
	 */
	@Override
	public boolean equals(Object obj) {
//		System.out.println("调用equals方法");
		if(obj instanceof Good){
			//判断商品名称是否一致
			return ((Good)obj).getTitle().equals(this.getTitle());
		} else {
			return false;//如果类型不同，必然不相同
		}
	}
	@Override
	public int hashCode() {
		return this.getTitle().hashCode();
	}
	/**
	 * 简单介绍
	 * @return
	 */
	public String shortToString(){
		return "商品名："+this.getTitle()+
				"，价格为："+this.getPrice();//只输出必要信息
	}

	/**
	 * 重写toString方法做详细介绍
	 */
	@Override
	public String toString() {
		return "商品名："+this.getTitle()+
				"，价格为："+this.getPrice()+
				"，介绍："+
				(
						(getIntroduct() == null || getIntroduct().equals(""))?"暂无介绍":getIntroduct()
				);//输出详细信息
	}

	//==================get/set方法===================
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getIntroduct() {
		return introduct;
	}
	public void setIntroduct(String introduct) {
		this.introduct = introduct;
	}
}
