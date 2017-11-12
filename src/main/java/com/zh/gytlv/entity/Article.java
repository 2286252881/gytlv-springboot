package com.zh.gytlv.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Article {
	private String id;

	private String articlename;

	@JSONField(format = "yyyy-MM-dd HH:mm")
	private Date articletime;

	private Integer articleclick;
	
	private String articletype;
	private String articletypename;

	private String userid;
	private String username;
	
	private String nickname;

	private String articlemodle;
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getArticletype() {
		return articletype;
	}

	public void setArticletype(String articletype) {
		this.articletype = articletype;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArticlename() {
		return articlename;
	}

	public void setArticlename(String articlename) {
		this.articlename = articlename;
	}

	public Date getArticletime() {
		return articletime;
	}

	public void setArticletime(Date articletime) {
		this.articletime = articletime;
	}

	public Integer getArticleclick() {
		return articleclick;
	}

	public void setArticleclick(Integer articleclick) {
		this.articleclick = articleclick;
	}

	public String getArticletypename() {
		return articletypename;
	}

	public void setArticletypename(String articletypename) {
		this.articletypename = articletypename;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getArticlemodle() {
		return articlemodle;
	}

	public void setArticlemodle(String articlemodle) {
		this.articlemodle = articlemodle;
	}

	public String getArticlesupport() {
		return articlesupport;
	}

	public void setArticlesupport(String articlesupport) {
		this.articlesupport = articlesupport;
	}

	public String getArticlecontent() {
		return articlecontent;
	}

	public void setArticlecontent(String articlecontent) {
		this.articlecontent = articlecontent;
	}

	private String articlesupport;

	private String articlecontent;

}
