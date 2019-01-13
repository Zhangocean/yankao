package com.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import com.entity.Admin;

public class AdminDAO {
	// sqlSessionTemplate 注入 在applicationContext.xml里定义
	private SqlSessionTemplate sqlSessionTemplate;

	// 插入数据 调用entity包admin.xml里的insertAdmin配置
	public void insertAdmin(Admin admin) {
		this.sqlSessionTemplate.insert("insertAdmin", admin);
	}

	// 更新数据 调用entity包admin.xml里的updateAdmin配置
	public void updateAdmin(Admin admin) {
		this.sqlSessionTemplate.update("updateAdmin", admin);
	}

	// 删除数据 调用entity包admin.xml里的deleteAdmin配置
	public void deleteAdmin(String adminid) {
		this.sqlSessionTemplate.delete("deleteAdmin", adminid);
	}

	// 查询全部数据 调用entity包admin.xml里的getAllAdmin配置
	public List<Admin> getAllAdmin() {
		return this.sqlSessionTemplate.selectList("getAllAdmin");
	}

	// 按照Admin类里面的值精确查询 调用entity包admin.xml里的getAdminByCond配置
	public List<Admin> getAdminByCond(Admin admin) {
		return this.sqlSessionTemplate.selectList("getAdminByCond", admin);
	}

	// 按照Admin类里面的值模糊查询 调用entity包admin.xml里的getAdminByLike配置
	public List<Admin> getAdminByLike(Admin admin) {
		return this.sqlSessionTemplate.selectList("getAdminByLike", admin);
	}

	// 按主键查询表返回单一的Admin实例 调用entity包admin.xml里的getAdminById配置
	public Admin getAdminById(String adminid) {
		return this.sqlSessionTemplate.selectOne("getAdminById", adminid);
	}

	// IOC注入所需要的getter和setter
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

}
