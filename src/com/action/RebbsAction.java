package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Rebbs;
import com.dao.RebbsDAO;
import com.entity.Users;
import com.dao.UsersDAO;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/rebbs")
public class RebbsAction extends BaseAction {
	// 注入AdminDAO 并getter setter
	private RebbsDAO rebbsDAO;
	private UsersDAO usersDAO;

	// 准备添加数据
	@RequestMapping("createRebbs.action")
	public String createRebbs(Map<String, Object> map) {
		List<Users> usersList = this.usersDAO.getAllUsers();
		map.put("usersList", usersList);
		return "admin/addrebbs";
	}

	// 添加数据
	@RequestMapping("addRebbs.action")
	public String addRebbs(Rebbs rebbs) {
		this.rebbsDAO.insertRebbs(rebbs);
		return "redirect:/rebbs/createRebbs.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteRebbs.action")
	public String deleteRebbs(String id) {
		this.rebbsDAO.deleteRebbs(id);
		return "redirect:/rebbs/getAllRebbs.action";
	}

	// 更新数据
	@RequestMapping("updateRebbs.action")
	public String updateRebbs(Rebbs rebbs) {
		this.rebbsDAO.updateRebbs(rebbs);
		return "redirect:/rebbs/getAllRebbs.action";
	}

	// 显示全部数据
	@RequestMapping("getAllRebbs.action")
	public String getAllRebbs(String number, Map<String, Object> map) {
		List<Rebbs> rebbsList = new ArrayList<Rebbs>();
		List<Rebbs> tempList = new ArrayList<Rebbs>();
		tempList = this.rebbsDAO.getAllRebbs();
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
			Rebbs rebbs = tempList.get(i);
			rebbsList.add(rebbs);
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
			buffer.append("<a href=\"rebbs/getAllRebbs.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"rebbs/getAllRebbs.action?number=" + (Integer.parseInt(number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"rebbs/getAllRebbs.action?number=" + (Integer.parseInt(number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"rebbs/getAllRebbs.action?number=" + (maxPage - 1) + "\">尾页</a>");
		}
		html = buffer.toString();
		map.put("html", html);
		map.put("rebbsList", rebbsList);
		return "admin/listrebbs";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryRebbsByCond.action")
	public String queryRebbsByCond(String cond, String name, Map<String, Object> map) {
		List<Rebbs> rebbsList = new ArrayList<Rebbs>();
		Rebbs rebbs = new Rebbs();
		if (cond != null) {
			if ("usersid".equals(cond)) {
				rebbs.setUsersid(name);
				rebbsList = this.rebbsDAO.getRebbsByLike(rebbs);
			}
			if ("bbsid".equals(cond)) {
				rebbs.setBbsid(name);
				rebbsList = this.rebbsDAO.getRebbsByLike(rebbs);
			}
			if ("contents".equals(cond)) {
				rebbs.setContents(name);
				rebbsList = this.rebbsDAO.getRebbsByLike(rebbs);
			}
			if ("addtime".equals(cond)) {
				rebbs.setAddtime(name);
				rebbsList = this.rebbsDAO.getRebbsByLike(rebbs);
			}
		}
		map.put("rebbsList", rebbsList);
		return "admin/queryrebbs";
	}

	// 按主键查询数据
	@RequestMapping("getRebbsById.action")
	public String getRebbsById(String id, Map<String, Object> map) {
		Rebbs rebbs = this.rebbsDAO.getRebbsById(id);
		map.put("rebbs", rebbs);
		List<Users> usersList = this.usersDAO.getAllUsers();
		map.put("usersList", usersList);
		return "admin/editrebbs";
	}

	public RebbsDAO getRebbsDAO() {
		return rebbsDAO;
	}

	public void setRebbsDAO(RebbsDAO rebbsDAO) {
		this.rebbsDAO = rebbsDAO;
	}

	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
}
