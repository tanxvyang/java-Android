package com.wbj.entity;

public class Recharge {
	private Integer rechargeId ;//�������
	 private Integer userId ;	//�û�id
	 private String username ;	//�û���
	 private Double applyMoney ;//������
	 private String applyTime;  //ʱ��
	 private String applyState;         //����״̬  1��δ����2��ͨ����3������
	
	 

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
		//1 δ����2 ��ͨ����3 ����Ʊ
		if (applyState.equals("1")) {
			return "δ����" ;
		}
		if (applyState.equals("2")) {
			return "��ͨ��" ;
		}


		if (applyState.equals("δ����")) {
			return "1" ;
		}
		if (applyState.equals("��ͨ��")) {
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
