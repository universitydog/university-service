package com.dao.impl;

import java.util.List;
import java.util.Map;

import com.dao.ArticleDao;
import com.dao.MySqlDataFactory;
import com.orm.Article;

@SuppressWarnings("unchecked")
public class ArticleDaoImpl implements ArticleDao {

	private MySqlDataFactory mysqlFactory = new MySqlDataFactory(Article.class);
	
	public boolean addArticle(Article art) {
		return mysqlFactory.save(art);
	}

	public boolean deleteArticle(Integer id) {
		Article art = findById(id);
		if (art == null) {
			return false;
		} else {
			return mysqlFactory.delete(art);
		}
	}

	public boolean updateArticle(Article art) {
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		return mysqlFactory.update(art);
	}

	public Article findById(Integer id) {
		return (Article) mysqlFactory.findById(id);
	}

	public Article findByMany(Map<String, Object> request) {
		return (Article) mysqlFactory.find(request);
	}

	public List<Article> findByList(Map<String, Object> request, Map<String, Object> sort, Map<String, Integer> pageing) {
		return (List<Article>) mysqlFactory.findToListLimit(request, sort, pageing);
	}

}
