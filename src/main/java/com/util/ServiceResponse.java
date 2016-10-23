package com.util;

/**
 * @author TTM
 * @date 2016年10月23日 下午9:24:40
 * @version 1.0
 * @param <T>
 */
public class ServiceResponse<T> {

	private int code;
	private ServiceResponseData<T> data;
	private String msg;

	/**
	 * 默认获取 成功
	 */
	public ServiceResponse() {
		this.code = ServiceResponseCode.SUCCESS;
		this.msg = ServiceResponseMsg.SUCCESS;
	}

	/**
	 * @param code
	 *            状态码
	 * @param msg
	 *            消息
	 */
	public ServiceResponse(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public ServiceResponseData<T> getData() {
		return data;
	}

	public void setData(ServiceResponseData<T> data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
