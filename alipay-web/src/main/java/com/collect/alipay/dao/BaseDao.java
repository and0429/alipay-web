package com.collect.alipay.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 数据访问基础借口
 * 
 * @author zhangkai
 *
 * @param <T>
 */
public interface BaseDao<T> {

	/**
	 * 保存
	 * 
	 * @param t
	 *            要保存的实体
	 * @return 影响行数
	 */
	void save(T t);

	/**
	 * 根据Id删除实体
	 * 
	 * @param id
	 *            id
	 * @return 影响的行数
	 */
	void delete(Serializable id);

	/**
	 * 更新实体
	 * 
	 * @param t
	 *            待更新的实体
	 * @return 影响的行数
	 */
	void update(T t);

	/**
	 * 根据Id查询实体
	 * 
	 * @param id
	 *            要查询的Id
	 * @return 查到的实体， 没有查到返回null;
	 */
	T getById(Serializable id);

	/**
	 * 获取所有的实体
	 * 
	 * @return 查到的实体集合
	 */
	List<T> getAll();

}
