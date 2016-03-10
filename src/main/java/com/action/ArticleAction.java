package com.action;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/***
 * <p>介绍 表现层</p>
 * @author 唐太明
 * @date 2016年3月10日 下午11:27:31
 * @version 1.0
 */
@Controller
@RequestMapping("a")
public class ArticleAction {
	
	@RequestMapping(value = "article", method = RequestMethod.GET)
	public String saveAriticle(@RequestHeader("token") String token, @RequestBody Map<String, Object> request) {
		
		return "index";
	}
	
}
