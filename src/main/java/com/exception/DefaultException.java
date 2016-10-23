package com.exception;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.util.ServiceResponse;
import com.util.ServiceResponseCode;
import com.util.ServiceResponseData;
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
		ServiceResponse<Map<String, Object>> partResponse = new ServiceResponse<Map<String, Object>>(ServiceResponseCode.ERROR, ServiceResponseMsg.ERROR);
		partResponse.setData(new ServiceResponseData<Map<String, Object>>());
		partView.addObject(partResponse);
		return partView;
	}

}
