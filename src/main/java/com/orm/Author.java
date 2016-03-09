package com.orm;

public class Author {
	private String id;

	private String realName;

	private String nickName;

	private String introduce;

	private int rank;

	private int love;

	private String createTime;

	private String imgurl;

	private Type typeId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getLove() {
		return love;
	}

	public void setLove(int love) {
		this.love = love;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public Type getTypeId() {
		return typeId;
	}

	public void setTypeId(Type typeId) {
		this.typeId = typeId;
	}
}
