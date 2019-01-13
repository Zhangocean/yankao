package com.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import com.entity.Rebbs;

public class RebbsDAO {
	// sqlSessionTemplate 注入 在applicationContext.xml里定义
	private SqlSessionTemplate sqlSessionTemplate;

	// 插入数据 调用entity包rebbs.xml里的insertRebbs配置
	public void insertRebbs(Rebbs rebbs) {
		this.sqlSessionTemplate.insert("insertRebbs", rebbs);
	}

	// 更新数据 调用entity包rebbs.xml里的updateRebbs配置
	public void updateRebbs(Rebbs rebbs) {
		this.sqlSessionTemplate.update("updateRebbs", rebbs);
	}

	// 删除数据 调用entity包rebbs.xml里的deleteRebbs配置
	public void deleteRebbs(String rebbsid) {
		this.sqlSessionTemplate.delete("deleteRebbs", rebbsid);
	}

	// 查询全部数据 调用entity包rebbs.xml里的getAllRebbs配置
	public List<Rebbs> getAllRebbs() {
		return this.sqlSessionTemplate.selectList("getAllRebbs");
	}

	// 按照Admin类里面的值精确查询 调用entity包rebbs.xml里的getRebbsByCond配置
	public List<Rebbs> getRebbsByCond(Rebbs rebbs) {
		return this.sqlSessionTemplate.selectList("getRebbsByCond", rebbs);
	}

	// 按照Rebbs类里面的值模糊查询 调用entity包rebbs.xml里的getRebbsByLike配置
	public List<Rebbs> getRebbsByLike(Rebbs rebbs) {
		return this.sqlSessionTemplate.selectList("getRebbsByLike", rebbs);
	}

	// 按主键查询表返回单一的Rebbs实例 调用entity包rebbs.xml里的getRebbsById配置
	public Rebbs getRebbsById(String rebbsid) {
		return this.sqlSessionTemplate.selectOne("getRebbsById", rebbsid);
	}

	// IOC注入所需要的getter和setter
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

}
