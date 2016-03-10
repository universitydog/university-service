package com.biz;

import java.util.List;
import java.util.Map;

import com.orm.Article;
/**
 * 
 * <p>介绍:文章业务接口</p>
 * @author 唐太明
 * @date 2016年3月10日 下午11:29:40
 * @version 1.0
 */
public interface ArticleBiz {

	public abstract boolean addArticle(Map<String, Object> request);

	public abstract boolean deleteArticle(Map<String, Object> request);

	public abstract boolean updateArticle(Map<String, Object> request);

	public abstract Article findById(Map<String, Object> request);

	public abstract Article findByMany(Map<String, Object> request);

	public abstract List<Article> findByList(Map<String, Object> request);

}
