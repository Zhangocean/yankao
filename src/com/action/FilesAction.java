package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Files;
import com.util.VeDate;
import com.dao.FilesDAO;
import com.entity.Course;
import com.dao.CourseDAO;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/files")
public class FilesAction extends BaseAction {
	// 注入AdminDAO 并getter setter
	private FilesDAO filesDAO;
	private CourseDAO courseDAO;

	// 准备添加数据
	@RequestMapping("createFiles.action")
	public String createFiles(Map<String, Object> map) {
		List<Course> courseList = this.courseDAO.getAllCourse();
		map.put("courseList", courseList);
		return "admin/addfiles";
	}

	// 添加数据
	@RequestMapping("addFiles.action")
	public String addFiles(Files files) {
		files.setAddtime(VeDate.getStringDateShort());
		this.filesDAO.insertFiles(files);
		return "redirect:/files/createFiles.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteFiles.action")
	public String deleteFiles(String id) {
		this.filesDAO.deleteFiles(id);
		return "redirect:/files/getAllFiles.action";
	}

	// 更新数据
	@RequestMapping("updateFiles.action")
	public String updateFiles(Files files) {
		this.filesDAO.updateFiles(files);
		return "redirect:/files/getAllFiles.action";
	}

	// 显示全部数据
	@RequestMapping("getAllFiles.action")
	public String getAllFiles(String number, Map<String, Object> map) {
		List<Files> filesList = new ArrayList<Files>();
		List<Files> tempList = new ArrayList<Files>();
		tempList = this.filesDAO.getAllFiles();
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
			Files files = tempList.get(i);
			filesList.add(files);
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
			buffer.append("<a href=\"files/getAllFiles.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"files/getAllFiles.action?number=" + (Integer.parseInt(number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"files/getAllFiles.action?number=" + (Integer.parseInt(number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"files/getAllFiles.action?number=" + (maxPage - 1) + "\">尾页</a>");
		}
		html = buffer.toString();
		map.put("html", html);
		map.put("filesList", filesList);
		return "admin/listfiles";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryFilesByCond.action")
	public String queryFilesByCond(String cond, String name, Map<String, Object> map) {
		List<Files> filesList = new ArrayList<Files>();
		Files files = new Files();
		if (cond != null) {
			if ("filesname".equals(cond)) {
				files.setFilesname(name);
				filesList = this.filesDAO.getFilesByLike(files);
			}
			if ("courseid".equals(cond)) {
				files.setCourseid(name);
				filesList = this.filesDAO.getFilesByLike(files);
			}
			if ("url".equals(cond)) {
				files.setUrl(name);
				filesList = this.filesDAO.getFilesByLike(files);
			}
			if ("addtime".equals(cond)) {
				files.setAddtime(name);
				filesList = this.filesDAO.getFilesByLike(files);
			}
		}
		map.put("filesList", filesList);
		return "admin/queryfiles";
	}

	// 按主键查询数据
	@RequestMapping("getFilesById.action")
	public String getFilesById(String id, Map<String, Object> map) {
		Files files = this.filesDAO.getFilesById(id);
		map.put("files", files);
		List<Course> courseList = this.courseDAO.getAllCourse();
		map.put("courseList", courseList);
		return "admin/editfiles";
	}

	public FilesDAO getFilesDAO() {
		return filesDAO;
	}

	public void setFilesDAO(FilesDAO filesDAO) {
		this.filesDAO = filesDAO;
	}

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
}
