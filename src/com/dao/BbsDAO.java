package com.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import com.entity.Bbs;

public class BbsDAO {
	// sqlSessionTemplate 注入 在applicationContext.xml里定义
	private SqlSessionTemplate sqlSessionTemplate;

	// 插入数据 调用entity包bbs.xml里的insertBbs配置
	public void insertBbs(Bbs bbs) {
		this.sqlSessionTemplate.insert("insertBbs", bbs);
	}

	// 更新数据 调用entity包bbs.xml里的updateBbs配置
	public void updateBbs(Bbs bbs) {
		this.sqlSessionTemplate.update("updateBbs", bbs);
	}

	// 删除数据 调用entity包bbs.xml里的deleteBbs配置
	public void deleteBbs(String bbsid) {
		this.sqlSessionTemplate.delete("deleteBbs", bbsid);
	}

	// 查询全部数据 调用entity包bbs.xml里的getAllBbs配置
	public List<Bbs> getAllBbs() {
		return this.sqlSessionTemplate.selectList("getAllBbs");
	}

	// 按照Admin类里面的值精确查询 调用entity包bbs.xml里的getBbsByCond配置
	public List<Bbs> getBbsByCond(Bbs bbs) {
		return this.sqlSessionTemplate.selectList("getBbsByCond", bbs);
	}

	// 按照Bbs类里面的值模糊查询 调用entity包bbs.xml里的getBbsByLike配置
	public List<Bbs> getBbsByLike(Bbs bbs) {
		return this.sqlSessionTemplate.selectList("getBbsByLike", bbs);
	}

	// 按主键查询表返回单一的Bbs实例 调用entity包bbs.xml里的getBbsById配置
	public Bbs getBbsById(String bbsid) {
		return this.sqlSessionTemplate.selectOne("getBbsById", bbsid);
	}

	// IOC注入所需要的getter和setter
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

}
