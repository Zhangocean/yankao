package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.CourseDAO;
import com.dao.RoomDAO;
import com.dao.TeacherDAO;
import com.dao.XuankeDAO;
import com.entity.Cate;
import com.entity.Course;
import com.entity.Room;
import com.entity.Teacher;
import com.entity.Xuanke;
import com.util.VeDate;

//定义为控制器
@Controller
//设置路径
@RequestMapping("/xuanke")
public class XuankeAction extends BaseAction{
	private CourseDAO courseDAO;
	private TeacherDAO teacherDAO;
	private XuankeDAO xuankeDAO;
	private RoomDAO roomDAO;
	
	// 更新课程
			@RequestMapping("updateXuanke.action")
			public String updateXuanke(Xuanke xuanke ) {
				Xuanke xuanke2 = (Xuanke) getSession().getAttribute("xuanke");
				this.xuankeDAO.updateXuanke(xuanke2);
				return "redirect:/xuanke/kebiao.action";
			}	
	
	
	

		// 准备添加课程
		@RequestMapping("createXuanke.action")
		public String createXuanke(Map<String, Object> map) {
			List<Xuanke> xuankeList = this.xuankeDAO.getAllXuanke();
			map.put("xuankeList", xuankeList);
			List<Teacher> teacherList = this.teacherDAO.getAllTeacher();
			map.put("teacherList", teacherList);
			
			List<Course> courseList = this.courseDAO.getAllCourse();
			map.put("courseList", courseList);
			
			List<Room> roomList = this.roomDAO.getAllRoom();
			map.put("roomList", roomList);
			
			return "admin/addxuanke";
		}

		// 添加数据
		@RequestMapping("insertXuanke.action")
		public String insertXuanke(Xuanke xuanke) {
			
			List <Xuanke> xuankeList=this.xuankeDAO.getAllXuanke();
			for(Xuanke xt:xuankeList) {
				if(((Integer.parseInt(xuanke.getXuanke_yz()))==(Integer.parseInt(xt.getXuanke_yz())))&&(Integer.parseInt((xuanke.getXuanke_xz()))==(Integer.parseInt(xt.getXuanke_xz())))) {
					getSession().setAttribute("xuanke", xuanke);
					return "redirect:/xuanke/updateXuanke.action";
				}
				
			}
			this.xuankeDAO.insertXuanke(xuanke);
			return "redirect:/xuanke/kebiao.action";
		}
	
		// 显示课表
		@RequestMapping("kebiao.action")
		public String kebiao() {
			
			List <Xuanke> xuankeList=this.xuankeDAO.getAllXuanke();
			this.getRequest().setAttribute("xuankeList", xuankeList);
			return "admin/xuanke";
		}
		
		//删除操作
		@RequestMapping("deleteXuanke.action")
		public String deleteXuanke(String id) {
			id = getRequest().getParameter("id");
			this.xuankeDAO.deleteXuanke(id);
			//System.out.println("***************************************"+id);
			return "redirect:/xuanke/kebiao.action";
		}
		

	
	public CourseDAO getCourseDAO() {
		return courseDAO;
	}
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}
	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}
	   public XuankeDAO getXuankeDAO() {
			return xuankeDAO;
		}
		public void setXuankeDAO(XuankeDAO xuankeDAO) {
			this.xuankeDAO = xuankeDAO;
		}
		public RoomDAO getRoomDAO() {
			return roomDAO;
		}

		public void setRoomDAO(RoomDAO roomDAO) {
			this.roomDAO = roomDAO;
		}
		

}
