package com.biz;

import java.util.Map;

import com.ttm.service.ServiceResponse;
/**
 * 
 * <p>介绍:文章业务接口</p>
 * @author 唐太明
 * @date 2016年3月10日 下午11:29:40
 * @version 1.0
 */
public interface ArticleBiz {

	public abstract ServiceResponse addArticle(Map<String, Object> request);

	public abstract ServiceResponse deleteArticle(Map<String, Object> request);

	public abstract ServiceResponse updateArticle(Map<String, Object> request);

	public abstract ServiceResponse findById(Map<String, Object> request);

	public abstract ServiceResponse findByMany(Map<String, Object> request);

	public abstract ServiceResponse findByList(Integer page, Integer size, String authorId);
	
	public abstract ServiceResponse findByList(Integer page, Integer size, String authorId, String sea);

}
