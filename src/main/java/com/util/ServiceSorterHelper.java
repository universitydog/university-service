package com.util;

import java.util.LinkedHashMap;
import java.util.Map;

import org.hibernate.criterion.Order;

public class ServiceSorterHelper {

	public static final String ASC = "asc";
	public static final String DESC = "desc";

	public static Map<String, Object> build(String key, String value) {
		Map<String, Object> _innerSortion = new LinkedHashMap<String, Object>();
		String direction = ServiceSorterHelper.ASC;
		if (value.equals("desc"))
			direction = ServiceSorterHelper.DESC;
		_innerSortion.put(key, direction);
		return _innerSortion;
	}
	
	/**
	 * 升序
	 * @param key
	 * @return
	 */
	public static Order asc(String key) {
		return Order.asc(key);
	}
	
	/**
	 * 降序
	 * @param key
	 * @return
	 */
	public static Order desc(String key) {
		return Order.desc(key);
	}

}
