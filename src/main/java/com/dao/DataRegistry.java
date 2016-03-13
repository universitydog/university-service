package com.dao;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataRegistry {
	
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("com/application/spring/applicationContext-spring.xml");
	
	public static SessionFactory getSessionFactory() {
		return ac.getBean("sessionFactory", SessionFactory.class);
	}

}
