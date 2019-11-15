package com.wbj.util;

import java.util.List;

public class Pager<T> {
	private Integer pageNum;//��ǰҳ��
	private List<T> data;//ÿҳ��ʾ������
	private Integer totalPage;//��ҳ��   ÿҳ��ʾ������
	
	public void setTotalPage(Integer totalCount,Integer pageSize){
		totalPage = totalCount/pageSize;
		if(totalCount%pageSize!=0){
			totalPage++;
		}
	}
	public Integer getLastPageNum(){
		return pageNum == 1? 1 : pageNum - 1;
	}
	public Integer getNextPageNum(){
		return pageNum == totalPage? totalPage : pageNum + 1;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
}
