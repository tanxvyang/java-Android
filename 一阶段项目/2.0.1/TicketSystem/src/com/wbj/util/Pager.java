package com.wbj.util;

import java.util.List;

public class Pager<T> {
	private List<T> data;//ÿҳ��ʾ������
	
	private Integer pageSize = 5;//ÿҳ��ʵ������
	private Integer totalPage;//��ҳ��   ÿҳ��ʾ������
	private Integer currentPageNum;//��ǰҳ��
	private Integer prePageNum;//��һҳ
	private Integer nextPageNum;//��һҳ 
	private Integer startIndex;//ÿҳ��ʼ��¼������
	private Integer totalRrecords;//������  
	
	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(Integer currentPageNum) {
		this.currentPageNum = currentPageNum;
	}
/**
 * ��һҳ = ��ǰҳ -1
 * �����ǰΪ��һҳ��ҳ�벻��   ��һҳ = 1
 * @return
 */
	public Integer getPrePageNum() {
		prePageNum = currentPageNum -1;
		if (prePageNum < 1) {
			prePageNum = 1;
		}
		return prePageNum;
	}

	public void setPrePageNum(Integer prePageNum) {
		this.prePageNum = prePageNum;
	}
/**
   ��һҳ = ��ǰҳ currentPage + 1
 * �����ǰΪ���һҳʱ��   ��һҳ = ��һҳ ��ʹ�ù��� 
 * @return
 */
	public Integer getNextPageNum() {
		nextPageNum = currentPageNum +1;
		if (nextPageNum >totalPage) {
			nextPageNum = 1;
		}
		return nextPageNum;
	}

	public void setNextPageNum(Integer nextPageNum) {
		this.nextPageNum = nextPageNum;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getTotalRrecords() {
		return totalRrecords;
	}

	public void setTotalRrecords(Integer totalRrecords) {
		this.totalRrecords = totalRrecords;
	}

	public Pager(Integer currentPageNum, Integer totalRrecords) {
		
		this.currentPageNum = currentPageNum;
		this.totalRrecords = totalRrecords;
		totalPage = totalRrecords % pageSize == 0 ? totalRrecords/pageSize : totalRrecords/pageSize+1;
		startIndex  = (currentPageNum-1)*pageSize;
	}

	
}
