package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Topic;
import com.dao.TopicDAO;
import com.entity.Users;
import com.entity.Course;
import com.dao.UsersDAO;
import com.dao.CourseDAO;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/topic")
public class TopicAction extends BaseAction {
	// 注入AdminDAO 并getter setter
	private TopicDAO topicDAO;
	private UsersDAO usersDAO;
	private CourseDAO courseDAO;

	// 准备添加数据
	@RequestMapping("createTopic.action")
	public String createTopic(Map<String, Object> map) {
		List<Users> usersList = this.usersDAO.getAllUsers();
		map.put("usersList", usersList);
		List<Course> courseList = this.courseDAO.getAllCourse();
		map.put("courseList", courseList);
		return "admin/addtopic";
	}

	// 添加数据
	@RequestMapping("addTopic.action")
	public String addTopic(Topic topic) {
		this.topicDAO.insertTopic(topic);
		return "redirect:/topic/createTopic.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteTopic.action")
	public String deleteTopic(String id) {
		this.topicDAO.deleteTopic(id);
		return "redirect:/topic/getAllTopic.action";
	}

	// 更新数据
	@RequestMapping("updateTopic.action")
	public String updateTopic(Topic topic) {
		this.topicDAO.updateTopic(topic);
		return "redirect:/topic/getAllTopic.action";
	}

	// 显示全部数据
	@RequestMapping("getAllTopic.action")
	public String getAllTopic(String number, Map<String, Object> map) {
		List<Topic> topicList = new ArrayList<Topic>();
		List<Topic> tempList = new ArrayList<Topic>();
		tempList = this.topicDAO.getAllTopic();
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
			Topic topic = tempList.get(i);
			topicList.add(topic);
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
			buffer.append("<a href=\"topic/getAllTopic.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append("<a href=\"topic/getAllTopic.action?number=" + (Integer.parseInt(number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append("<a href=\"topic/getAllTopic.action?number=" + (Integer.parseInt(number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (maxPage <= (Integer.parseInt(number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"topic/getAllTopic.action?number=" + (maxPage - 1) + "\">尾页</a>");
		}
		html = buffer.toString();
		map.put("html", html);
		map.put("topicList", topicList);
		return "admin/listtopic";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryTopicByCond.action")
	public String queryTopicByCond(String cond, String name, Map<String, Object> map) {
		List<Topic> topicList = new ArrayList<Topic>();
		Topic topic = new Topic();
		if (cond != null) {
			if ("usersid".equals(cond)) {
				topic.setUsersid(name);
				topicList = this.topicDAO.getTopicByLike(topic);
			}
			if ("courseid".equals(cond)) {
				topic.setCourseid(name);
				topicList = this.topicDAO.getTopicByLike(topic);
			}
			if ("num".equals(cond)) {
				topic.setNum(name);
				topicList = this.topicDAO.getTopicByLike(topic);
			}
			if ("contents".equals(cond)) {
				topic.setContents(name);
				topicList = this.topicDAO.getTopicByLike(topic);
			}
			if ("addtime".equals(cond)) {
				topic.setAddtime(name);
				topicList = this.topicDAO.getTopicByLike(topic);
			}
		}
		map.put("topicList", topicList);
		return "admin/querytopic";
	}

	// 按主键查询数据
	@RequestMapping("getTopicById.action")
	public String getTopicById(String id, Map<String, Object> map) {
		Topic topic = this.topicDAO.getTopicById(id);
		map.put("topic", topic);
		List<Users> usersList = this.usersDAO.getAllUsers();
		map.put("usersList", usersList);
		List<Course> courseList = this.courseDAO.getAllCourse();
		map.put("courseList", courseList);
		return "admin/edittopic";
	}

	public TopicDAO getTopicDAO() {
		return topicDAO;
	}

	public void setTopicDAO(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
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
