package com.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.ArticleBiz;
import com.orm.ArticleSimple;
import com.ttm.service.ServiceResponse;
import com.util.ServiceResponseUtils;
import com.util.VersionHelper;

/***
 * <p>
 * 介绍 表现层
 * </p>
 * 
 * @author 唐太明
 * @date 2016年3月10日 下午11:27:31
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
@Controller
@RequestMapping(value = VersionHelper.VERSION)
public class ArticleAction {

//	private ServiceResponseUtils<List<ArticleSimple>> serviceUtils;

	@Autowired
	private ArticleBiz articleBizImpl;

	public ArticleAction() {
//		serviceUtils = (ServiceResponse) XmlRegisterUtil.getBean("service");
//		articleBizImpl = (ArticleBiz) XmlRegisterUtil.getBean("articleBizImpl");
	}

	/**
	 * 保存文章
	 * 
	 * @param token
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "article", method = RequestMethod.POST)
	@ResponseBody
	public ServiceResponse saveAriticle(@RequestHeader("token") String token,
			@RequestBody Map<String, Object> request) {
		// service = articleBiz.addArticle(request);
		return null;
	}

	/**
	 * 查询博主列表文章
	 * 
	 * @param page
	 *            当前页码
	 * @param size
	 *            一页显示数量
	 * @param authorId
	 *            作者Id
	 * 
	 * @return
	 */
	@RequestMapping(value = "article/{authorId}", params = {"page", "size"}, method = RequestMethod.GET)
	@ResponseBody
	public ServiceResponse findAriticle(@RequestParam(value = "page") Integer page, @RequestParam("size") Integer size,
			@PathVariable("authorId") String authorId) {
//		service = articleBiz.findByList(page, size, authorId);
		return null;
	}

	/**
	 * 搜索博主列表文章
	 * 
	 * @param token
	 * @param sea
	 *            搜索条件
	 * @param authorId
	 *            作者Id
	 * @return
	 */
	@RequestMapping(value = "article/{authorId}/search", params = {"sea", "page", "size"}, method = RequestMethod.GET)
	@ResponseBody
	public ServiceResponse findAriticle(@RequestParam(value = "page") Integer page, @RequestParam("size") Integer size,
			@RequestParam(value = "sea") String sea, @PathVariable(value = "authorId") String authorId) {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^search:" + sea);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^authorId:" + authorId);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^page:" + page);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^size:" + size);
//		service = articleBiz.findByList(page, size, authorId, sea);
		return null;
	}
	
	/** 
	 * 首页文章列表查询， 默认使用inputDate倒序排列
	 * @param page 当前页
	 * @param size	每页显示数量
	 * @param sea 搜索
	 * @param authorId 作者id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "home", method = RequestMethod.GET)
	@ResponseBody
	public ServiceResponseUtils home(@RequestParam(value = "page", defaultValue = "1", required = false) Integer page, 
			@RequestParam(value = "size", defaultValue = "20", required = false) Integer size) throws Exception {
		//查询条件 page，size，排序条件 inputDate
		Long startTime = System.currentTimeMillis();
		ServiceResponseUtils<List<ArticleSimple>> articleSimples = new ServiceResponseUtils<List<ArticleSimple>>();
		articleSimples = articleBizImpl.findArticleByList(page, size, "inputDate");
		Long endTime = System.currentTimeMillis();
		System.out.println("时间:" + (endTime - startTime));
		
		return articleSimples;
	}

}
