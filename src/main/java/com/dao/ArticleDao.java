package com.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import com.orm.Article;
import com.orm.Article;

public interface ArticleDao {

	public abstract Article findById(Integer id);

	public abstract List<Article> findByList(Map<String, Object> request, Map<String, Object> sort,
			Map<String, Integer> pageing);
	
	public abstract List<Article> findByListSearch(String authorId, String sea, Integer index, Integer length);

	public abstract Object findByListSearchNumber(String authorId, String sea);
	
	
	/**
	 * 查询所有数量
	 * @param query
	 * @return
	 */
	public abstract int findArticleCount();
	
	/**
	 * 条件查询数量
	 * @param criterion
	 * @return
	 */
	public abstract int findArticleCount(Criterion criterion);
	
	/**
	 * new 查询文章
	 * @param criterion
	 * @param sort
	 * @param page
	 * @return
	 */
	public abstract List<Article> findArticleByQuery(Criterion criterion, Order sort, int page, int size);
	
}
