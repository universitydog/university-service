package com.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import com.orm.Author;

/**
 * 
 * <p>
 * 介绍 作者数据层
 * </p>
 * 
 * @author TTM
 * @date 2016年10月26日 上午12:24:20
 * @version 1.0
 */
public interface AuthorDao {

	public abstract List<Author> findAuthorByQuery(Criterion criterion, Order sort, int page, int size);
	
	public abstract int findAuthorCount();
	
}
