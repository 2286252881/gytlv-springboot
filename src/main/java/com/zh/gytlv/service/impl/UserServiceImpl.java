package com.zh.gytlv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zh.gytlv.entity.Menu;
import com.zh.gytlv.entity.Permission;
import com.zh.gytlv.entity.Role;
import com.zh.gytlv.entity.User;
import com.zh.gytlv.entity.Ztree;
import com.zh.gytlv.mapper.UserMapper;
import com.zh.gytlv.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> getAllUser() {
		return userMapper.getAllUser();
	}

	@Override
	public List<Menu> getAllMenu() {
		return userMapper.getAllMenu();
	}

	@Override
	public List<User> getUserByLogin(User user) {
		return userMapper.getUserByLogin(user);
	}

	@Override
	public User getUserByName(String userName) {
		return userMapper.getUserByName(userName);
	}

	@Override
	public List<Role> getUserRoles(String userid) {
		return userMapper.getUserRoles(userid);
	}

	@Override
	public List<Permission> getPremission(String roleid) {
		
		return userMapper.getPremission(roleid);
	}


	@Override
	public List<Ztree> getRoot() {
		return userMapper.getRoot();
	}

	@Override
	public List<Ztree> getNodes(String id) {
		return userMapper.getNodes(id);
	}

	@Override
	public List<Ztree> getAllNodes() {
		return userMapper.getAllNodes();
	}

}
