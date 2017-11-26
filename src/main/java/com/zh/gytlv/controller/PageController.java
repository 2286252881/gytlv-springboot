package com.zh.gytlv.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zh.gytlv.entity.Menu;
import com.zh.gytlv.service.UserService;

/**
 * 页面展示Controller
 * <p>Title: PageController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class PageController {
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String showIndex(Map<String,Object> map,HttpServletRequest request) {
		List<Menu> ms=userService.getAllMenu();
		
		map.put("ms", ms);
		map.put("selected", "/");
		return "front/index";
	}
	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page,Map<String,Object> map,HttpServletRequest request) {
		List<Menu> ms=userService.getAllMenu();
		map.put("ms", ms);
		map.put("selected", page);
		return "front/"+page;
	}
	
	@RequestMapping("/{tab}/{id}")
	public String showTabs(@PathVariable String tab,HttpServletRequest request){
		return "back/tabs/"+tab;
	}
	
	
	@RequestMapping("/404")
	public String showPage() {
		return "404";
	}
	
}
