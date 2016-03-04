package com.biz;

import java.util.List;
import java.util.Map;

import com.orm.Article;

public interface ArticleBiz {

	public abstract boolean addArticle(Map<String, Object> request);

	public abstract boolean deleteArticle(Map<String, Object> request);

	public abstract boolean updateArticle(Map<String, Object> request);

	public abstract Article findById(Map<String, Object> request);

	public abstract Article findByMany(Map<String, Object> request);

	public abstract List<Article> findByList(Map<String, Object> request);

}
