package com.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import com.entity.Course;

public class CourseDAO {
	// sqlSessionTemplate 注入 在applicationContext.xml里定义
	private SqlSessionTemplate sqlSessionTemplate;

	// 插入数据 调用entity包course.xml里的insertCourse配置
	public void insertCourse(Course course) {
		this.sqlSessionTemplate.insert("insertCourse", course);
	}

	// 更新数据 调用entity包course.xml里的updateCourse配置
	public void updateCourse(Course course) {
		this.sqlSessionTemplate.update("updateCourse", course);
	}

	// 删除数据 调用entity包course.xml里的deleteCourse配置
	public void deleteCourse(String courseid) {
		this.sqlSessionTemplate.delete("deleteCourse", courseid);
	}

	// 查询全部数据 调用entity包course.xml里的getAllCourse配置
	public List<Course> getAllCourse() {
		return this.sqlSessionTemplate.selectList("getAllCourse");
	}

	public List<Course> getCourseByNews() {
		return this.sqlSessionTemplate.selectList("getCourseByNews");
	}

	public List<Course> getCourseByHot() {
		return this.sqlSessionTemplate.selectList("getCourseByHot");
	}

	public List<Course> getCourseByCate(String cateid) {
		return this.sqlSessionTemplate.selectList("getCourseByCate", cateid);
	}

	// 按照Admin类里面的值精确查询 调用entity包course.xml里的getCourseByCond配置
	public List<Course> getCourseByCond(Course course) {
		return this.sqlSessionTemplate.selectList("getCourseByCond", course);
	}

	// 按照Course类里面的值模糊查询 调用entity包course.xml里的getCourseByLike配置
	public List<Course> getCourseByLike(Course course) {
		return this.sqlSessionTemplate.selectList("getCourseByLike", course);
	}

	// 按主键查询表返回单一的Course实例 调用entity包course.xml里的getCourseById配置
	public Course getCourseById(String courseid) {
		return this.sqlSessionTemplate.selectOne("getCourseById", courseid);
	}

	// IOC注入所需要的getter和setter
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

}
