package com.util;

import java.util.Map;

public class CollectionUtils {

	public static <K, T> boolean isEmpty(Map<K, T> map) {
		return (map == null || map.isEmpty());
	}
	
	public static <K, T> boolean isNotEmpty(Map<K, T> map) {
		return !CollectionUtils.isEmpty(map);
	}
	
}
