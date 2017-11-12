package com.zh.gytlv.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ztree implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5297129698641244783L;
	private String id;
	private String name;
	private String pid;
	private String ahref;
	
	private List<Ztree> children=new ArrayList<>();
	
	public List<Ztree> getChildren() {
		return children;
	}
	public void setChildren(List<Ztree> children) {
		this.children = children;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getAhref() {
		return ahref;
	}
	public void setAhref(String ahref) {
		this.ahref = ahref;
	}
}
