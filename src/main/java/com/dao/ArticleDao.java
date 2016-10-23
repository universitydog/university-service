package com.dao;

import java.util.List;
import java.util.Map;

import com.orm.Article;
import com.orm.ArticleFuZa;

public interface ArticleDao {

	public abstract boolean addArticle(Article art);

	public abstract boolean deleteArticle(Integer id);

	public abstract boolean updateArticle(Article art);

	public abstract Article findById(Integer id);

	public abstract Article findByMany(Map<String, Object> request);

	public abstract List<Article> findByList(Map<String, Object> request, Map<String, Object> sort,
			Map<String, Integer> pageing);
	
	public abstract List<Article> findByListSearch(String authorId, String sea, Integer index, Integer length);

	public abstract Object findByListSearchNumber(String authorId, String sea);
	
	/**
	 * 查询 文章的复杂实体 带关联关系
	 * @param query
	 * @param sort
	 * @param pageing
	 * @return
	 */
	public abstract List<ArticleFuZa> findArticleFuByList(Map<String, Object> query, Map<String, Object> sort, Map<String, Integer> pageing);
	
	/**
	 * 条件查询数量   目前只处理等于的情况
	 * @param query
	 * @return
	 */
	public abstract int findArticleCount();
	
}
