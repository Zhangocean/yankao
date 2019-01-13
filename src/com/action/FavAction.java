package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Fav;
import com.dao.FavDAO;
import com.entity.Users;
import com.entity.Course;
import com.dao.UsersDAO;
import com.dao.CourseDAO;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/fav")
public class FavAction extends BaseAction {
	// 注入AdminDAO 并getter setter
	private FavDAO favDAO;
	private UsersDAO usersDAO;
	private CourseDAO courseDAO;

	// 准备添加数据
	@RequestMapping("createFav.action")
	public String createFav(Map<String, Object> map) {
		List<Users> usersList = this.usersDAO.getAllUsers();
		map.put("usersList", usersList);
		List<Course> courseList = this.courseDAO.getAllCourse();
		map.put("courseList", courseList);
		return "admin/addfav";
	}

	// 添加数据
	@RequestMapping("addFav.action")
	public String addFav(Fav fav) {
		this.favDAO.insertFav(fav);
		return "redirect:/fav/createFav.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteFav.action")
	public String deleteFav(String id) {
		this.favDAO.deleteFav(id);
		return "redirect:/fav/getAllFav.action";
	}

	// 更新数据
	@RequestMapping("updateFav.action")
	public String updateFav(Fav fav) {
		this.favDAO.updateFav(fav);
		return "redirect:/fav/getAllFav.action";
	}

	// 显示全部数据
	@RequestMapping("getAllFav.action")
	public String getAllFav(String number, Map<String, Object> map) {
		List<Fav> favList = new ArrayList<Fav>();
		List<Fav> tempList = new ArrayList<Fav>();
		tempList = this.favDAO.getAllFav();
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
			Fav fav = tempList.get(i);
			favList.add(fav);
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
			buffer.append("<a href=\"fav/getAllFav.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"fav/getAllFav.action?number=" + (Integer.parseInt(number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"fav/getAllFav.action?number=" + (Integer.parseInt(number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"fav/getAllFav.action?number=" + (maxPage - 1) + "\">尾页</a>");
		}
		html = buffer.toString();
		map.put("html", html);
		map.put("favList", favList);
		return "admin/listfav";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryFavByCond.action")
	public String queryFavByCond(String cond, String name, Map<String, Object> map) {
		List<Fav> favList = new ArrayList<Fav>();
		Fav fav = new Fav();
		if (cond != null) {
			if ("usersid".equals(cond)) {
				fav.setUsersid(name);
				favList = this.favDAO.getFavByLike(fav);
			}
			if ("courseid".equals(cond)) {
				fav.setCourseid(name);
				favList = this.favDAO.getFavByLike(fav);
			}
			if ("addtime".equals(cond)) {
				fav.setAddtime(name);
				favList = this.favDAO.getFavByLike(fav);
			}
		}
		map.put("favList", favList);
		return "admin/queryfav";
	}

	// 按主键查询数据
	@RequestMapping("getFavById.action")
	public String getFavById(String id, Map<String, Object> map) {
		Fav fav = this.favDAO.getFavById(id);
		map.put("fav", fav);
		List<Users> usersList = this.usersDAO.getAllUsers();
		map.put("usersList", usersList);
		List<Course> courseList = this.courseDAO.getAllCourse();
		map.put("courseList", courseList);
		return "admin/editfav";
	}

	public FavDAO getFavDAO() {
		return favDAO;
	}

	public void setFavDAO(FavDAO favDAO) {
		this.favDAO = favDAO;
	}

	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
}
