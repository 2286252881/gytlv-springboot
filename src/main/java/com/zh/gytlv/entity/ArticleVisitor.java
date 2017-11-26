package com.zh.gytlv.entity;

import java.util.Date;

public class ArticleVisitor {
	private String id;
	private String visitorip;
	private Date visitortime;
	private String visitorarticleid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVisitorip() {
		return visitorip;
	}
	public void setVisitorip(String visitorip) {
		this.visitorip = visitorip;
	}
	public Date getVisitortime() {
		return visitortime;
	}
	public void setVisitortime(Date visitortime) {
		this.visitortime = visitortime;
	}
	public String getVisitorarticleid() {
		return visitorarticleid;
	}
	public void setVisitorarticleid(String visitorarticleid) {
		this.visitorarticleid = visitorarticleid;
	}
	public ArticleVisitor(String id, String visitorip, Date visitortime, String visitorarticleid) {
		super();
		this.id = id;
		this.visitorip = visitorip;
		this.visitortime = visitortime;
		this.visitorarticleid = visitorarticleid;
	}
	public ArticleVisitor() {
		super();
	}
}
