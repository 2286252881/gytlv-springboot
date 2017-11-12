package com.zh.gytlv.controller.front;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zh.gytlv.entity.Article;
import com.zh.gytlv.entity.Menu;
import com.zh.gytlv.service.ArticleService;
import com.zh.gytlv.service.UserService;

/**
 * 首页文章展示
 * 
 * @author Hiiso
 *
 */
@Controller
public class ArticleFrontController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private UserService userService;

	/**
	 * 最新10条
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/article")
	@ResponseBody
	public List<Article> showIndex() {
		return articleService.getAllArticle();
	}

	/**
	 * 文章详情
	 * 
	 * @param id
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/details")
	public String details(String id, Map<String, Object> map) throws Exception {
		List<Menu> ms = userService.getAllMenu();
		Article article = articleService.getArticle(id);
		map.put("ms", ms);
		map.put("article", article);
		return "front/details";
	}

	/**
	 * 推荐5
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/support")
	@ResponseBody
	public List<Article> support() {
		return articleService.getTopArticle();
	}

	/**
	 * 点击排行 8
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/click")
	@ResponseBody
	public List<Article> click() {
		return articleService.getClickArticle();
	}

}
