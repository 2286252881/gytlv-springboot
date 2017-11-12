package com.zh.gytlv.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class ArticleType {
	private String id;
	private String username;
	private String nickname;
	private String articletypename;
	@JSONField(format = "yyyy-MM-dd HH:mm")
	private Date createtime;
	private long articleCount;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id; 
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getArticletypename() {
		return articletypename;
	}
	public void setArticletypename(String articletypename) {
		this.articletypename = articletypename;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public long getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(long articleCount) {
		this.articleCount = articleCount;
	}
	
}
