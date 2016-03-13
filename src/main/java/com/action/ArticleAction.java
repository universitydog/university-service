package com.action;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.ArticleBiz;
import com.ttm.service.ServiceResponse;
import com.ttm.util.Dumper;

/***
 * <p>介绍 表现层</p>
 * @author 唐太明
 * @date 2016年3月10日 下午11:27:31
 * @version 1.0
 */
@Controller
@RequestMapping("a")
public class ArticleAction {
	
	private ServiceResponse service = new ServiceResponse();
	
	private ArticleBiz articleBiz;
	
	/**
	 * 保存文章
	 * @param token
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "article", method = RequestMethod.POST)
	@ResponseBody
	public ServiceResponse saveAriticle(@RequestHeader("token") String token, @RequestBody Map<String, Object> request) {
		
		return service;
	}
	
}
