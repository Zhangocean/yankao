package com.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import com.entity.Cate;

public class CateDAO {
	// sqlSessionTemplate 注入 在applicationContext.xml里定义
	private SqlSessionTemplate sqlSessionTemplate;

	// 插入数据 调用entity包cate.xml里的insertCate配置
	public void insertCate(Cate cate) {
		this.sqlSessionTemplate.insert("insertCate", cate);
	}

	// 更新数据 调用entity包cate.xml里的updateCate配置
	public void updateCate(Cate cate) {
		this.sqlSessionTemplate.update("updateCate", cate);
	}

	// 删除数据 调用entity包cate.xml里的deleteCate配置
	public void deleteCate(String cateid) {
		this.sqlSessionTemplate.delete("deleteCate", cateid);
	}

	// 查询全部数据 调用entity包cate.xml里的getAllCate配置
	public List<Cate> getAllCate() {
		return this.sqlSessionTemplate.selectList("getAllCate");
	}

	// 按照Admin类里面的值精确查询 调用entity包cate.xml里的getCateByCond配置
	public List<Cate> getCateByCond(Cate cate) {
		return this.sqlSessionTemplate.selectList("getCateByCond", cate);
	}

	// 按照Cate类里面的值模糊查询 调用entity包cate.xml里的getCateByLike配置
	public List<Cate> getCateByLike(Cate cate) {
		return this.sqlSessionTemplate.selectList("getCateByLike", cate);
	}

	// 按主键查询表返回单一的Cate实例 调用entity包cate.xml里的getCateById配置
	public Cate getCateById(String cateid) {
		return this.sqlSessionTemplate.selectOne("getCateById", cateid);
	}

	// IOC注入所需要的getter和setter
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

}
