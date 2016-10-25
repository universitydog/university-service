package com.test;

import java.util.List;

import org.hibernate.criterion.Order;
import org.junit.Test;

import com.biz.ArticleBiz;
import com.dao.AuthorDao;
import com.orm.Author;
import com.ttm.util.Json;
import com.util.XmlRegisterUtil;

public class Demo {
	
	public static void main(String[] args) {
		ArticleBiz ab = (ArticleBiz) XmlRegisterUtil.getBean("articleBiz");
//		System.out.println(ab.updateArticle(null));
	}
	
	@Test
	public void a() {
//		ArticleBiz ab = (ArticleBiz) XmlRegisterUtil.getBean("articleBiz");
//		ServiceResponse srevice = ab.findByList(1, 3, "yfkiss", "h");
//		Dumper.dump(srevice);
//		ArticleDao ad = (ArticleDao) XmlRegisterUtil.getBean("articleDaoImpl");
//		System.out.println(ad.findArticleCount());
//		Criterion cri = Restrictions.eq("authorId", "yfkiss");
		
//		System.out.println(Json.toJson(ad.findArticleFuByListB(cri, Order.desc("inputDate"), 1)));
//		Object obj = ad.findByListSearchNumber("yfkiss", "h");
//		System.out.println(Integer.valueOf(obj.toString()));
		
		AuthorDao ad = (AuthorDao) XmlRegisterUtil.getBean("authorDaoImpl");
		List<Author> partA = ad.findAuthorByQuery(null, Order.desc("createTime"), 1, 20);
		System.out.println("ttm | " + partA.size());
	}
	
}
