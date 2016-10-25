package com.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.util.ServiceResponse;
import com.util.ServiceResponseCode;
import com.util.ServiceResponseMsg;

/**
 * 异常处理
 * @author TTM
 * @date 2016年10月23日 下午11:05:23
 * @version 1.0
 */
public class DefaultException implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		ModelAndView partView = new ModelAndView();
		MappingJackson2JsonView partJsonView = new MappingJackson2JsonView();
		Map<String, Object> partError = new HashMap<String, Object>();
		partError.put("code", ServiceResponseCode.ERROR);
		partError.put("msg", ServiceResponseMsg.ERROR + " | 请求异常");
		partView.addAllObjects(partError);
		partView.setView(partJsonView);
		return partView;
	}

}
