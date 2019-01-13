package com.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import com.entity.Teacher;

public class TeacherDAO {
	// sqlSessionTemplate 注入 在applicationContext.xml里定义
	private SqlSessionTemplate sqlSessionTemplate;

	// 插入数据 调用entity包teacher.xml里的insertTeacher配置
	public void insertTeacher(Teacher teacher) {
		this.sqlSessionTemplate.insert("insertTeacher", teacher);
	}

	// 更新数据 调用entity包teacher.xml里的updateTeacher配置
	public void updateTeacher(Teacher teacher) {
		this.sqlSessionTemplate.update("updateTeacher", teacher);
	}

	// 删除数据 调用entity包teacher.xml里的deleteTeacher配置
	public void deleteTeacher(String teacherid) {
		this.sqlSessionTemplate.delete("deleteTeacher", teacherid);
	}

	// 查询全部数据 调用entity包teacher.xml里的getAllTeacher配置
	public List<Teacher> getAllTeacher() {
		return this.sqlSessionTemplate.selectList("getAllTeacher");
	}

	public List<Teacher> getFrontTeacher() {
		return this.sqlSessionTemplate.selectList("getFrontTeacher");
	}

	// 按照Admin类里面的值精确查询 调用entity包teacher.xml里的getTeacherByCond配置
	public List<Teacher> getTeacherByCond(Teacher teacher) {
		return this.sqlSessionTemplate.selectList("getTeacherByCond", teacher);
	}

	// 按照Teacher类里面的值模糊查询 调用entity包teacher.xml里的getTeacherByLike配置
	public List<Teacher> getTeacherByLike(Teacher teacher) {
		return this.sqlSessionTemplate.selectList("getTeacherByLike", teacher);
	}

	// 按主键查询表返回单一的Teacher实例 调用entity包teacher.xml里的getTeacherById配置
	public Teacher getTeacherById(String teacherid) {
		return this.sqlSessionTemplate.selectOne("getTeacherById", teacherid);
	}

	// IOC注入所需要的getter和setter
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

}
