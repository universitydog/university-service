package com.dao;

import java.util.List;
import java.util.Map;

import com.orm.Article;

public interface ArticleDao {

	public abstract boolean addArticle(Article art);

	public abstract boolean deleteArticle(Integer id);

	public abstract boolean updateArticle(Article art);

	public abstract Article findById(Integer id);

	public abstract Article findByMany(Map<String, Object> request);

	public abstract List<Article> findByList(Map<String, Object> request, Map<String, Object> sort,
			Map<String, Integer> pageing);
	
}
