package com.zh.gytlv.service;

import java.util.List;

import com.zh.gytlv.entity.Article;
import com.zh.gytlv.entity.ArticleType;

public interface ArticleService {
	/**
	 * 最新5条
	 * @return
	 */
	public List<Article> getAllArticle();
	/**
	 * 查看文章详情
	 * @param id
	 * @return
	 */
	public Article getArticle(String id);
	/**
	 * 博主推荐5
	 * @return
	 */
	public List<Article> getTopArticle();
	/**
	 * 点击排行8
	 * @return
	 */
	public List<Article> getClickArticle();
	
	
	/**
	 * 查询分类列表
	 * @return
	 */
	public List<ArticleType> getTypes();
	
	/**
	 * 查询文章列表
	 */
	public List<Article> getArticles();
	
	/**
	 * 添加文章
	 * @param article
	 * @return
	 */
	public boolean addArticle(Article article);
}
