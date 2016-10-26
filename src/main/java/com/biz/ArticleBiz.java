package com.biz;

import java.util.List;

import com.orm.ArticleSimple;
import com.util.ServiceResponseUtils;

/**
 * 
 * <p>介绍:文章业务接口</p>
 * @author 唐太明
 * @date 2016年3月10日 下午11:29:40
 * @version 1.0
 */
public interface ArticleBiz {

	/**
	 * 分页，排序字段查询列表数据
	 * @param page
	 * @param size
	 * @return
	 */
	public abstract ServiceResponseUtils<List<ArticleSimple>> findArticleByList(int page, int size, String sortName);
	
	/**
	 * 根据作者id 查数据
	 * @param authorId
	 * @param page
	 * @param size
	 * @param sortName
	 * @return
	 */
	public abstract ServiceResponseUtils<List<ArticleSimple>> findArticleByList(String authorId, int page, int size, String sortName);
	
	/**
	 * 根据作者id + title/tags/digest 查询数据
	 * @param search
	 * @param authorId
	 * @param page
	 * @param size
	 * @param sortName
	 * @return
	 */
	public abstract ServiceResponseUtils<List<ArticleSimple>> findArticleByList(String search, String authorId, int page, int size, String sortName);
	
}
