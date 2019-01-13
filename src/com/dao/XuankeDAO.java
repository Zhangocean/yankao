package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.entity.Course;
import com.entity.Room;
import com.entity.Xuanke;

public class XuankeDAO {
	
	// sqlSessionTemplate 注入 在applicationContext.xml里定义
		private SqlSessionTemplate sqlSessionTemplate;

	// 查询全部数据 调用entity包xuanke.xml里的getAllXuanke配置
		public List<Xuanke> getAllXuanke() {
			return this.sqlSessionTemplate.selectList("getAllXuanke");
		}
	// 插入数据 调用entity包xaunke.xml里的insertCourse配置
		public void insertXuanke(Xuanke xuanke) {
			this.sqlSessionTemplate.insert("insertXuanke", xuanke);
		}
		
		
		//删除
		
		public void deleteXuanke(String xuanke_id) {
			this.sqlSessionTemplate.delete("deleteXuanke", xuanke_id);
		}
		
		//跟新
		public void updateXuanke(Xuanke xuanke) {
			this.sqlSessionTemplate.update("updateXuanke", xuanke);
		}
		
		// IOC注入所需要的getter和setter
		public SqlSessionTemplate getSqlSessionTemplate() {
			return sqlSessionTemplate;
		}

		public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
			this.sqlSessionTemplate = sqlSessionTemplate;
		}

}
