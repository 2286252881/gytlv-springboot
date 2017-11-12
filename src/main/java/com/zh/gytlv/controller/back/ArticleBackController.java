package com.zh.gytlv.controller.back;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.zh.gytlv.entity.Article;
import com.zh.gytlv.entity.ArticleType;
import com.zh.gytlv.entity.User;
import com.zh.gytlv.service.ArticleService;
import com.zh.gytlv.utils.FastDFSClient;

@Controller
public class ArticleBackController {
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/showType")
	@ResponseBody
	public Map<String, Object> showType(int page, int size) {
		if (size == 0) {
			size = 5;
		}
		Map<String, Object> resultMap = new HashMap<>();
		PageHelper.startPage(page, size);
		resultMap.put("data", articleService.getTypes());
		int count = articleService.getTypes().size() % size > 0 ? articleService.getTypes().size() / size + 1 : articleService.getTypes().size() / size;
		resultMap.put("count", count);
		resultMap.put("page", page);
		return resultMap;
	}

	@RequestMapping("/showArticles")
	@ResponseBody
	public Map<String, Object> showArticles(int page, int size) {
		if (size == 0) {
			size = 5;
		}
		Map<String, Object> resultMap = new HashMap<>();
		PageHelper.startPage(page, size);
		resultMap.put("data", articleService.getArticles());
		int count = articleService.getArticles().size() % size > 0 ? articleService.getArticles().size() / size + 1 : articleService.getArticles().size() / size;
		resultMap.put("count", count);
		resultMap.put("page", page);
		return resultMap;
	}
	@RequestMapping("/showArticlesTypesAgain")
	@ResponseBody
	public List<ArticleType> showArticlesAgain() {
		return articleService.getTypes();
	}
	
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
	@RequestMapping("pic/upload")
	@ResponseBody
	public Map<String,Object> picUpload(MultipartFile uploadFile,HttpServletRequest request){
		String originalFilename=uploadFile.getOriginalFilename();
		String extName=originalFilename.substring(originalFilename.lastIndexOf(".")+1);
		try {
			FastDFSClient fClient=new FastDFSClient("classpath:client.conf");
			String url=fClient.uploadFile(uploadFile.getBytes(), extName);
			url=IMAGE_SERVER_URL+url;
			Map<String,Object> result=new HashMap<>();
			result.put("error", 0);
			result.put("url", url);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			Map<String,Object> result=new HashMap<>();
			result.put("error", 1);
			result.put("message", "图片上传失败!");
			return result;
		}
	}
	
	@RequestMapping("addArticle")
	@ResponseBody
	public Map<String,Object> addArticle(Article article){
		User user=(User) SecurityUtils.getSubject().getPrincipal();
		article.setArticletime(new Date());
		article.setId(UUID.randomUUID().toString());
		article.setUserid(user.getId());
		boolean flag=articleService.addArticle(article);
		Map<String, Object> map=new HashMap<>();
		if(flag){
			map.put("status", 200);
		}
		return map;
	}
}
