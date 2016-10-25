package com.util;

/**
 * 
 * <p>
 * 介绍
 * </p>
 * 
 * @author TTM
 * @date 2016年10月25日 上午6:24:41
 * @version 1.0
 * @param <T>
 */
public class ServiceResponseUtils<T> extends ServiceResponse<T> {

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
