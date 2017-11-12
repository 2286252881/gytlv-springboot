package com.zh.gytlv.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5410722100194387802L;
	private String id;
	private String rolename;
	private String remark;
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
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
