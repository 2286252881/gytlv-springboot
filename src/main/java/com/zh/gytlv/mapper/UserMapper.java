package com.zh.gytlv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zh.gytlv.entity.Menu;
import com.zh.gytlv.entity.Permission;
import com.zh.gytlv.entity.Role;
import com.zh.gytlv.entity.User;
import com.zh.gytlv.entity.Ztree;

public interface UserMapper {
	@Select("select * from t_user")
	public List<User> getAllUser();

	/**
	 * 获取主页菜单
	 * 
	 * @return
	 */
	@Select("select * from t_menu where type='nav'")
	public List<Menu> getAllMenu();

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */
	@Select("select * from t_user where username=#{user.username} and password=#{user.password}")
	public List<User> getUserByLogin(@Param("user") User user);

	/**
	 * 根据用户名称查询用户 shiro
	 * 
	 * @param userName
	 * @return
	 */
	@Select("select * from t_user where username=#{username}")
	public User getUserByName(@Param("username") String userName);

	/**
	 * 根据用户id查询当前用户角色 shro
	 * 
	 * @param userid
	 * @return
	 */
	@Select("SELECT r.id,ur.userid,r.rolename,r.remark,r.createdate,r.updatedate FROM t_role r LEFT JOIN t_userrole ur ON r.id=ur.roleid WHERE ur.userid=#{userid}")
	public List<Role> getUserRoles(@Param("userid") String userid);

	/**
	 * 根据角色查询权限 shiro
	 * 
	 * @param roleid
	 * @return
	 */
	@Select("SELECT m.id,m.menuname,m.type,m.url,m.createdate,m.updatedate FROM t_menu m LEFT JOIN t_rolemenu rm ON rm.menuid=m.id WHERE m.type='menu'AND rm.roidid=#{roleid}")
	public List<Permission> getPremission(@Param("roleid") String roleid);
	
	/**
	 * 查询一级菜单
	 * @return
	 */
	@Select("SELECT id,menuname FROM t_menu m WHERE m.id IN (SELECT m1.pid FROM t_menu m1 WHERE m1.pid IS NOT NULL GROUP BY m1.pid);")
	@Results({ @Result(column = "id", property = "id"), @Result(column = "menuname", property = "name")})
	public List<Ztree> getRoot();
	/**
	 * 根据pid查询二级菜单
	 * @return
	 */
	@Select("SELECT nodes.id id,nodes.menuname,CONCAT(nodes.url,'/',nodes.id) ahref FROM t_menu root RIGHT JOIN t_menu nodes ON root.id=nodes.pid  WHERE nodes.id IS NOT NULL AND nodes.type='menu' AND nodes.id!='0' and nodes.pid=#{id}")
	@Results({ @Result(column = "id", property = "id"), @Result(column = "menuname", property = "name")})
	public List<Ztree> getNodes(@Param("id") String id);
	
	/**
	 * 查询一、二级菜单
	 * @return
	 */
	@Select("SELECT id,menuname FROM t_menu m WHERE m.id IN (SELECT m1.pid FROM t_menu m1 WHERE m1.pid IS NOT NULL GROUP BY m1.pid);")
	@Results({ @Result(column = "id", property = "id"),
		@Result(column = "menuname", property = "name"),
		@Result(property="children",column="id",
		javaType=List.class,many=@Many(select="com.zh.gytlv.mapper.UserMapper.getNodes"))})
	public List<Ztree> getAllNodes();
}
