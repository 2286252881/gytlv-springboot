package com.zh.gytlv.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Permission {
	private String id;
	private String menuname;
	private String type;
	private String url;
	@JSONField(format="yyyy-MM-dd HH:mm")
	private Date createdate;
	@JSONField(format="yyyy-MM-dd HH:mm")
	private Date updatedate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
}
