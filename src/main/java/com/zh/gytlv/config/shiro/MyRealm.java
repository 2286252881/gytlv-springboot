package com.zh.gytlv.config.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.gytlv.entity.Permission;
import com.zh.gytlv.entity.Role;
import com.zh.gytlv.entity.User;
import com.zh.gytlv.service.UserService;

public class MyRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User principal=(User) principals.getPrimaryPrincipal();
		
		List<Role> userRoles=userService.getUserRoles(principal.getId());
		//添加权限
		Set<String> roles=new HashSet<String>();
		Set<String> permissions=new HashSet<String>();
		if(null!=userRoles){
			for (Role role : userRoles) {
				roles.add(role.getRolename());
				List<Permission> ps=userService.getPremission(role.getId());
				for (Permission p : ps) {
					permissions.add(p.getMenuname());
				}
			}
		}
		SimpleAuthorizationInfo info= new SimpleAuthorizationInfo(roles);
		info.addStringPermissions(permissions);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String userName = upToken.getUsername();
		User userInfo =userService.getUserByName(userName);
		if (null == userInfo) {
			throw new UnknownAccountException("用户不存在!");
		}
		Object credentials = userInfo.getPassword(); 
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, credentials, getName());
		return authenticationInfo;
	}

}
