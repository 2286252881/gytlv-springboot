package com.zh.gytlv.controller.back;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zh.gytlv.entity.User;
import com.zh.gytlv.entity.Ztree;
import com.zh.gytlv.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String toLogin() {
		return "/back/login";
	}
	/**
	 * 到达注册页面
	 * @return
	 */
	@RequestMapping("/reg")
	public String toReg() {
		return "/back/reg";
	}
	/**
	 * 验证码页面
	 * @return
	 */
	@RequestMapping("/validatecode")
	public String validatecode() {
		return "/back/validatecode";
	}
	/**
	 * 用户注册
	 * @param request
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/doReg")
	@ResponseBody
	public Object doReg(HttpServletRequest request, String username, String password,String randomcode) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		User u = userService.getUserByName(username);
		//校验用户名
		if (u != null) {
			resultMap.put("status", 500);
			return resultMap;
		}
		//校验验证码
		if(!request.getSession().getAttribute("validateCode").equals(randomcode)){
			resultMap.put("status", 501);
			return resultMap;
		}
		userService.regUser(username, password);
		request.getSession().removeAttribute("validateCode");
		resultMap.put("status", 200);
		return resultMap;
	}

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	@ResponseBody
	public Object checkLogin(HttpServletRequest request, String username, String password, boolean rememberMe) {
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			try {
				UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
				resultMap.put("status", 200);
				currentUser.login(token);
			} catch (AuthenticationException ae) {
				resultMap.put("status", 500);
				System.out.println(ae);
			}
		}
		return resultMap;
	}

	/**
	 * 退出
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "/";
	}

	@RequestMapping("/toManager")
	public String toManager(HttpServletRequest request, Map<String, Object> map) {
		List<Ztree> allNodes = userService.getAllNodes();
		map.put("nodes", allNodes);
		return "back/manager";
	}

	@RequestMapping("/getAllTree")
	@ResponseBody
	public List<Ztree> getAllTree() {
		List<Ztree> allNodes = userService.getAllNodes();
		return allNodes;
	}

	@RequestMapping("/noAuthc")
	public String noAuthc(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "/400";
	}

}
