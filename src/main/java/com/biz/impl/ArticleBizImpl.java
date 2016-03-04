package com.biz.impl;

import java.util.List;
import java.util.Map;

import com.biz.ArticleBiz;
import com.dao.ArticleDao;
import com.orm.Article;
import com.ttm.util.Json;
import com.util.CollectionUtils;

public class ArticleBizImpl implements ArticleBiz {

	private ArticleDao articleDao;
	
	public boolean addArticle(Map<String, Object> request) {
		boolean isAdd = true;
		if (CollectionUtils.isEmpty(request)) {
			isAdd = false;
		} else {
			String data = (String) request.get("data");
			Article art = (Article) Json.fromJson(data, Article.class);
			isAdd = articleDao.addArticle(art);
		}
		
		return isAdd;
	}

	public boolean deleteArticle(Map<String, Object> request) {
		boolean isDelete = true;
		if (CollectionUtils.isEmpty(request)) {
			isDelete = false;
		} else {
			String data = (String) request.get("data");
			Article art = (Article) Json.fromJson(data, Article.class);
			isDelete = articleDao.addArticle(art);
		}
		return false;
	}

	public boolean updateArticle(Map<String, Object> request) {
		// TODO Auto-generated method stub
		return false;
	}

	public Article findById(Map<String, Object> request) {
		// TODO Auto-generated method stub
		return null;
	}

	public Article findByMany(Map<String, Object> request) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Article> findByList(Map<String, Object> request) {
		// TODO Auto-generated method stub
		return null;
	}

	//*****************************************************************************************
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

}
