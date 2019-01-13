package com.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import com.entity.Article;

public class ArticleDAO {
	// sqlSessionTemplate 注入 在applicationContext.xml里定义
	private SqlSessionTemplate sqlSessionTemplate;

	// 插入数据 调用entity包article.xml里的insertArticle配置
	public void insertArticle(Article article) {
		this.sqlSessionTemplate.insert("insertArticle", article);
	}

	// 更新数据 调用entity包article.xml里的updateArticle配置
	public void updateArticle(Article article) {
		this.sqlSessionTemplate.update("updateArticle", article);
	}

	// 删除数据 调用entity包article.xml里的deleteArticle配置
	public void deleteArticle(String articleid) {
		this.sqlSessionTemplate.delete("deleteArticle", articleid);
	}

	// 查询全部数据 调用entity包article.xml里的getAllArticle配置
	public List<Article> getAllArticle() {
		return this.sqlSessionTemplate.selectList("getAllArticle");
	}

	public List<Article> getFrontArticle() {
		return this.sqlSessionTemplate.selectList("getFrontArticle");
	}

	// 按照Admin类里面的值精确查询 调用entity包article.xml里的getArticleByCond配置
	public List<Article> getArticleByCond(Article article) {
		return this.sqlSessionTemplate.selectList("getArticleByCond", article);
	}

	// 按照Article类里面的值模糊查询 调用entity包article.xml里的getArticleByLike配置
	public List<Article> getArticleByLike(Article article) {
		return this.sqlSessionTemplate.selectList("getArticleByLike", article);
	}

	// 按主键查询表返回单一的Article实例 调用entity包article.xml里的getArticleById配置
	public Article getArticleById(String articleid) {
		return this.sqlSessionTemplate.selectOne("getArticleById", articleid);
	}

	// IOC注入所需要的getter和setter
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

}
