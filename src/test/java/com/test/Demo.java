package com.test;

import org.junit.Test;

import com.biz.ArticleBiz;
import com.ttm.service.ServiceResponse;
import com.ttm.util.Dumper;
import com.util.XmlRegisterUtil;

public class Demo {
	
	public static void main(String[] args) {
		ArticleBiz ab = (ArticleBiz) XmlRegisterUtil.getBean("articleBiz");
		System.out.println(ab.updateArticle(null));
	}
	
	@Test
	public void a() {
		ArticleBiz ab = (ArticleBiz) XmlRegisterUtil.getBean("articleBiz");
		ServiceResponse srevice = ab.findByList(1, 3, "yfkiss", "h");
		Dumper.dump(srevice);
//		ArticleDao ad = (ArticleDao) XmlRegisterUtil.getBean("articleDao");
//		Object obj = ad.findByListSearchNumber("yfkiss", "h");
//		System.out.println(Integer.valueOf(obj.toString()));
	}
	
}
