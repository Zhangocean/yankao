package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Teacher;
import com.dao.TeacherDAO;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/teacher")
public class TeacherAction extends BaseAction {
	// 注入AdminDAO 并getter setter
	private TeacherDAO teacherDAO;

	// 准备添加数据
	@RequestMapping("createTeacher.action")
	public String createTeacher(Map<String, Object> map) {
		return "admin/addteacher";
	}

	// 添加数据
	@RequestMapping("addTeacher.action")
	public String addTeacher(Teacher teacher) {
		this.teacherDAO.insertTeacher(teacher);
		return "redirect:/teacher/createTeacher.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteTeacher.action")
	public String deleteTeacher(String id) {
		this.teacherDAO.deleteTeacher(id);
		return "redirect:/teacher/getAllTeacher.action";
	}

	// 更新数据
	@RequestMapping("updateTeacher.action")
	public String updateTeacher(Teacher teacher) {
		this.teacherDAO.updateTeacher(teacher);
		return "redirect:/teacher/getAllTeacher.action";
	}

	// 显示全部数据
	@RequestMapping("getAllTeacher.action")
	public String getAllTeacher(String number, Map<String, Object> map) {
		List<Teacher> teacherList = new ArrayList<Teacher>();
		List<Teacher> tempList = new ArrayList<Teacher>();
		tempList = this.teacherDAO.getAllTeacher();
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
			Teacher teacher = tempList.get(i);
			teacherList.add(teacher);
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
			buffer.append("<a href=\"teacher/getAllTeacher.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append(
					"<a href=\"teacher/getAllTeacher.action?number=" + (Integer.parseInt(number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append(
					"<a href=\"teacher/getAllTeacher.action?number=" + (Integer.parseInt(number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"teacher/getAllTeacher.action?number=" + (maxPage - 1) + "\">尾页</a>");
		}
		html = buffer.toString();
		map.put("html", html);
		map.put("teacherList", teacherList);
		return "admin/listteacher";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryTeacherByCond.action")
	public String queryTeacherByCond(String cond, String name, Map<String, Object> map) {
		List<Teacher> teacherList = new ArrayList<Teacher>();
		Teacher teacher = new Teacher();
		if (cond != null) {
			if ("teachername".equals(cond)) {
				teacher.setTeachername(name);
				teacherList = this.teacherDAO.getTeacherByLike(teacher);
			}
			if ("image".equals(cond)) {
				teacher.setImage(name);
				teacherList = this.teacherDAO.getTeacherByLike(teacher);
			}
			if ("sex".equals(cond)) {
				teacher.setSex(name);
				teacherList = this.teacherDAO.getTeacherByLike(teacher);
			}
			if ("birthday".equals(cond)) {
				teacher.setBirthday(name);
				teacherList = this.teacherDAO.getTeacherByLike(teacher);
			}
			if ("contents".equals(cond)) {
				teacher.setContents(name);
				teacherList = this.teacherDAO.getTeacherByLike(teacher);
			}
		}
		map.put("teacherList", teacherList);
		return "admin/queryteacher";
	}

	// 按主键查询数据
	@RequestMapping("getTeacherById.action")
	public String getTeacherById(String id, Map<String, Object> map) {
		Teacher teacher = this.teacherDAO.getTeacherById(id);
		map.put("teacher", teacher);
		return "admin/editteacher";
	}

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

}
