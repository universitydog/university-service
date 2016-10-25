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
	
}
