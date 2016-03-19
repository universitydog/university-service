package com.action;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.ArticleBiz;
import com.ttm.service.ServiceResponse;
import com.util.XmlRegisterUtil;

/***
 * <p>
 * 介绍 表现层
 * </p>
 * 
 * @author 唐太明
 * @date 2016年3月10日 下午11:27:31
 * @version 1.0
 */
@Controller
@RequestMapping("init")
public class ArticleAction {

	private ServiceResponse service;

	private ArticleBiz articleBiz;

	public ArticleAction() {
		service = (ServiceResponse) XmlRegisterUtil.getBean("service");
		articleBiz = (ArticleBiz) XmlRegisterUtil.getBean("articleBiz");
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
		return service;
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
	@RequestMapping(value = "article/{authorId}", method = RequestMethod.GET)
	@ResponseBody
	public ServiceResponse findAriticle(@RequestParam(value = "page") Integer page, @RequestParam("size") Integer size,
			@PathVariable("authorId") String authorId) {
		service = articleBiz.findByList(page, size, authorId);
		return service;
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
	@RequestMapping(value = "article/search", method = RequestMethod.GET)
	public ServiceResponse findAriticle(@RequestParam(value = "page") Integer page, @RequestParam("size") Integer size,
			@RequestParam(value = "sea") String sea, @RequestParam(value = "authorId") String authorId) {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^search:" + sea);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^authorId:" + authorId);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^page:" + page);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^size:" + size);
		service = articleBiz.findByList(page, size, authorId, sea);
		return service;
	}

}
