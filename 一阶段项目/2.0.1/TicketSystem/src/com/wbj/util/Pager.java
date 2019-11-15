package com.wbj.util;

import java.util.List;

public class Pager<T> {
	private List<T> data;//每页显示的数据
	
	private Integer pageSize = 5;//每页现实的条数
	private Integer totalPage;//总页数   每页显示多少条
	private Integer currentPageNum;//当前页码
	private Integer prePageNum;//上一页
	private Integer nextPageNum;//下一页 
	private Integer startIndex;//每页开始记录的索引
	private Integer totalRrecords;//总条数  
	
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
 * 上一页 = 当前页 -1
 * 如果当前为第一页，页码不变   上一页 = 1
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
   下一页 = 当前页 currentPage + 1
 * 如果当前为最后一页时，   下一页 = 第一页 ，使用滚动 
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
