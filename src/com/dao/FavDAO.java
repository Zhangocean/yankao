package com.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import com.entity.Fav;

public class FavDAO {
	// sqlSessionTemplate 注入 在applicationContext.xml里定义
	private SqlSessionTemplate sqlSessionTemplate;

	// 插入数据 调用entity包fav.xml里的insertFav配置
	public void insertFav(Fav fav) {
		this.sqlSessionTemplate.insert("insertFav", fav);
	}

	// 更新数据 调用entity包fav.xml里的updateFav配置
	public void updateFav(Fav fav) {
		this.sqlSessionTemplate.update("updateFav", fav);
	}

	// 删除数据 调用entity包fav.xml里的deleteFav配置
	public void deleteFav(String favid) {
		this.sqlSessionTemplate.delete("deleteFav", favid);
	}

	// 查询全部数据 调用entity包fav.xml里的getAllFav配置
	public List<Fav> getAllFav() {
		return this.sqlSessionTemplate.selectList("getAllFav");
	}

	// 按照Admin类里面的值精确查询 调用entity包fav.xml里的getFavByCond配置
	public List<Fav> getFavByCond(Fav fav) {
		return this.sqlSessionTemplate.selectList("getFavByCond", fav);
	}

	// 按照Fav类里面的值模糊查询 调用entity包fav.xml里的getFavByLike配置
	public List<Fav> getFavByLike(Fav fav) {
		return this.sqlSessionTemplate.selectList("getFavByLike", fav);
	}

	// 按主键查询表返回单一的Fav实例 调用entity包fav.xml里的getFavById配置
	public Fav getFavById(String favid) {
		return this.sqlSessionTemplate.selectOne("getFavById", favid);
	}

	// IOC注入所需要的getter和setter
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

}
