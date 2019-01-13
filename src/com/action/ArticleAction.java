package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.ArticleDAO;
import com.entity.Article;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/article")
public class ArticleAction {
	// 注入AdminDAO 并getter setter
	private ArticleDAO articleDAO;

	// 准备添加数据
	@RequestMapping("createArticle.action")
	public String createArticle(Map<String, Object> map) {
		return "admin/addarticle";
	}

	// 添加数据
	@RequestMapping("addArticle.action")
	public String addArticle(Article article) {
		article.setAddtime(VeDate.getStringDateShort());
		article.setHits("0");
		this.articleDAO.insertArticle(article);
		return "redirect:/article/createArticle.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteArticle.action")
	public String deleteArticle(String id) {
		this.articleDAO.deleteArticle(id);
		return "redirect:/article/getAllArticle.action";
	}

	// 更新数据
	@RequestMapping("updateArticle.action")
	public String updateArticle(Article article) {
		this.articleDAO.updateArticle(article);
		return "redirect:/article/getAllArticle.action";
	}

	// 显示全部数据
	@RequestMapping("getAllArticle.action")
	public String getAllArticle(String number, Map<String, Object> map) {
		List<Article> articleList = new ArrayList<Article>();
		List<Article> tempList = new ArrayList<Article>();
		tempList = this.articleDAO.getAllArticle();
		int pageNumber = tempList.size();
		int maxPage = pageNumber;
		if (maxPage % 10 == 0) {
			maxPage = maxPage / 10;
		} else {
			maxPage = maxPage / 10 + 1;
		}
		if (number == null) {
			number = "0";
		}
		int start = Integer.parseInt(number) * 10;
		int over = (Integer.parseInt(number) + 1) * 10;
		int count = pageNumber - over;
		if (count <= 0) {
			over = pageNumber;
		}
		for (int i = start; i < over; i++) {
			Article article = tempList.get(i);
			articleList.add(article);
		}
		String html = "";
		StringBuffer buffer = new StringBuffer();
		buffer.append("&nbsp;&nbsp;共为");
		buffer.append(maxPage);
		buffer.append("页&nbsp; 共有");
		buffer.append(pageNumber);
		buffer.append("条&nbsp; 当前为第");
		buffer.append((Integer.parseInt(number) + 1));
		buffer.append("页 &nbsp;");
		if ((Integer.parseInt(number) + 1) == 1) {
			buffer.append("首页");
		} else {
			buffer.append("<a href=\"article/getAllArticle.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append(
					"<a href=\"article/getAllArticle.action?number=" + (Integer.parseInt(number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append(
					"<a href=\"article/getAllArticle.action?number=" + (Integer.parseInt(number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"article/getAllArticle.action?number=" + (maxPage - 1) + "\">尾页</a>");
		}
		html = buffer.toString();
		map.put("html", html);
		map.put("articleList", articleList);
		return "admin/listarticle";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryArticleByCond.action")
	public String queryArticleByCond(String cond, String name, Map<String, Object> map) {
		List<Article> articleList = new ArrayList<Article>();
		Article article = new Article();
		if (cond != null) {
			if ("title".equals(cond)) {
				article.setTitle(name);
				articleList = this.articleDAO.getArticleByLike(article);
			}
			if ("image".equals(cond)) {
				article.setImage(name);
				articleList = this.articleDAO.getArticleByLike(article);
			}
			if ("contents".equals(cond)) {
				article.setContents(name);
				articleList = this.articleDAO.getArticleByLike(article);
			}
			if ("addtime".equals(cond)) {
				article.setAddtime(name);
				articleList = this.articleDAO.getArticleByLike(article);
			}
			if ("hits".equals(cond)) {
				article.setHits(name);
				articleList = this.articleDAO.getArticleByLike(article);
			}
		}
		map.put("articleList", articleList);
		return "admin/queryarticle";
	}

	// 按主键查询数据
	@RequestMapping("getArticleById.action")
	public String getArticleById(String id, Map<String, Object> map) {
		Article article = this.articleDAO.getArticleById(id);
		map.put("article", article);
		return "admin/editarticle";
	}

	public ArticleDAO getArticleDAO() {
		return articleDAO;
	}

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

}
