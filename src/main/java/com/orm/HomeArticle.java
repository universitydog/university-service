package com.orm;

/**
 * 
 * <p>
 * 介绍：首页文章实体
 * </p>
 * 
 * @author 唐太明
 * @date 2016年4月5日 下午7:47:21
 * @version 1.0
 */
public class HomeArticle {

	private Integer id;// int 可为null data.文章ID 此为主键。article.id
	private String tags;// string 否 data.标签
	private String title;// string 否 data.文章标题
	private String titleDate;// string 否 data.文章发布时间
	private String inputDate;// string 否 data.导入时间
	private String url;// string 否 data.url
	private String name;// string varchar(10) 否
	private String imgUrl;// string varchar(200) 否
	private String digest;// string varchar(100) 否
	private String authorId;// string 否 外键
	private Integer typeId;//类型id

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleDate() {
		return titleDate;
	}

	public void setTitleDate(String titleDate) {
		this.titleDate = titleDate;
	}

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

}
