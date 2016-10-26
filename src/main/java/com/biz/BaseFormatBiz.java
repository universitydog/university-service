package com.biz;

import java.util.List;

import com.orm.Article;
import com.orm.ArticleSimple;
import com.util.ServiceResponseUtils;

/**
 * 
 * <p>
 * 介绍 共有构造数据类
 * </p>
 * 
 * @author TTM
 * @date 2016年10月26日 上午7:50:06
 * @version 1.0
 * @param <T>
 */
public interface BaseFormatBiz<T> {

	/**
	 * 构建数据
	 * @param articles
	 * @return
	 */
	public abstract List<T> constructArticleSimple(List<T> articles);
	
	/**
	 * 封装数据
	 * @param code
	 * @param articleSimples
	 * @param page
	 * @param size
	 * @param totalPage
	 * @return
	 */
	public abstract ServiceResponseUtils<List<T>> constructServiceResponse(int code,
			List<T> articleSimples, int page, int size, int totalPage);
	
}
