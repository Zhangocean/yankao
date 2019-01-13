package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Bbs;
import com.dao.BbsDAO;
import com.entity.Users;
import com.dao.UsersDAO;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/bbs")
public class BbsAction extends BaseAction {
	// 注入AdminDAO 并getter setter
	private BbsDAO bbsDAO;
	private UsersDAO usersDAO;

	// 准备添加数据
	@RequestMapping("createBbs.action")
	public String createBbs(Map<String, Object> map) {
		List<Users> usersList = this.usersDAO.getAllUsers();
		map.put("usersList", usersList);
		return "admin/addbbs";
	}

	// 添加数据
	@RequestMapping("addBbs.action")
	public String addBbs(Bbs bbs) {
		this.bbsDAO.insertBbs(bbs);
		return "redirect:/bbs/createBbs.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteBbs.action")
	public String deleteBbs(String id) {
		this.bbsDAO.deleteBbs(id);
		return "redirect:/bbs/getAllBbs.action";
	}

	// 更新数据
	@RequestMapping("updateBbs.action")
	public String updateBbs(Bbs bbs) {
		this.bbsDAO.updateBbs(bbs);
		return "redirect:/bbs/getAllBbs.action";
	}

	// 显示全部数据
	@RequestMapping("getAllBbs.action")
	public String getAllBbs(String number, Map<String, Object> map) {
		List<Bbs> bbsList = new ArrayList<Bbs>();
		List<Bbs> tempList = new ArrayList<Bbs>();
		tempList = this.bbsDAO.getAllBbs();
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
			Bbs bbs = tempList.get(i);
			bbsList.add(bbs);
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
			buffer.append("<a href=\"bbs/getAllBbs.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"bbs/getAllBbs.action?number=" + (Integer.parseInt(number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"bbs/getAllBbs.action?number=" + (Integer.parseInt(number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"bbs/getAllBbs.action?number=" + (maxPage - 1) + "\">尾页</a>");
		}
		html = buffer.toString();
		map.put("html", html);
		map.put("bbsList", bbsList);
		return "admin/listbbs";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryBbsByCond.action")
	public String queryBbsByCond(String cond, String name, Map<String, Object> map) {
		List<Bbs> bbsList = new ArrayList<Bbs>();
		Bbs bbs = new Bbs();
		if (cond != null) {
			if ("usersid".equals(cond)) {
				bbs.setUsersid(name);
				bbsList = this.bbsDAO.getBbsByLike(bbs);
			}
			if ("title".equals(cond)) {
				bbs.setTitle(name);
				bbsList = this.bbsDAO.getBbsByLike(bbs);
			}
			if ("contents".equals(cond)) {
				bbs.setContents(name);
				bbsList = this.bbsDAO.getBbsByLike(bbs);
			}
			if ("addtime".equals(cond)) {
				bbs.setAddtime(name);
				bbsList = this.bbsDAO.getBbsByLike(bbs);
			}
			if ("hits".equals(cond)) {
				bbs.setHits(name);
				bbsList = this.bbsDAO.getBbsByLike(bbs);
			}
			if ("repnum".equals(cond)) {
				bbs.setRepnum(name);
				bbsList = this.bbsDAO.getBbsByLike(bbs);
			}
		}
		map.put("bbsList", bbsList);
		return "admin/querybbs";
	}

	// 按主键查询数据
	@RequestMapping("getBbsById.action")
	public String getBbsById(String id, Map<String, Object> map) {
		Bbs bbs = this.bbsDAO.getBbsById(id);
		map.put("bbs", bbs);
		List<Users> usersList = this.usersDAO.getAllUsers();
		map.put("usersList", usersList);
		return "admin/editbbs";
	}

	public BbsDAO getBbsDAO() {
		return bbsDAO;
	}

	public void setBbsDAO(BbsDAO bbsDAO) {
		this.bbsDAO = bbsDAO;
	}

	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
}
