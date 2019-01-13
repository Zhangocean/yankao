package com.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import com.entity.Files;

public class FilesDAO {
	// sqlSessionTemplate 注入 在applicationContext.xml里定义
	private SqlSessionTemplate sqlSessionTemplate;

	// 插入数据 调用entity包files.xml里的insertFiles配置
	public void insertFiles(Files files) {
		this.sqlSessionTemplate.insert("insertFiles", files);
	}

	// 更新数据 调用entity包files.xml里的updateFiles配置
	public void updateFiles(Files files) {
		this.sqlSessionTemplate.update("updateFiles", files);
	}

	// 删除数据 调用entity包files.xml里的deleteFiles配置
	public void deleteFiles(String filesid) {
		this.sqlSessionTemplate.delete("deleteFiles", filesid);
	}

	// 查询全部数据 调用entity包files.xml里的getAllFiles配置
	public List<Files> getAllFiles() {
		return this.sqlSessionTemplate.selectList("getAllFiles");
	}

	// 按照Admin类里面的值精确查询 调用entity包files.xml里的getFilesByCond配置
	public List<Files> getFilesByCond(Files files) {
		return this.sqlSessionTemplate.selectList("getFilesByCond", files);
	}

	// 按照Files类里面的值模糊查询 调用entity包files.xml里的getFilesByLike配置
	public List<Files> getFilesByLike(Files files) {
		return this.sqlSessionTemplate.selectList("getFilesByLike", files);
	}

	// 按主键查询表返回单一的Files实例 调用entity包files.xml里的getFilesById配置
	public Files getFilesById(String filesid) {
		return this.sqlSessionTemplate.selectOne("getFilesById", filesid);
	}

	// IOC注入所需要的getter和setter
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

}
