package com.wbj.trans;

public interface Transaction {
	/**
	 * ��������
	 */
	public void begin();
	/**
	 * �ύ����
	 */
	public void commit();
	/**
	 * �ع�����
	 */
	public void rollback();
	
}
