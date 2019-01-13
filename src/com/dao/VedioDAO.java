package com.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import com.entity.Vedio;

public class VedioDAO {
	// sqlSessionTemplate 注入 在applicationContext.xml里定义
	private SqlSessionTemplate sqlSessionTemplate;

	// 插入数据 调用entity包vedio.xml里的insertVedio配置
	public void insertVedio(Vedio vedio) {
		this.sqlSessionTemplate.insert("insertVedio", vedio);
	}

	// 更新数据 调用entity包vedio.xml里的updateVedio配置
	public void updateVedio(Vedio vedio) {
		this.sqlSessionTemplate.update("updateVedio", vedio);
	}

	// 删除数据 调用entity包vedio.xml里的deleteVedio配置
	public void deleteVedio(String vedioid) {
		this.sqlSessionTemplate.delete("deleteVedio", vedioid);
	}

	// 查询全部数据 调用entity包vedio.xml里的getAllVedio配置
	public List<Vedio> getAllVedio() {
		return this.sqlSessionTemplate.selectList("getAllVedio");
	}

	// 按照Admin类里面的值精确查询 调用entity包vedio.xml里的getVedioByCond配置
	public List<Vedio> getVedioByCond(Vedio vedio) {
		return this.sqlSessionTemplate.selectList("getVedioByCond", vedio);
	}

	// 按照Vedio类里面的值模糊查询 调用entity包vedio.xml里的getVedioByLike配置
	public List<Vedio> getVedioByLike(Vedio vedio) {
		return this.sqlSessionTemplate.selectList("getVedioByLike", vedio);
	}

	// 按主键查询表返回单一的Vedio实例 调用entity包vedio.xml里的getVedioById配置
	public Vedio getVedioById(String vedioid) {
		return this.sqlSessionTemplate.selectOne("getVedioById", vedioid);
	}

	// IOC注入所需要的getter和setter
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

}
