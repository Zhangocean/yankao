package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Course;
import com.dao.CourseDAO;
import com.entity.Cate;
import com.entity.Teacher;
import com.util.VeDate;
import com.dao.CateDAO;
import com.dao.TeacherDAO;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/course")
public class CourseAction extends BaseAction {
	// 注入AdminDAO 并getter setter
	private CourseDAO courseDAO;
	private CateDAO cateDAO;
	private TeacherDAO teacherDAO;

	// 准备添加数据
	@RequestMapping("createCourse.action")
	public String createCourse(Map<String, Object> map) {
		List<Cate> cateList = this.cateDAO.getAllCate();
		map.put("cateList", cateList);
		List<Teacher> teacherList = this.teacherDAO.getAllTeacher();
		map.put("teacherList", teacherList);
		return "admin/addcourse";
	}

	// 添加数据
	@RequestMapping("addCourse.action")
	public String addCourse(Course course) {
		course.setAddtime(VeDate.getStringDateShort());
		course.setHits("0");
		this.courseDAO.insertCourse(course);
		return "redirect:/course/createCourse.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteCourse.action")
	public String deleteCourse(String id) {
		this.courseDAO.deleteCourse(id);
		return "redirect:/course/getAllCourse.action";
	}

	// 更新数据
	@RequestMapping("updateCourse.action")
	public String updateCourse(Course course) {
		this.courseDAO.updateCourse(course);
		return "redirect:/course/getAllCourse.action";
	}

	// 显示全部数据
	@RequestMapping("getAllCourse.action")
	public String getAllCourse(String number, Map<String, Object> map) {
		List<Course> courseList = new ArrayList<Course>();
		List<Course> tempList = new ArrayList<Course>();
		tempList = this.courseDAO.getAllCourse();
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
			Course course = tempList.get(i);
			courseList.add(course);
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
			buffer.append("<a href=\"course/getAllCourse.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append(
					"<a href=\"course/getAllCourse.action?number=" + (Integer.parseInt(number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append(
					"<a href=\"course/getAllCourse.action?number=" + (Integer.parseInt(number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"course/getAllCourse.action?number=" + (maxPage - 1) + "\">尾页</a>");
		}
		html = buffer.toString();
		map.put("html", html);
		map.put("courseList", courseList);
		return "admin/listcourse";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryCourseByCond.action")
	public String queryCourseByCond(String cond, String name, Map<String, Object> map) {
		List<Course> courseList = new ArrayList<Course>();
		Course course = new Course();
		if (cond != null) {
			if ("coursename".equals(cond)) {
				course.setCoursename(name);
				courseList = this.courseDAO.getCourseByLike(course);
			}
			if ("image".equals(cond)) {
				course.setImage(name);
				courseList = this.courseDAO.getCourseByLike(course);
			}
			if ("cateid".equals(cond)) {
				course.setCateid(name);
				courseList = this.courseDAO.getCourseByLike(course);
			}
			if ("teacherid".equals(cond)) {
				course.setTeacherid(name);
				courseList = this.courseDAO.getCourseByLike(course);
			}
			if ("contents".equals(cond)) {
				course.setContents(name);
				courseList = this.courseDAO.getCourseByLike(course);
			}
			if ("addtime".equals(cond)) {
				course.setAddtime(name);
				courseList = this.courseDAO.getCourseByLike(course);
			}
			if ("hits".equals(cond)) {
				course.setHits(name);
				courseList = this.courseDAO.getCourseByLike(course);
			}
		}
		map.put("courseList", courseList);
		return "admin/querycourse";
	}

	// 按主键查询数据
	@RequestMapping("getCourseById.action")
	public String getCourseById(String id, Map<String, Object> map) {
		Course course = this.courseDAO.getCourseById(id);
		map.put("course", course);
		List<Cate> cateList = this.cateDAO.getAllCate();
		map.put("cateList", cateList);
		List<Teacher> teacherList = this.teacherDAO.getAllTeacher();
		map.put("teacherList", teacherList);
		return "admin/editcourse";
	}

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public CateDAO getCateDAO() {
		return cateDAO;
	}

	public void setCateDAO(CateDAO cateDAO) {
		this.cateDAO = cateDAO;
	}

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}
}
