package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * 
 * <p>介绍：MySql 数据库操作基类</p>
 * @author 唐太明
 * @date 2016年3月13日 下午5:07:25
 * @version 1.0
 */
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

	/**
	 * 分页查询数据
	 * @param query 查询条件
	 * @param sort 排序方式
	 * @param pageing 分页方式
	 * @return
	 */
	public List<?> findToListLimit(Map<String, Object> query, Map<String, Object> sort, Map<String, Integer> pageing) {
		SessionFactory sf = DataRegistry.getSessionFactory();
		Session session = null;
		Criteria criteria = null;
		List<?> list = null;
		try {
			session = sf.openSession();
			criteria = session.createCriteria(name);
			
			//查询条件
			if (!(query == null || query.isEmpty())) {
				criteria.add(Restrictions.allEq(query));
			}
			//分页条件
			if (!(pageing == null || pageing.isEmpty())) {
				int pageNumber = (pageing.get("page") - 1) * pageing.get("size");
				criteria.setFirstResult(pageNumber);
				criteria.setMaxResults(pageing.get("size"));
			}
			//排序条件
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
		} catch (Exception e) {
			log.error("findToListLimit way [ " + name.getName() + " ]", e);
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}
	
	/**
	 * 条件查询集合数据
	 * @param query 查询条件
	 * @return 数据集合
	 */
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
		} catch (Exception e) {
			log.error("findToList way [ " + name.getName() + " ]", e);
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}
	
	/**
	 * Long类型 ID 查询数据
	 * @param id 类型为Long的Id
	 * @return Object对象
	 */
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
		} catch (Exception e) {
			log.error("findById way [ " + name.getName() + " ]", e);
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return obj;
	}
	
	/**
	 * String类型 ID 查询数据
	 * @param id 类型为String的Id
	 * @return Object对象
	 */
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
		} catch (Exception e) {
			log.error("findById way [ " + name.getName() + " ]", e);
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return obj;
	}
	
	/**
	 * int 类型 ID 查询数据
	 * @param id 类型为 int 的Id
	 * @return Object对象
	 */
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
		} catch (Exception e) {
			log.error("findById way [ " + name.getName() + " ]", e);
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return obj;
	}
	
	/**
	 * 多条件查询数据
	 * @param query 查询Map
	 * @return Object对象
	 */
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
		} catch (Exception e) {
			log.error("find way [ " + name.getName() + " ]", e);
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return obj;
	}
	
	/**
	 * 保存对象
	 * @param obj 对应注入对象
	 * @return true 保存成功/false 保存失败
	 */
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
		} catch (Exception e) {
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
	
	/**
	 * 修改对象
	 * @param obj 对应注入对象
	 * @return true 修改成功/false 修改失败
	 */
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
		} catch(Exception e) {
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
	
	/**
	 * 删除对象
	 * @param obj 对应注入对象
	 * @return true 删除成功/false 删除失败
	 */
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
		} catch(Exception e) {
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
