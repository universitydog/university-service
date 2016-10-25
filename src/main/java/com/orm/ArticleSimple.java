package com.orm;

/**
 * 
 * <p>
 * 介绍 文章简单类
 * </p>
 * 
 * @author TTM
 * @date 2016年10月25日 上午6:28:18
 * @version 1.0
 */
public class ArticleSimple {

	private Integer id;
	
	private String tags;

	private String title;

	private String titleDate;

	private String inputDate;

	private String url;
	
	private Integer typeId;

	private String name;
	
	private String imgUrl;

	private String digest;
	
	private String authorId;

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

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
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

}
