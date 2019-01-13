package com.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import com.entity.Users;

public class UsersDAO {
	// sqlSessionTemplate 注入 在applicationContext.xml里定义
	private SqlSessionTemplate sqlSessionTemplate;

	// 插入数据 调用entity包users.xml里的insertUsers配置
	public void insertUsers(Users users) {
		this.sqlSessionTemplate.insert("insertUsers", users);
	}

	// 更新数据 调用entity包users.xml里的updateUsers配置
	public void updateUsers(Users users) {
		this.sqlSessionTemplate.update("updateUsers", users);
	}

	// 删除数据 调用entity包users.xml里的deleteUsers配置
	public void deleteUsers(String usersid) {
		this.sqlSessionTemplate.delete("deleteUsers", usersid);
	}

	// 查询全部数据 调用entity包users.xml里的getAllUsers配置
	public List<Users> getAllUsers() {
		return this.sqlSessionTemplate.selectList("getAllUsers");
	}

	// 按照Admin类里面的值精确查询 调用entity包users.xml里的getUsersByCond配置
	public List<Users> getUsersByCond(Users users) {
		return this.sqlSessionTemplate.selectList("getUsersByCond", users);
	}

	// 按照Users类里面的值模糊查询 调用entity包users.xml里的getUsersByLike配置
	public List<Users> getUsersByLike(Users users) {
		return this.sqlSessionTemplate.selectList("getUsersByLike", users);
	}

	// 按主键查询表返回单一的Users实例 调用entity包users.xml里的getUsersById配置
	public Users getUsersById(String usersid) {
		return this.sqlSessionTemplate.selectOne("getUsersById", usersid);
	}

	// IOC注入所需要的getter和setter
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

}
