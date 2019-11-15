package com.wbj.entity;

public class Recharge {
	private Integer rechargeId ;//订单编号
	 private Integer userId ;	//用户id
	 private String username ;	//用户名
	 private Double applyMoney ;//申请金额
	 private String applyTime;  //时间
	 private String applyState;         //申请状态  1：未处理，2：通过，3：驳回
	
	 

	public Recharge() {
		super();
	}
	public Recharge(Integer rechargeId, Integer userId, String username,
			Double applyMoney, String applyTime, String applyState) {
		super();
		this.rechargeId = rechargeId;
		this.userId = userId;
		this.username = username;
		this.applyMoney = applyMoney;
		this.applyTime = applyTime;
		this.applyState = applyState;
	}
	@Override
	public String toString() {
		return "Recharge [applyMoney=" + applyMoney + ", applyState="
				+ applyState + ", applyTime=" + applyTime + ", rechargeId="
				+ rechargeId + ", userId=" + userId + ", username=" + username
				+ "]";
	}
	public Integer getRechargeId() {
		return rechargeId;
	}
	public void setRechargeId(Integer rechargeId) {
		this.rechargeId = rechargeId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Double getApplyMoney() {
		return applyMoney;
	}
	public void setApplyMoney(Double applyMoney) {
		this.applyMoney = applyMoney;
	}
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	public String getApplyState() {
		//1 未处理，2 已通过，3 已退票
		if (applyState.equals("1")) {
			return "未处理" ;
		}
		if (applyState.equals("2")) {
			return "已通过" ;
		}


		if (applyState.equals("未处理")) {
			return "1" ;
		}
		if (applyState.equals("已通过")) {
			return "2" ;
		}


		return applyState;
	}
	public void setApplyState(String applyState) {
		this.applyState = applyState;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}

}
