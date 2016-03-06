package com.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ttm.service.ServiceResponse;

@Controller
@RequestMapping(value="init")
public class ArticleAction {

	public ServiceResponse text(HttpServletRequest request) {
		request.getHeader("");
		return null;
	}
	
}
