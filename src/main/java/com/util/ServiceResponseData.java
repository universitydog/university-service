package com.util;

/**
 * 返回数据 
 * @author TTM
 * @date 2016年10月23日 下午10:36:04
 * @version 1.0
 * @param <T>
 */
public class ServiceResponseData<T> {

	public T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
