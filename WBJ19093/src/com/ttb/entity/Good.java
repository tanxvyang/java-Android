package com.ttb.entity;

public class Good {
	private Integer gid;
	private String goodName;
	private Double goodPrice;
	private String goodIntro;
	private Integer nums;
	
	public Good() {
		
	}

	public Good(Integer gid, String goodName, Double goodPrice,
			String goodIntro, Integer nums) {
		this.gid = gid;
		this.goodName = goodName;
		this.goodPrice = goodPrice;
		this.goodIntro = goodIntro;
		this.nums = nums;
	}

	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public Double getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(Double goodPrice) {
		this.goodPrice = goodPrice;
	}
	public String getGoodIntro() {
		return goodIntro;
	}
	public void setGoodIntro(String goodIntro) {
		this.goodIntro = goodIntro;
	}
	public Integer getNums() {
		return nums;
	}
	public void setNums(Integer nums) {
		this.nums = nums;
	}
	
}
