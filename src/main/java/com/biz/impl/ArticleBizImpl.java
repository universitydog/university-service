package com.biz.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.log4j.Logger;

import com.biz.ArticleBiz;
import com.dao.ArticleDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orm.Article;
import com.orm.ArticleFuZa;
import com.orm.HomeArticle;
import com.ttm.service.ServiceResponse;
import com.ttm.service.ServiceResponseCode;
import com.ttm.service.ServiceResponseMsg;
import com.ttm.util.Dumper;
import com.ttm.util.ServicePaginationHelper;
import com.ttm.util.ServiceQueryHelper;
import com.util.ServiceResponseUtils;
import com.util.ServiceSorterHelper;
import com.util.XmlRegisterUtil;

/***
 * 
 * <p>
 * 介绍 业务逻辑层实现类
 * </p>
 * 
 * @author 唐太明
 * @date 2016年3月10日 下午11:28:43
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class ArticleBizImpl implements ArticleBiz {

	private static final Logger logger = Logger.getLogger(ArticleBizImpl.class);
	/**
	 * 数据访问层
	 */
	private ArticleDao articleDao;

	/**
	 * 业务处理实体对象
	 */
	private ServiceResponseUtils service;

	/**
	 * 处理json 数据对象
	 */
	private ObjectMapper objectMapper;

	/**
	 * 添加一条文章数据
	 */
	public ServiceResponse addArticle(Map<String, Object> request) {
		init();
		System.out.println("biz:" + request.toString());

		Map<String, Object> type = (Map<String, Object>) request.get("typeId");
		Map<String, Object> author = (Map<String, Object>) request.get("authorId");

		request.remove("typeId");
		request.remove("authorId");
		boolean isAdd = true;
		Article article = new Article();
		if (MapUtils.isEmpty(request)) {
			service.setCode(ServiceResponseCode.WARN);
			service.setMsg(ServiceResponseMsg.WARN);
			return service;
		}

		try {
			BeanUtils.populate(article, request);
			if (MapUtils.isEmpty(type)) {
				service.setCode(ServiceResponseCode.WARN);
				service.setMsg("TypeId 属性不能为空...");
				return service;
			}
			if (MapUtils.isEmpty(author)) {
				service.setCode(ServiceResponseCode.WARN);
				service.setMsg("AuthorId 属性不能为空...");
				return service;
			}
			Integer typeId = (Integer) type.get("id");
			String authorId = (String) author.get("id");

			if (article.getId() == null) {
				article.setTypeId(typeId);
				article.setAuthorId(authorId);
				if (!articleDao.addArticle(article)) {
					isAdd = false;
				}
			} else {
				service.setCode(ServiceResponseCode.WARN);
				service.setMsg("数据已经存在了!");
				return service;
			}

		} catch (IllegalAccessException e) {
			logger.error("[error] add article fail for IllegalAccessException", e);
			isAdd = false;
		} catch (InvocationTargetException e) {
			logger.error("[error] add article fail for InvocationTargetException", e);
			isAdd = false;
		}

		if (!isAdd) {
			service.setCode(ServiceResponseCode.ERROR);
			service.setMsg(ServiceResponseMsg.ERROR);
		} else {
			service.setCode(ServiceResponseCode.SUCCESS);
			service.setMsg(ServiceResponseMsg.SUCCESS);
		}

		return service;
	}

	public ServiceResponse deleteArticle(Map<String, Object> request) {
		// TODO Auto-generated method stub
		return null;
	}

	public ServiceResponse updateArticle(Map<String, Object> request) {
		// TODO Auto-generated method stub
		return null;
	}

	public ServiceResponse findById(Map<String, Object> request) {
		// TODO Auto-generated method stub
		return null;
	}

	public ServiceResponse findByMany(Map<String, Object> request) {
		// TODO Auto-generated method stub
		return null;
	}

	public ServiceResponse findByList(Integer page, Integer size, String authorId) {
		init();
		String msg = null;
		Integer code = null;
		if (page == null || size == null || authorId == null) {
			code = ServiceResponseCode.ERROR;
		}

		if (page == null) {
			msg = "当前页为空.";
			service.setMsg(msg);
			return service;
		}
		if (size == null) {
			msg = "每页显示数量为空.";
			service.setMsg(msg);
			return service;
		} else if (size == 0) {
			msg = "除数不能为0";
			service.setMsg(msg);
			return service;
		}
		if (authorId == null) {
			msg = "作者ID为空.";
			service.setMsg(msg);
		}
		if (page == null || size == null || authorId == null) {
			return service;
		}

		List<Article> articles = new ArrayList<Article>();
		// 分页Map
		Map<String, Integer> paging = new HashMap<String, Integer>();
		paging.put("page", page);
		paging.put("size", size);
		// 查询条件
		Map<String, Object> query = new HashMap<String, Object>();
		ServiceQueryHelper.and(query, "authorId", authorId);
		articles = articleDao.findByList(query, null, paging);
		if (CollectionUtils.isEmpty(articles)) {
			code = ServiceResponseCode.WARN;
			msg = ServiceResponseMsg.WARN;
			service.setCode(code);
			service.setMsg(msg);
		} else {
			msg = ServiceResponseMsg.SUCCESS;
			code = ServiceResponseCode.SUCCESS;
			service.setMsg(msg);
			service.setCode(code);
			service.setPage(page);
			service.setSize(size);
			// 计算总页数
			List<Article> listCount = articleDao.findByList(query, null, null);
			if (CollectionUtils.isEmpty(listCount)) {
				service.setTotal(1);
			} else {
				service.setTotal(countTotal(size, listCount.size()));
			}

			service.setData(articles);
		}

		return service;
	}

	public ServiceResponse findByList(Integer page, Integer size, String authorId, String sea) {
		init();
		Integer index = countIndex(page, size);
		Integer length = countLength(size);
		System.out.println(index + "^^^^^^^^^^^length" + length);
		List<Article> articles = articleDao.findByListSearch(authorId, sea, index, length);
		System.out.println(articles.size() + " ^^^^^^^^^^^^^^");
		if (CollectionUtils.isNotEmpty(articles)) {
			service.setCode(ServiceResponseCode.SUCCESS);
			service.setMsg(ServiceResponseMsg.SUCCESS);
			service.setData(articles);
			service.setPage(page);
			service.setSize(size);

			Map<String, Object> query = new HashMap<String, Object>();
			ServiceQueryHelper.and(query, "authorId", authorId);
			ServiceQueryHelper.and(query, "sea", authorId);
			Object totalNumber = articleDao.findByListSearchNumber(authorId, sea);
			service.setTotal(countTotal(size, Integer.valueOf(totalNumber.toString())));
		} else {
			service = new ServiceResponseUtils();
		}
		return service;
	}

	public ServiceResponse findArticleByList(Integer page, Integer size, String sortName) {
		init();
		Map<String, Integer> pageing = ServicePaginationHelper.build(size, page);
		Map<String, Object> sort = ServiceSorterHelper.build(sortName, ServiceSorterHelper.DESC);
		List<ArticleFuZa> articleFuZaList = articleDao.findArticleFuByList(null, sort, pageing);
		if (CollectionUtils.isNotEmpty(articleFuZaList)) {
			
			int partCount = articleDao.findArticleCount();
			System.out.println("ttm | count:" + partCount);
			if (partCount != 0) {
				//获取总页数信息
				service.setTotal(countTotal(size, partCount));
				service.setCode(ServiceResponseCode.SUCCESS);
				service.setMsg(ServiceResponseMsg.SUCCESS);
				
				service.setPage(page);
				service.setSize(size);
				//获取数据, 对数据进行处理
				//1. 提取Type类型对应的数据，循环获取的数据 提取对应的 Type数据 存储到新实体中
				service.setData(setArticleFuZa(articleFuZaList));
			} else {
				service.setCode(ServiceResponseCode.WARN);
				service.setMsg("总页数获取失败...");
			}
		} else {
			service.setCode(ServiceResponseCode.WARN);
			service.setMsg(ServiceResponseMsg.WARN);
		}
		
		return service;
	}

	// *************************************************************************
	/**
	 * 设置对应文章实体数据
	 * @param articleFuZasL
	 * @return
	 */
	private List<HomeArticle> setArticleFuZa(List<ArticleFuZa> articleFuZasL) {
		List<HomeArticle> articleFuZasList = new ArrayList<HomeArticle>();
		for (ArticleFuZa article : articleFuZasL) {
			HomeArticle homeArticle = new HomeArticle();
			homeArticle.setId(article.getId());
			homeArticle.setTags(article.getTags());
			homeArticle.setTitle(article.getTitle());
			homeArticle.setInputDate(article.getInputDate());
			homeArticle.setUrl(article.getUrl());
			homeArticle.setAuthorId(article.getAuthorId());
			homeArticle.setDigest(article.getDigest());
			homeArticle.setTitleDate(article.getTitleDate());
			//Type
			homeArticle.setTypeId(article.getTypeId().getId());
			homeArticle.setName(article.getTypeId().getName());
			homeArticle.setImgUrl(article.getTypeId().getImgUrl());
			articleFuZasList.add(homeArticle);
		}
		
		return articleFuZasList;
	}
	
	/**
	 * 初始化 需要的一些必要对象
	 */
	private void init() {
		objectMapper = new ObjectMapper();
		service = (ServiceResponseUtils) XmlRegisterUtil.getBean("serviceUtils");
		articleDao = (ArticleDao) XmlRegisterUtil.getBean("articleDao");
	}

	/**
	 * 计算总页数
	 * 
	 * @param size
	 *            每页显示数量
	 * @param totalCount
	 *            总数量
	 * @return 总页数
	 */
	private Integer countTotal(int size, int totalCount) {
		if (totalCount < size) {
			return 1;
		}
		int tempCount = totalCount / size;
		return totalCount % size == 0 ? tempCount : tempCount + 1;
	}

	/**
	 * 根据当前页 计算搜应位置
	 * 
	 * @param page
	 *            当前页
	 * @param size
	 *            每页显示数量
	 * @return
	 */
	private Integer countIndex(Integer page, Integer size) {
		return (page - 1) * size;
	}

	/**
	 * 根据当前页 获取数据条目数量
	 * 
	 * @param size
	 *            每页显示数量
	 * @return
	 */
	private Integer countLength(Integer size) {
		return size;
	}

}
