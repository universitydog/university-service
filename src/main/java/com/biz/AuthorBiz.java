package com.biz;

import java.util.List;

import com.orm.AuthorSimple;
import com.util.ServiceResponseUtils;

/**
 * 
 * <p>
 * 介绍
 * </p>
 * 
 * @author TTM
 * @date 2016年10月26日 上午7:29:05
 * @version 1.0
 */
public interface AuthorBiz {

	/**
	 * 作者列表查询
	 * 
	 * @param page
	 * @param size
	 * @param sortName
	 * @return
	 */
	public abstract ServiceResponseUtils<List<AuthorSimple>> findAuthorByList(int page, int size, String sortName);

}
