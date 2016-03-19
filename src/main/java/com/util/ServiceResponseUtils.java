package com.util;

import com.ttm.service.ServiceResponse;

public class ServiceResponseUtils extends ServiceResponse {

	/**
	 * 总共页数
	 */
	private Integer total;
	
	/**
	 * 当前页 
	 */
	private Integer page;
	
	/**
	 * 每页显示数量
	 */
	private Integer size;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
	
}
