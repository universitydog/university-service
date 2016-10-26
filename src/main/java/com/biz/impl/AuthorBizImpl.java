package com.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.AuthorBiz;
import com.biz.BaseFormatBiz;
import com.dao.AuthorDao;
import com.orm.ArticleSimple;
import com.orm.Author;
import com.orm.AuthorSimple;
import com.util.ServiceResponseCode;
import com.util.ServiceResponseMsg;
import com.util.ServiceResponseUtils;

/**
 * 
 * <p>
 * 介绍
 * </p>
 * 
 * @author TTM
 * @date 2016年10月26日 上午7:35:42
 * @version 1.0
 */
@Service
public class AuthorBizImpl implements AuthorBiz {

	@Autowired
	private AuthorDao authorDaoImpl;
	
	public ServiceResponseUtils<List<AuthorSimple>> findAuthorByList(int page, int size, String sortName) {
		List<Author> partAuthors = authorDaoImpl.findAuthorByQuery(null, Order.desc(sortName), page, size);
		int totalCount = authorDaoImpl.findAuthorCount();
		int totalPage = countTotal(size, totalCount);

		ServiceResponseUtils<List<AuthorSimple>> partResponse = null;
		List<AuthorSimple> partAuthorSimpl = new ArrayList<AuthorSimple>();
		partAuthorSimpl = constructArticleSimple(partAuthors);
		if (CollectionUtils.isNotEmpty(partAuthors)) {
			partResponse = constructServiceResponse(ServiceResponseCode.SUCCESS, partAuthorSimpl, page, size,
					totalPage);
		} else {
			partResponse = constructServiceResponse(ServiceResponseCode.WARN, partAuthorSimpl, page, size, totalPage);
		}
		return partResponse;
	}

	/**
	 * 计算总页数
	 * 
	 * @param size
	 *            每页显示数量
	 * @param totalCount
	 *            总数量
	 * @return 总页数
	 */
	private int countTotal(int size, int totalCount) {
		if (totalCount < size) {
			return 1;
		}
		int tempCount = totalCount / size;
		return totalCount % size == 0 ? tempCount : tempCount + 1;
	}

	public List<AuthorSimple> constructArticleSimple(List<Author> articles) {
		List<AuthorSimple> partAuthorSimple = new ArrayList<AuthorSimple>();
		for (Author partAuthorRow : articles) {
			AuthorSimple partAuthorSimpleRow = new AuthorSimple();
			partAuthorSimpleRow.setId(partAuthorRow.getId());
			partAuthorSimpleRow.setRealName(partAuthorRow.getRealName());
			partAuthorSimpleRow.setNickName(partAuthorRow.getNickName());
			partAuthorSimpleRow.setIntroduce(partAuthorRow.getIntroduce());
			partAuthorSimpleRow.setRank(partAuthorRow.getRank());
			partAuthorSimpleRow.setLove(partAuthorRow.getLove());
			partAuthorSimpleRow.setCreateTime(partAuthorRow.getCreateTime());
			partAuthorSimpleRow.setImgurl(partAuthorRow.getImgurl());
			partAuthorSimple.add(partAuthorSimpleRow);
		}
		return partAuthorSimple;
	}

	public ServiceResponseUtils<List<AuthorSimple>> constructServiceResponse(int code, List<AuthorSimple> authorSimples,
			int page, int size, int totalPage) {
		ServiceResponseUtils<List<AuthorSimple>> partAuthorSimpeResponse = new ServiceResponseUtils<List<AuthorSimple>>();
		partAuthorSimpeResponse.setCode(code);
		if (code == ServiceResponseCode.SUCCESS) {
			partAuthorSimpeResponse.setData(authorSimples);
			partAuthorSimpeResponse.setPage(page);
			partAuthorSimpeResponse.setSize(size);
			partAuthorSimpeResponse.setTotal(totalPage);
		} else {
			partAuthorSimpeResponse.setMsg(ServiceResponseMsg.WARN + " | 暂无数据");
		}
		return partAuthorSimpeResponse;
	}

}
