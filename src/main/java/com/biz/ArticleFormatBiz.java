package com.biz;

import java.util.List;

import com.orm.Article;
import com.orm.ArticleSimple;
import com.util.ServiceResponseUtils;

/**
 * 
 * <p>
 * 介绍
 * </p>
 * 
 * @author TTM
 * @date 2016年10月25日 下午10:22:28
 * @version 1.0
 */
public interface ArticleFormatBiz {

	public abstract List<ArticleSimple> constructArticleSimple(List<Article> articles);
	
	public abstract ServiceResponseUtils<List<ArticleSimple>> constructServiceResponse(int code,
			List<ArticleSimple> articleSimples, int page, int size, int totalPage);
	
}
