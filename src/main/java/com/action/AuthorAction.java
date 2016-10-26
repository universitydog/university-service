package com.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.AuthorBiz;
import com.orm.AuthorSimple;
import com.util.ServiceResponseUtils;
import com.util.VersionHelper;

/**
 * 
 * <p>
 * 介绍
 * </p>
 * 
 * @author 唐太明
 * @date 2016年10月26日下午8:13:01
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
@Controller
@RequestMapping(value = VersionHelper.VERSION)
public class AuthorAction {

	@Autowired
	private AuthorBiz authorBizImpl;
	
	/**
	 * 作者列表
	 * 
	 * @param page	当前页
	 * @param size	每页显示数量
	 * @return
	 */
	@RequestMapping(value = "author", method = RequestMethod.GET)
	@ResponseBody
	public ServiceResponseUtils findAuthorByList(
			@RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
			@RequestParam(value = "size", defaultValue = "20", required = false) Integer size) {
		ServiceResponseUtils<List<AuthorSimple>> partResponse = new ServiceResponseUtils<List<AuthorSimple>>();
		partResponse = authorBizImpl.findAuthorByList(page, size, "createTime");
		return partResponse;
	}

}
