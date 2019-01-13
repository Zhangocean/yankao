package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.ArticleDAO;
import com.dao.BbsDAO;
import com.dao.CateDAO;
import com.dao.CourseDAO;
import com.dao.FavDAO;
import com.dao.FilesDAO;
import com.dao.RebbsDAO;
import com.dao.TeacherDAO;
import com.dao.TopicDAO;
import com.dao.UsersDAO;
import com.dao.VedioDAO;
import com.dao.XuankeDAO;
import com.entity.Article;
import com.entity.Bbs;
import com.entity.Cate;
import com.entity.Course;
import com.entity.Fav;
import com.entity.Files;
import com.entity.Rebbs;
import com.entity.Teacher;
import com.entity.Topic;
import com.entity.Users;
import com.entity.Vedio;
import com.entity.Xuanke;

import java.util.HashMap;
import com.util.VeDate;

import sun.util.resources.cldr.shi.CalendarData_shi_Latn_MA;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/index")
public class IndexAction extends BaseAction {

	private BbsDAO bbsDAO;
	private UsersDAO usersDAO;
	private CateDAO cateDAO;
	private FavDAO favDAO;
	private RebbsDAO rebbsDAO;
	private ArticleDAO articleDAO;
	private CourseDAO courseDAO;
	private TeacherDAO teacherDAO;
	private TopicDAO topicDAO;
	private VedioDAO vedioDAO;
	private FilesDAO filesDAO;
	private XuankeDAO xuankeDAO;

	

	// 公共方法 提供公共查询数据
	private void front() {
		getRequest().setAttribute("title", "研考教育管理信息系统");
		List<Cate> cateList = this.cateDAO.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		List<Course> hotList = this.courseDAO.getCourseByHot();
		this.getRequest().setAttribute("hotList", hotList);
	}

	// 首页显示的控制器
	@RequestMapping("index.action")
	public String index() {
		this.front();
		List<Cate> cateList = this.cateDAO.getAllCate();
		List<Cate> frontList = new ArrayList<Cate>();
		for (Cate cate : cateList) {
			List<Course> courseList = this.courseDAO.getCourseByCate(cate.getCateid());
			cate.setCourseList(courseList);
			frontList.add(cate);
		}
		this.getRequest().setAttribute("frontList", frontList);
		List<Teacher> teacherList = this.teacherDAO.getFrontTeacher();
		this.getRequest().setAttribute("newsList", teacherList);
		List<Article> articleList = this.articleDAO.getFrontArticle();
		this.getRequest().setAttribute("articleList", articleList);
		return "users/index";
	}

	// 按分类查询
	@RequestMapping("cate.action")
	public String cate(String id) {
		this.front();
		Course course = new Course();
		course.setCateid(id);
		List<Course> courseList = this.courseDAO.getCourseByCond(course);
		this.getRequest().setAttribute("courseList", courseList);
		return "users/list";
	}
	
	
	//选课
	@RequestMapping("xuanke.action")
	public String  xuanke() {
		this.front();
	//	List<Course> courseList = this.courseDAO.getAllCourse();
		
		List <Xuanke> xuankeList=this.xuankeDAO.getAllXuanke();
		
		this.getRequest().setAttribute("xuankeList", xuankeList);
		
		return "users/xuanke";
		
	}
	
	//测试页面0课程热度图
	@RequestMapping("ceshi.action")
	public String  ceshi() {
		this.front();
		List<Course> courseList = this.courseDAO.getAllCourse();
//		String[] strings = new String[courseList.size()];
//		String[] strings2 = new String[courseList.size()];
//		for(int i = 0; i < courseList.size(); i++) {
////			strings[i] = 
////			strings2.add(dCourse.getHits());
//		}
//		Map<String, String[]> map = new HashMap<String, String[]>();
//		map.put("names",strings );
////		map.put("hits", value)
		this.getRequest().setAttribute("courseList", courseList);
		
		return "users/ceshi";
		
	}
	
	//测试页面1学生男女图
	@RequestMapping("ceshi1.action")
	public String  ceshi1() {
		this.front();
		List<Users> usersList = this.usersDAO.getAllUsers();
//		String[] strings = new String[courseList.size()];
//		String[] strings2 = new String[courseList.size()];
//		for(int i = 0; i < courseList.size(); i++) {
////			strings[i] = 
////			strings2.add(dCourse.getHits());
//		}
//		Map<String, String[]> map = new HashMap<String, String[]>();
//		map.put("names",strings );
////		map.put("hits", value)
		this.getRequest().setAttribute("usersList", usersList);
		return "users/ceshi1";
		
	}
	
