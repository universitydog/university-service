package com.dao.impl;

import java.util.List;
import java.util.Map;

import com.dao.ArticleDao;
import com.dao.MySqlDataFactory;
import com.orm.Article;

@SuppressWarnings("unchecked")
public class ArticleDaoImpl extends MySqlDataFactory implements ArticleDao {

	public ArticleDaoImpl(Class<?> name) {
		super(name);
	}

	public boolean addArticle(Article art) {
		return save(art);
	}

	public boolean deleteArticle(Integer id) {
		Article art = findById(id);
		if (art == null) {
			return false;
		} else {
			return delete(art);
		}
	}

	public boolean updateArticle(Article art) {
		return update(art);
	}

	public Article findById(Integer id) {
		return (Article) super.findById(id);
	}

	public Article findByMany(Map<String, Object> request) {
		return (Article) find(request);
	}

	public List<Article> findByList(Map<String, Object> request, Map<String, Object> sort, Map<String, Integer> pageing) {
		return (List<Article>) findToListLimit(request, sort, pageing);
	}

}
