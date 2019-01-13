package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.entity.Cate;
import com.entity.Room;


public class RoomDAO {
	// sqlSessionTemplate 注入 在applicationContext.xml里定义
			private SqlSessionTemplate sqlSessionTemplate;

			// 插入数据 调用entity包room.xml里的insertRoom配置
			public void insertRoom(Room room) {
				this.sqlSessionTemplate.insert("insertRoom", room);
			}
			
			// 查询全部数据 调用entity包cate.xml里的getAllCate配置
			public List<Room> getAllRoom() {
				return this.sqlSessionTemplate.selectList("getAllRoom");
			}
			
			//跟新教室
			public void updateRoom(Room room) {
				this.sqlSessionTemplate.update("updateRoom", room);
			}
			
			// 按主键查询表返回单一的Room实例 调用entity包cate.xml里的getRoomById配置
			public Room getRoomById(String room_id) {
				return this.sqlSessionTemplate.selectOne("getRoomById", room_id);
			}
			//删除
			
			public void deleteRoom(String room_id) {
				this.sqlSessionTemplate.delete("deleteRoom", room_id);
			}
			
		
			

			// IOC注入所需要的getter和setter
			public SqlSessionTemplate getSqlSessionTemplate() {
				return sqlSessionTemplate;
			}

			public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
				this.sqlSessionTemplate = sqlSessionTemplate;
			}

}