	//测试页面0课程热度图
	@RequestMapping("ceshi2.action")
	public String  ceshi2() {
		this.front();
		
		List<Users> usersList = this.usersDAO.getAllUsers();
		
//		String[] strings = new String[courseList.size()];
//		String[] strings2 = new String[courseList.size()];
//		for(int i = 0; i < courseList.size(); i++) {
////			strings[i] = 
////			strings2.add(dCourse.getHits());
//		}
//		Map<String, String[]> map = new HashMap<String, String[]>();
//		map.put("names",strings );
////		map.put("hits", value)
		this.getRequest().setAttribute("usersList", usersList);
		return "users/ceshi2";
		
	}
	
	
	
	
	

	// 全部商品
	@RequestMapping("all.action")
	public String all(String number) {
		this.front();
		List<Course> courseList = this.courseDAO.getAllCourse();
		this.getRequest().setAttribute("courseList", courseList);
		return "users/list";
	}

	// 新品上架
	@RequestMapping("news.action")
	public String news(String number) {
		this.front();
		List<Course> courseList = this.courseDAO.getCourseByNews();
		this.getRequest().setAttribute("courseList", courseList);
		return "users/list";
	}

	// 查询商品
	@RequestMapping("query.action")
	public String query(String name) {
		this.front();
		Course course = new Course();
		course.setCoursename(name);
		List<Course> courseList = this.courseDAO.getCourseByLike(course);
		this.getRequest().setAttribute("courseList", courseList);
		return "users/list";
	}

	// 商品详情
	@RequestMapping("coursedetail.action")
	public String coursedetail(String id) {
		this.front();
		Course course = this.courseDAO.getCourseById(id);
		course.setHits("" + (Integer.parseInt(course.getHits()) + 1));
		this.courseDAO.updateCourse(course);
		this.getRequest().setAttribute("course", course);
		Files f = new Files();
		f.setCourseid(id);
		List<Files> filesList = this.filesDAO.getFilesByCond(f);
		this.getRequest().setAttribute("filesList", filesList);
		Vedio v = new Vedio();
		v.setCourseid(id);
		List<Vedio> vedioList = this.vedioDAO.getVedioByCond(v);
		this.getRequest().setAttribute("vedioList", vedioList);
		Topic t = new Topic();
		t.setCourseid(id);
		List<Topic> topicList = this.topicDAO.getTopicByCond(t);
		this.getRequest().setAttribute("topicList", topicList);
		this.getRequest().setAttribute("tnum", topicList.size());
		
        List <Xuanke> xuankeList=this.xuankeDAO.getAllXuanke();
		
		this.getRequest().setAttribute("xuankeList", xuankeList);
		
		return "users/detail2";
	}
	
	
	// 商品详情
	@RequestMapping("coursedetail1.action")
	public String coursedetail1(String id) {
		this.front();
		Course course = this.courseDAO.getCourseById(id);
		course.setHits("" + (Integer.parseInt(course.getHits()) + 1));
		this.courseDAO.updateCourse(course);
		this.getRequest().setAttribute("course", course);
		Files f = new Files();
		f.setCourseid(id);
		List<Files> filesList = this.filesDAO.getFilesByCond(f);
		this.getRequest().setAttribute("filesList", filesList);
		Vedio v = new Vedio();
		v.setCourseid(id);
		List<Vedio> vedioList = this.vedioDAO.getVedioByCond(v);
		this.getRequest().setAttribute("vedioList", vedioList);
		Topic t = new Topic();
		t.setCourseid(id);
		List<Topic> topicList = this.topicDAO.getTopicByCond(t);
		this.getRequest().setAttribute("topicList", topicList);
		this.getRequest().setAttribute("tnum", topicList.size());
		return "users/detail";
	}
	
	
	

