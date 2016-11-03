package com.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.dao.AuthorDao;
import com.dao.MySqlDataFactory;
import com.orm.Author;

/**
 * 
 * <p>
 * 介绍
 * </p>
 * 
 * @author TTM
 * @date 2016年10月26日 上午12:26:58
 * @version 1.0
 */
@SuppressWarnings("unchecked")
@Repository
public class AuthorDaoImpl implements AuthorDao {

	private MySqlDataFactory<Author> mySqlFactory;
	
	public void execute() {
		mySqlFactory = MySqlDataFactory.getFactory();
		mySqlFactory.setName(Author.class);
	}
	
	public List<Author> findAuthorByQuery(Criterion criterion, Order sort, int page, int size) {
		execute();
		return mySqlFactory.findByQuery(criterion, sort, page, size);
	}

	public int findAuthorCount() {
		execute();
		String partCount = mySqlFactory.findCount();
		return StringUtils.isEmpty(partCount) ? 0 : Integer.valueOf(partCount);
	}

}
