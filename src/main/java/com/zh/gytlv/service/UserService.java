package com.zh.gytlv.service;

import java.util.List;

import com.zh.gytlv.entity.ArticleVisitor;
import com.zh.gytlv.entity.Menu;
import com.zh.gytlv.entity.Permission;
import com.zh.gytlv.entity.Role;
import com.zh.gytlv.entity.User;
import com.zh.gytlv.entity.Ztree;

public interface UserService {
	public List<User> getAllUser();
	
	/**
	 * 获取主页菜单
	 * @return
	 */
	public List<Menu> getAllMenu();

	public List<User> getUserByLogin(User user);
	
	public User getUserByName(String userName);
	
	public List<Role> getUserRoles(String userid);
	
	public List<Permission> getPremission(String roleid);
	
	
	
	public List<Ztree> getRoot();
	public List<Ztree> getNodes(String id);
	public List<Ztree> getAllNodes();

	public int regUser(String username, String password);

	public List<ArticleVisitor> getVisitors(String visitorIp,String id);

	public void insertVisitor(ArticleVisitor visitor);

	public void addReadNum(String id);
	
	public void truncateVisitor();
}
