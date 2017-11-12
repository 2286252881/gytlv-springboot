package com.zh.gytlv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zh.gytlv.entity.Article;
import com.zh.gytlv.entity.ArticleType;

public interface ArticleMapper {
	/**
	 * 最新5条博客
	 * @return
	 */
	@Select("SELECT a.id,a.articlename,a.articletime,a.articleclick,(SELECT t.articletypename FROM t_articletype t WHERE t.id=a.articletype) articletypename,(SELECT u.nickname FROM t_user u WHERE u.id=a.userid) nickname,SUBSTRING(a.articlecontent,1,100) articlecontent FROM t_article a ORDER BY a.articletime DESC LIMIT 5;")
	public List<Article> getAllArticle();
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@Select("SELECT a.id,a.articlename,a.articletime,a.articleclick,(SELECT t.articletypename FROM t_articletype t WHERE t.id=a.articletype) articletypename,(SELECT u.nickname FROM t_user u WHERE u.id=a.userid) nickname,a.articlecontent FROM t_article a where id=#{id};")
	public Article getArticle(String id);
	/**
	 * 博主推荐5条
	 * @return
	 */
	@Select("SELECT a.id,a.articlename,a.articleclick FROM t_article a where a.articlesupport=1 ORDER BY a.articletime DESC LIMIT 5;")
	public List<Article> getTopArticle();
	/**
	 * 点击排行 8
	 * @return
	 */
	@Select("SELECT a.id,a.articlename,a.articleclick FROM t_article a ORDER BY a.articleclick DESC LIMIT 8;")
	public List<Article> getClickArticle();
	/**
	 * 查询分类列表
	 * @return
	 */
	@Select("SELECT id,(SELECT username FROM t_user u WHERE u.id=t.userid) username,(SELECT nickname FROM t_user u WHERE u.id=t.userid) nickname,articletypename,createtime,(SELECT COUNT(*) FROM t_article a WHERE a.articletype=t.id) articleCount FROM t_articletype t")
	public List<ArticleType> getTypes();
	
	/**
	 * 查询所有文章
	 * @return
	 */
	@Select("SELECT a.id,a.articlename,(SELECT t.articletypename FROM t_articletype t WHERE a.articletype=t.id) articletypename,a.articletime,a.articleclick,(SELECT t.articletypename FROM t_articletype t WHERE t.id=a.articletype) articletypename,(SELECT u.username FROM t_user u WHERE u.id=a.userid) username,(SELECT nickname FROM t_user u WHERE u.id=a.userid) nickname FROM t_article a")
	public List<Article> getArticles();
	/**
	 * 添加文章
	 * @param article
	 * @return
	 */
	@Insert("insert into t_article(id,articlename,articletime,articletype,userid,articlecontent,articlesupport) values(#{article.id},#{article.articlename},#{article.articletime},#{article.articletype},#{article.userid},#{article.articlecontent},#{article.articlesupport})")
	public int addArticle(@Param("article")Article article);
}
