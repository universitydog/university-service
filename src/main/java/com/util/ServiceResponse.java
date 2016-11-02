package com.util;

/**
 * @author TTM
 * @date 2016年10月23日 下午9:24:40
 * @version 1.0
 * @param <T>
 */
public class ServiceResponse<T> {

	private int re;
	private T data;
	private String msg;

	/**
	 * 默认获取 成功
	 */
	public ServiceResponse() {
		this.re = ServiceResponseCode.SUCCESS;
		this.msg = ServiceResponseMsg.SUCCESS;
	}

	/**
	 * @param re
	 *            状态码
	 * @param msg
	 *            消息
	 */
	public ServiceResponse(int re, String msg) {
		this.re = re;
		this.msg = msg;
	}

	public int getRe() {
		return re;
	}

	public void setRe(int re) {
		this.re = re;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