	@RequestMapping("addTopic.action")
	public String addTopic() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Topic topic = new Topic();
		topic.setTopicid(VeDate.getStringDatex());
		topic.setAddtime(VeDate.getStringDateShort());
		topic.setContents(this.getRequest().getParameter("contents"));
		topic.setCourseid(this.getRequest().getParameter("courseid"));
		topic.setNum(this.getRequest().getParameter("num"));
		topic.setUsersid(userid);
		this.topicDAO.insertTopic(topic);
		return "redirect:/index/coursedetail.action?id=" + topic.getCourseid();
	}

	// 视频
	@RequestMapping("play.action")
	public String play(String id) {
		this.front();
		Vedio vedio = this.vedioDAO.getVedioById(id);
		vedio.setHits("" + (Integer.parseInt(vedio.getHits()) + 1));
		this.vedioDAO.updateVedio(vedio);
		this.getRequest().setAttribute("vedio", vedio);
		return "users/play";
	}

	// 教师
	@RequestMapping("teacher.action")
	public String teacher() {
		this.front();
		List<Teacher> teacherList = this.teacherDAO.getAllTeacher();
		this.getRequest().setAttribute("teacherList", teacherList);
		return "users/teacher";
	}

	@RequestMapping("teacherdetail.action")
	public String teacherdetail(String id) {
		this.front();
		Teacher teacher = this.teacherDAO.getTeacherById(id);
		this.getRequest().setAttribute("teacher", teacher);
		return "users/teacherdetail";
	}

	// 公告
	@RequestMapping("article.action")
	public String article() {
		this.front();
		List<Article> articleList = this.articleDAO.getAllArticle();
		this.getRequest().setAttribute("articleList", articleList);
		return "users/article";
	}

	@RequestMapping("read.action")
	public String read(String id) {
		this.front();
		Article article = this.articleDAO.getArticleById(id);
		article.setHits("" + (Integer.parseInt(article.getHits()) + 1));
		this.articleDAO.updateArticle(article);
		this.getRequest().setAttribute("article", article);
		return "users/read";
	}

	// 添加收藏
	@RequestMapping("addfav.action")
	public String addfav() {
		this.front();
		if (getRequest().getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) getRequest().getSession().getAttribute("userid");
		Fav fav = new Fav();
		fav.setFavid(VeDate.getStringDatex());
		fav.setAddtime(VeDate.getStringDateShort());
		fav.setCourseid(getRequest().getParameter("id"));
		fav.setUsersid(userid);
		this.favDAO.insertFav(fav);
		return "redirect:/index/myfav.action";
	}
	

	

	// 我的收藏
	@RequestMapping("myfav.action")
	public String myfav() {
		this.front();
		if (getRequest().getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) getRequest().getSession().getAttribute("userid");
		Fav fav = new Fav();
		fav.setUsersid(userid);
		List<Fav> favList = this.favDAO.getFavByCond(fav);
		this.getRequest().setAttribute("favList", favList);
		return "users/myfav";
	}

	// 删除收藏
	@RequestMapping("deletefav.action")
	public String deletefav() {
		this.front();
		if (getRequest().getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.favDAO.deleteFav(getRequest().getParameter("id"));
		return "redirect:/index/myfav.action";
	}

	// 准备登录
	@RequestMapping("preLogin.action")
	public String prelogin() {
		this.front();
		
		return "users/login";
		
	}

	// 用户登录
	@RequestMapping("login.action")
	public String login() {
		this.front();
		String username = getRequest().getParameter("username");
		String password = getRequest().getParameter("password");
		Users u = new Users();
		u.setUsername(username);
		List<Users> usersList = this.usersDAO.getUsersByCond(u);
		if (usersList.size() == 0) {
			getRequest().getSession().setAttribute("message", "用户名不存在");
			return "redirect:/index/preLogin.action";
			//return "users/login";
		} else {
			Users users = usersList.get(0);
			if (password.equals(users.getPassword())) {
				getRequest().getSession().setAttribute("userid", users.getUsersid());
				getRequest().getSession().setAttribute("username", users.getUsername());
				getRequest().getSession().setAttribute("users", users);
			} else {
				getRequest().getSession().setAttribute("message", "密码错误");
				return "redirect:/index/preLogin.action";
				
				//return "users/login";
			}
		}
		return "redirect:/index/usercenter.action";
	}

	// 准备注册
	@RequestMapping("preReg.action")
	public String preReg() {
		this.front();
		return "users/register";
	}

	// 用户注册
	@RequestMapping("register.action")
	public String register(Users users) {
		this.front();
		Users u = new Users();
		u.setUsername(users.getUsername());
		List<Users> usersList = this.usersDAO.getUsersByCond(users);
		if (usersList.size() == 0) {
			users.setUsersid(VeDate.getStringDatex());
			users.setRegdate(VeDate.getStringDateShort());
			this.usersDAO.insertUsers(users);
		} else {
			getRequest().setAttribute("message", "用户名已存在");
			return "redirect:/index/preReg.action";
		}
		return "redirect:/index/preLogin.action";
	}

	// 退出登录
	@RequestMapping("exit.action")
	public String exit() {
		this.front();
		getRequest().getSession().removeAttribute("userid");
		getRequest().getSession().removeAttribute("username");
		getRequest().getSession().removeAttribute("users");
		return "users/login";
	}

	// 用户中心
	@RequestMapping("usercenter.action")
	public String usercenter() {
		this.front();
		if (getRequest().getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/usercenter";
	}

	// 用户中心
	@RequestMapping("userinfo.action")
	public String userinfo() {
		this.front();
		if (getRequest().getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Users users = this.usersDAO.getUsersById(userid);
		getRequest().getSession().setAttribute("users", users);
		return "users/userinfo";
	}

	// 修改个人信息
	@RequestMapping("personal.action")
	public String personal(Users users) {
		this.front();
		if (getRequest().getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.usersDAO.updateUsers(users);
		getRequest().getSession().setAttribute("users", users);
		return "redirect:/index/usercenter.action";
	}

	// 准备修改密码
	@RequestMapping("prePwd.action")
	public String prePwd() {
		this.front();
		if (getRequest().getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/editpwd";
	}

	// 修改密码
	@RequestMapping("editpwd.action")
	public String editpwd() {
		this.front();
		if (getRequest().getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) getRequest().getSession().getAttribute("userid");
		String password = getRequest().getParameter("password");
		String repassword = getRequest().getParameter("repassword");
		Users users = this.usersDAO.getUsersById(userid);
		if (password.equals(users.getPassword())) {
			users.setPassword(repassword);
			this.usersDAO.updateUsers(users);
		} else {
			getRequest().setAttribute("message", "旧密码错误");
			return "redirect:/index/prePwd.action";
		}
		return "redirect:/index/prePwd.action";
	}

	// 留言板
	@RequestMapping("bbs.action")
	public String bbs() {
		this.front();
		List<Bbs> bbsList = this.bbsDAO.getAllBbs();
		this.getRequest().setAttribute("bbsList", bbsList);
		return "users/bbs";
	}

	// 发布留言
	@RequestMapping("addbbs.action")
	public String addbbs() {
		this.front();
		if (getRequest().getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) getRequest().getSession().getAttribute("userid");
		Bbs bbs = new Bbs();
		bbs.setBbsid(VeDate.getStringDatex());
		bbs.setAddtime(VeDate.getStringDate());
		bbs.setContents(getRequest().getParameter("contents"));
		bbs.setHits("0");
		bbs.setRepnum("0");
		bbs.setTitle(getRequest().getParameter("title"));
		bbs.setUsersid(userid);
		this.bbsDAO.insertBbs(bbs);
		return "redirect:/index/bbs.action";
	}

	// 查看留言
	@RequestMapping("readbbs.action")
	public String readbbs() {
		this.front();
		Bbs bbs = this.bbsDAO.getBbsById(getRequest().getParameter("id"));
		bbs.setHits("" + (Integer.parseInt(bbs.getHits()) + 1));
		this.bbsDAO.updateBbs(bbs);
		this.getRequest().setAttribute("bbs", bbs);
		Rebbs rebbs = new Rebbs();
		rebbs.setBbsid(bbs.getBbsid());
		List<Rebbs> rebbsList = this.rebbsDAO.getRebbsByCond(rebbs);
		this.getRequest().setAttribute("rebbsList", rebbsList);
		return "users/readbbs";
	}

	// 回复留言
	@RequestMapping("rebbs.action")
	public String rebbs() {
		this.front();
		if (getRequest().getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) getRequest().getSession().getAttribute("userid");
		Rebbs rebbs = new Rebbs();
		rebbs.setRebbsid(VeDate.getStringDatex());
		rebbs.setAddtime(VeDate.getStringDate());
		rebbs.setContents(getRequest().getParameter("contents"));
		rebbs.setBbsid(getRequest().getParameter("bbsid"));
		rebbs.setUsersid(userid);
		this.rebbsDAO.insertRebbs(rebbs);
		Bbs bbs = this.bbsDAO.getBbsById(rebbs.getBbsid());
		bbs.setRepnum("" + (Integer.parseInt(bbs.getRepnum()) + 1));
		this.bbsDAO.updateBbs(bbs);
		String path = "redirect:/index/readbbs.action?id=" + bbs.getBbsid();
		return path;
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

	public CateDAO getCateDAO() {
		return cateDAO;
	}

	public void setCateDAO(CateDAO cateDAO) {
		this.cateDAO = cateDAO;
	}

	public FavDAO getFavDAO() {
		return favDAO;
	}

	public void setFavDAO(FavDAO favDAO) {
		this.favDAO = favDAO;
	}

	public RebbsDAO getRebbsDAO() {
		return rebbsDAO;
	}

	public void setRebbsDAO(RebbsDAO rebbsDAO) {
		this.rebbsDAO = rebbsDAO;
	}

	public ArticleDAO getArticleDAO() {
		return articleDAO;
	}

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
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

	public TopicDAO getTopicDAO() {
		return topicDAO;
	}

	public void setTopicDAO(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}

	public VedioDAO getVedioDAO() {
		return vedioDAO;
	}

	public void setVedioDAO(VedioDAO vedioDAO) {
		this.vedioDAO = vedioDAO;
	}

	public FilesDAO getFilesDAO() {
		return filesDAO;
	}

	public void setFilesDAO(FilesDAO filesDAO) {
		this.filesDAO = filesDAO;
	}
	public XuankeDAO getXuankeDAO() {
		return xuankeDAO;
	}

	public void setXuankeDAO(XuankeDAO xuankeDAO) {
		this.xuankeDAO = xuankeDAO;
	}

}
