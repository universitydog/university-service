package com.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.dao.ArticleDao;
import com.dao.DataRegistry;
import com.dao.MySqlDataFactory;
import com.orm.Article;
import com.orm.ArticleFuZa;

@SuppressWarnings("unchecked")
public class ArticleDaoImpl implements ArticleDao {

	private MySqlDataFactory mysqlFactory = new MySqlDataFactory(Article.class);
	
	private MySqlDataFactory articleFuZaFactory = new MySqlDataFactory(ArticleFuZa.class);

	public boolean addArticle(Article art) {
		return mysqlFactory.save(art);
	}

	public boolean deleteArticle(Integer id) {
		Article art = findById(id);
		if (art == null) {
			return false;
		} else {
			return mysqlFactory.delete(art);
		}
	}

	public boolean updateArticle(Article art) {
		return mysqlFactory.update(art);
	}

	public Article findById(Integer id) {
		return (Article) mysqlFactory.findById(id);
	}

	public Article findByMany(Map<String, Object> request) {
		return (Article) mysqlFactory.find(request);
	}

	public List<Article> findByList(Map<String, Object> request, Map<String, Object> sort,
			Map<String, Integer> pageing) {
		return (List<Article>) mysqlFactory.findToListLimit(request, sort, pageing);
	}
	
	public List<Article> findByListSearch(String authorId, String sea,  Integer index, Integer length) {
		SessionFactory factory = DataRegistry.getSessionFactory();
		Session session = null;
		String sql = "select this_.id, this_.title, this_.titleDate, this_.typeId, this_.inputDate, this_.url, this_.tags, this_.authorId from "
				+ "test.tb_article this_ " + "WHERE " + "this_.authorId=? " + "and " + " ( "
				+ "upper(this_.title) like binary concat('%', UPPER(?), '%') " + "or "
				+ "upper(this_.tags) like binary concat('%', UPPER(?), '%') " + " ) limit ?, ?";
		List<Article> articles = new ArrayList<Article>();
		try {
			session = factory.openSession();
			Query query = session.createSQLQuery(sql);
			query.setString(0, authorId);
			query.setString(1, sea);
			query.setString(2, sea);
			query.setInteger(3, index);
			query.setInteger(4, length);
			articles = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return articles;
	}

	public Object findByListSearchNumber(String authorId, String sea) {
		SessionFactory factory = DataRegistry.getSessionFactory();
		Session session = null;
		String sql = "SELECT COUNT(*) FROM "
				+ "test.tb_article this_ " + "WHERE " + "this_.authorId=? " + "AND " + "( "
				+ "UPPER(this_.title) LIKE BINARY CONCAT('%', UPPER(?), '%') " + "or "
				+ "UPPER(this_.tags) LIKE BINARY CONCAT('%', UPPER(?), '%') " + " )";
		Object number = null;
		try {
			session = factory.openSession();
			Query query = session.createSQLQuery(sql);
			query.setString(0, authorId);
			query.setString(1, sea);
			query.setString(2, sea);
			number = query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return number;
	}

	public List<ArticleFuZa> findArticleFuByList(Map<String, Object> query, Map<String, Object> sort,
			Map<String, Integer> pageing) {
		return (List<ArticleFuZa>) articleFuZaFactory.findToListLimit(query, sort, pageing);
	}

	public int findArticleCount() {
		String partCount = mysqlFactory.findCount();
		return Integer.parseInt(partCount);
	}

}
