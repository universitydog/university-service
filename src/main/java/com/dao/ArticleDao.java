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
	 * 条件查询数量   目前只处理等于的情况
	 * @param query
	 * @return
	 */
	public abstract int findArticleCount();
	
	/**
	 * new 查询文章
	 * @param criterion
	 * @param sort
	 * @param page
	 * @return
	 */
	public abstract List<Article> findArticleByQuery(Criterion criterion, Order sort, int page, int size);
	
}
