package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class MySqlDataFactory {
	
	private Class<?> name;
	
	private static final Logger log = Logger.getLogger(MySqlDataFactory.class);
	
	public MySqlDataFactory(Class<?> name) {
		this.name = name;
	}

	public Class<?> getName() {
		return name;
	}

	public void setName(Class<?> name) {
		this.name = name;
	}

	public List<?> findToListLimit(Map<String, Object> query, Map<String, Object> sort, Map<String, Integer> pageing) {
		SessionFactory sf = DataRegistry.getSessionFactory();
		Session session = null;
		Criteria criteria = null;
		List<?> list = null;
		try {
			session = sf.openSession();
			criteria = session.createCriteria(name);
			
			//Ìõ¼þ
			if (!(query == null || query.isEmpty())) {
				criteria.add(Restrictions.allEq(query));
			}
			//·ÖÒ³
			if (!(pageing == null || pageing.isEmpty())) {
				int pageNumber = (pageing.get("pageNumber") - 1) * pageing.get("pageResults");
				criteria.setFirstResult(pageNumber);
				criteria.setMaxResults(pageing.get("pageResults"));
			}
			//ÅÅÐò
			if (!(sort == null || sort.isEmpty())) {
				for (String key : sort.keySet()) {
					String value = (String) sort.get(key);
					if (value.equals("desc")) {
						criteria.addOrder(Order.desc(key));
					} else {
						criteria.addOrder(Order.asc(key));
					}
				}
			}
			
			list = criteria.list();
		} catch (HibernateException e) {
			log.error("findToListLimit way [ " + name.getName() + " ]", e);
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}
	
	public List<?> findToList(Map<String, Object> query) {
		SessionFactory sf = DataRegistry.getSessionFactory();
		Session session = null;
		Criteria criteria = null;
		List<?> list = null;
		try {
			session = sf.openSession();
			criteria = session.createCriteria(name);
			
			if (query == null || query.isEmpty()) {
				list = criteria.list();
				return list;
			} else {
				criteria.add(Restrictions.allEq(query));
			}
			list = criteria.list();
		} catch (HibernateException e) {
			log.error("findToList way [ " + name.getName() + " ]", e);
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}
	
	public Object findById(Long id) {
		SessionFactory sf = DataRegistry.getSessionFactory();
		Session session = null;
		Criteria criteria = null;
		Object obj = null;
		try {
			session = sf.openSession();
			criteria = session.createCriteria(name);
			
			criteria.add(Restrictions.idEq(id));
			obj = criteria.uniqueResult();
		} catch (HibernateException e) {
			log.error("findById way [ " + name.getName() + " ]", e);
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return obj;
	}
	
	public Object findById(String id) {
		SessionFactory sf = DataRegistry.getSessionFactory();
		Session session = null;
		Criteria criteria = null;
		Object obj = null;
		try {
			session = sf.openSession();
			criteria = session.createCriteria(name);
			
			criteria.add(Restrictions.idEq(id));
			obj = criteria.uniqueResult();
		} catch (HibernateException e) {
			log.error("findById way [ " + name.getName() + " ]", e);
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return obj;
	}
	
	public Object findById(int id) {
		SessionFactory sf = DataRegistry.getSessionFactory();
		Session session = null;
		Criteria criteria = null;
		Object obj = null;
		try {
			session = sf.openSession();
			criteria = session.createCriteria(name);
			
			criteria.add(Restrictions.idEq(id));
			obj = criteria.uniqueResult();
		} catch (HibernateException e) {
			log.error("findById way [ " + name.getName() + " ]", e);
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return obj;
	}
	
	public Object find(Map<String, Object> query) {
		SessionFactory sf = DataRegistry.getSessionFactory();
		Session session = null;
		Criteria criteria = null;
		Object obj = null;
		try {
			session = sf.openSession();
			criteria = session.createCriteria(name);
			
			if (query == null || query.isEmpty()) {
				obj = criteria.uniqueResult();
				return obj;
			} else {
				criteria.add(Restrictions.allEq(query));
			}
			obj = criteria.uniqueResult();
		} catch (HibernateException e) {
			log.error("find way [ " + name.getName() + " ]", e);
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return obj;
	}
	
	public boolean save(Object obj) {
		SessionFactory sf = DataRegistry.getSessionFactory();
		Session session = null;
		Transaction tr = null;
		int isSave = 0;
		try {
			 session = sf.openSession();
			 tr = session.beginTransaction();
			 isSave = (Integer) session.save(name.getName(), obj);
			 tr.commit();
		} catch (HibernateException e) {
			log.error("save way [ " + name.getName() + " ]", e);
			e.printStackTrace();
			tr.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		if (isSave > 0) {
			log.info("(SUCCESS) [ " + name.getName() + " ] save way");
		}
		return isSave > 0 ? true : false;
	}
	
	public boolean update(Object obj) {
		SessionFactory sf = DataRegistry.getSessionFactory();
		Session session = null;
		Transaction tr = null;
		boolean isUpdate = true;
		try {
			session = sf.openSession();
			session.update(name.getName(), obj);
			tr = session.beginTransaction();
			tr.commit();
		} catch(HibernateException e) {
			isUpdate = false;
			log.error("update way [" + name.getName() + " ]", e);
			e.printStackTrace();
			tr.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		if (isUpdate) {
			log.info("(SUCCESS) [ " + name.getName() + " ] update way");
		}
		return isUpdate;
	}
	
	public boolean delete(Object obj) {
		SessionFactory sf = DataRegistry.getSessionFactory();
		Session session = null;
		Transaction tr = null;
		boolean isDelete = true;
		try {
			session = sf.openSession();
			session.delete(name.getName(), obj);
			tr = session.beginTransaction();
			tr.commit();
		} catch(HibernateException e) {
			isDelete = false;
			log.error("delete way [" + name.getName() + " ]", e);
			e.printStackTrace();
			tr.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		if (isDelete) {
			log.info("(SUCCESS) [ " + name.getName() + " ] delete way");
		}
		return isDelete;
	}
	
}
