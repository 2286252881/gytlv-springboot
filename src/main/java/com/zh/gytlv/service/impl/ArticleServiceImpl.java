package com.zh.gytlv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zh.gytlv.entity.Article;
import com.zh.gytlv.entity.ArticleType;
import com.zh.gytlv.mapper.ArticleMapper;
import com.zh.gytlv.service.ArticleService;
@Service("articleService")
public class ArticleServiceImpl implements  ArticleService{
	
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public List<Article> getAllArticle() {
		List<Article> articles=articleMapper.getAllArticle();
		for (Article article : articles) {
			article.setArticlecontent(article.getArticlecontent().replaceAll("<img[^>]*>", ""));
			if(article.getArticlecontent().length()>500){
				article.setArticlecontent(article.getArticlecontent().substring(0,article.getArticlecontent().indexOf('。')+1));
			}
		}
		return articles;
	}

	@Override
	public Article getArticle(String id) {
		return articleMapper.getArticle(id);
	}

	@Override
	public List<Article> getTopArticle() {
		return articleMapper.getTopArticle();
	}

	@Override
	public List<Article> getClickArticle() {
		return articleMapper.getClickArticle();
	}

	@Override
	public List<ArticleType> getTypes() {
		return articleMapper.getTypes();
	}

	@Override
	public List<Article> getArticles() {
		return articleMapper.getArticles();
	}

	@Override
	public boolean addArticle(Article article) {
		return articleMapper.addArticle(article)==1;
	}
}
