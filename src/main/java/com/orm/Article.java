package com.orm;

/**
 * 文章
 * 
 * @author 唐太明
 * @category 实体
 */
public class Article {

private Integer id;
	
	private String title;
	
	private String titleDate;
	
	private String inputDate;
	
	private String url;
	
	private String tags;
	
	private Type typeId;
	
	private Author authorId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Type getTypeId() {
		return typeId;
	}

	public void setTypeId(Type typeId) {
		this.typeId = typeId;
	}

	public Author getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Author authorId) {
		this.authorId = authorId;
	}

}
