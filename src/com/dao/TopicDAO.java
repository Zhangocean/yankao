package com.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import com.entity.Topic;

public class TopicDAO {
	// sqlSessionTemplate 注入 在applicationContext.xml里定义
	private SqlSessionTemplate sqlSessionTemplate;

	// 插入数据 调用entity包topic.xml里的insertTopic配置
	public void insertTopic(Topic topic) {
		this.sqlSessionTemplate.insert("insertTopic", topic);
	}

	// 更新数据 调用entity包topic.xml里的updateTopic配置
	public void updateTopic(Topic topic) {
		this.sqlSessionTemplate.update("updateTopic", topic);
	}

	// 删除数据 调用entity包topic.xml里的deleteTopic配置
	public void deleteTopic(String topicid) {
		this.sqlSessionTemplate.delete("deleteTopic", topicid);
	}

	// 查询全部数据 调用entity包topic.xml里的getAllTopic配置
	public List<Topic> getAllTopic() {
		return this.sqlSessionTemplate.selectList("getAllTopic");
	}

	// 按照Admin类里面的值精确查询 调用entity包topic.xml里的getTopicByCond配置
	public List<Topic> getTopicByCond(Topic topic) {
		return this.sqlSessionTemplate.selectList("getTopicByCond", topic);
	}

	// 按照Topic类里面的值模糊查询 调用entity包topic.xml里的getTopicByLike配置
	public List<Topic> getTopicByLike(Topic topic) {
		return this.sqlSessionTemplate.selectList("getTopicByLike", topic);
	}

	// 按主键查询表返回单一的Topic实例 调用entity包topic.xml里的getTopicById配置
	public Topic getTopicById(String topicid) {
		return this.sqlSessionTemplate.selectOne("getTopicById", topicid);
	}

	// IOC注入所需要的getter和setter
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

}
