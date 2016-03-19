package com.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * <p>介绍:注册spring的bean文件, 用于分层开发</p>
 * @author 唐太明
 * @date 2016年3月13日 下午2:39:14
 * @version 1.0
 */
public class XmlRegisterUtil {

	private static final String PATH = "com/application/spring/bean-spring.xml";
	
	private static ApplicationContext ac = new ClassPathXmlApplicationContext(PATH);
	
	public static Object getBean(String beanName) {
		return ac.getBean(beanName);
	}
	
}
