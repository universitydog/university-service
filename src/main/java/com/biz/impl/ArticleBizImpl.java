package com.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.ArticleBiz;
import com.dao.ArticleDao;
import com.orm.Article;
import com.orm.ArticleSimple;
import com.orm.Type;
import com.util.ServiceResponseCode;
import com.util.ServiceResponseMsg;
import com.util.ServiceResponseUtils;

/***
 * 
 * <p>
 * 介绍 业务逻辑层实现类
 * </p>
 * 
 * @author 唐太明
 * @date 2016年3月10日 下午11:28:43
 * @version 1.0
 */
@Service
public class ArticleBizImpl implements ArticleBiz {

	@Autowired
	private ArticleDao articleDaoImpl;

	public ServiceResponseUtils<List<ArticleSimple>> findArticleByList(int page, int size, String sortName) {
		List<Article> partArticles = articleDaoImpl.findArticleByQuery(null, Order.desc("inputDate"), page, size);
		int totalCount = articleDaoImpl.findArticleCount();
		int totalPage = countTotal(size, totalCount);
		System.out.println("ttm | articles : " + partArticles.size());
		List<ArticleSimple> articleSimples = constructArticleSimple(partArticles);
		ServiceResponseUtils<List<ArticleSimple>> response = null;
		if (CollectionUtils.isNotEmpty(articleSimples)) {
			response = 
					constructServiceResponse(ServiceResponseCode.SUCCESS, articleSimples, page, size, totalPage);
		} else {
			response = 
					constructServiceResponse(ServiceResponseCode.WARN, articleSimples, page, size, totalPage);
		}
		
		return response;
	}

	/**
	 * 构建查询数据
	 * @param articles
	 * @return
	 */
	public List<ArticleSimple> constructArticleSimple(List<Article> articles) {
		List<ArticleSimple> partArticleSimples = new ArrayList<ArticleSimple>();
		for (Article articleRow : articles) {
			ArticleSimple partArticleSimpleRow = new ArticleSimple();
			partArticleSimpleRow.setId(articleRow.getId());
			partArticleSimpleRow.setTags(articleRow.getTags());
			partArticleSimpleRow.setTitle(articleRow.getTitle());
			partArticleSimpleRow.setTitleDate(articleRow.getTitleDate());
			partArticleSimpleRow.setInputDate(articleRow.getInputDate());
			partArticleSimpleRow.setUrl(articleRow.getUrl());
			partArticleSimpleRow.setDigest(articleRow.getDigest());
			partArticleSimpleRow.setAuthorId(articleRow.getAuthorId());

			// Type
			Type partType = articleRow.getTypeId();
			partArticleSimpleRow.setTypeId(partType.getId());
			partArticleSimpleRow.setName(partType.getName());
			partArticleSimpleRow.setImgUrl(partType.getImgUrl());
			partArticleSimples.add(partArticleSimpleRow);
		}
		return partArticleSimples;
	}

	/**
	 * 构建返回值
	 * @param code
	 * @param articleSimples
	 * @return
	 */
	public ServiceResponseUtils<List<ArticleSimple>> constructServiceResponse(int code,
			List<ArticleSimple> articleSimples, int page, int size, int totalPage) {
		ServiceResponseUtils<List<ArticleSimple>> partResponse = new ServiceResponseUtils<List<ArticleSimple>>();
		partResponse.setCode(code);
		if (code == ServiceResponseCode.SUCCESS) {
			partResponse.setData(articleSimples);
			partResponse.setPage(page);
			partResponse.setSize(size);
			partResponse.setTotal(totalPage);
		} else {
			partResponse.setMsg(ServiceResponseMsg.WARN + " | 查询数据为空");
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

	public ServiceResponseUtils<List<ArticleSimple>> findArticleByList(String authorId, int page, int size,
			String sortName) {
		Criterion partCri = Restrictions.eq("authorId", authorId);
		List<Article> partArticles = articleDaoImpl.findArticleByQuery(partCri, Order.desc("inputDate"), page, size);
		int totalCount = articleDaoImpl.findArticleCount(partCri);
		int totalPage = countTotal(size, totalCount);
		
		List<ArticleSimple> partArticleSimple = constructArticleSimple(partArticles);
		ServiceResponseUtils<List<ArticleSimple>> partResponse = new ServiceResponseUtils<List<ArticleSimple>>();
		if (CollectionUtils.isNotEmpty(partArticles)) {
			partResponse = constructServiceResponse(ServiceResponseCode.SUCCESS, partArticleSimple, page, size, totalPage);
		} else {
			partResponse = constructServiceResponse(ServiceResponseCode.WARN, partArticleSimple, page, size, totalPage);
		}
		return partResponse;
	}

}
