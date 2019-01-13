package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Vedio;
import com.util.VeDate;
import com.dao.VedioDAO;
import com.entity.Course;
import com.dao.CourseDAO;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/vedio")
public class VedioAction extends BaseAction {
	// 注入AdminDAO 并getter setter
	private VedioDAO vedioDAO;
	private CourseDAO courseDAO;

	// 准备添加数据
	@RequestMapping("createVedio.action")
	public String createVedio(Map<String, Object> map) {
		List<Course> courseList = this.courseDAO.getAllCourse();
		map.put("courseList", courseList);
		return "admin/addvedio";
	}

	// 添加数据
	@RequestMapping("addVedio.action")
	public String addVedio(Vedio vedio) {
		vedio.setAddtime(VeDate.getStringDateShort());
		vedio.setHits("0");
		this.vedioDAO.insertVedio(vedio);
		return "redirect:/vedio/createVedio.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteVedio.action")
	public String deleteVedio(String id) {
		this.vedioDAO.deleteVedio(id);
		return "redirect:/vedio/getAllVedio.action";
	}

	// 更新数据
	@RequestMapping("updateVedio.action")
	public String updateVedio(Vedio vedio) {
		this.vedioDAO.updateVedio(vedio);
		return "redirect:/vedio/getAllVedio.action";
	}

	// 显示全部数据
	@RequestMapping("getAllVedio.action")
	public String getAllVedio(String number, Map<String, Object> map) {
		List<Vedio> vedioList = new ArrayList<Vedio>();
		List<Vedio> tempList = new ArrayList<Vedio>();
		tempList = this.vedioDAO.getAllVedio();
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
			Vedio vedio = tempList.get(i);
			vedioList.add(vedio);
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
			buffer.append("<a href=\"vedio/getAllVedio.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"vedio/getAllVedio.action?number=" + (Integer.parseInt(number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"vedio/getAllVedio.action?number=" + (Integer.parseInt(number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"vedio/getAllVedio.action?number=" + (maxPage - 1) + "\">尾页</a>");
		}
		html = buffer.toString();
		map.put("html", html);
		map.put("vedioList", vedioList);
		return "admin/listvedio";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryVedioByCond.action")
	public String queryVedioByCond(String cond, String name, Map<String, Object> map) {
		List<Vedio> vedioList = new ArrayList<Vedio>();
		Vedio vedio = new Vedio();
		if (cond != null) {
			if ("title".equals(cond)) {
				vedio.setTitle(name);
				vedioList = this.vedioDAO.getVedioByLike(vedio);
			}
			if ("courseid".equals(cond)) {
				vedio.setCourseid(name);
				vedioList = this.vedioDAO.getVedioByLike(vedio);
			}
			if ("url".equals(cond)) {
				vedio.setUrl(name);
				vedioList = this.vedioDAO.getVedioByLike(vedio);
			}
			if ("addtime".equals(cond)) {
				vedio.setAddtime(name);
				vedioList = this.vedioDAO.getVedioByLike(vedio);
			}
			if ("hits".equals(cond)) {
				vedio.setHits(name);
				vedioList = this.vedioDAO.getVedioByLike(vedio);
			}
		}
		map.put("vedioList", vedioList);
		return "admin/queryvedio";
	}

	// 按主键查询数据
	@RequestMapping("getVedioById.action")
	public String getVedioById(String id, Map<String, Object> map) {
		Vedio vedio = this.vedioDAO.getVedioById(id);
		map.put("vedio", vedio);
		List<Course> courseList = this.courseDAO.getAllCourse();
		map.put("courseList", courseList);
		return "admin/editvedio";
	}

	public VedioDAO getVedioDAO() {
		return vedioDAO;
	}

	public void setVedioDAO(VedioDAO vedioDAO) {
		this.vedioDAO = vedioDAO;
	}

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
}
