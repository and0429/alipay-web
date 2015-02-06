package com.collect.alipay.service;

import java.io.Serializable;
import java.util.List;

/**
 * 业务类基础接口
 * 
 * @author zhangkai
 *
 */
public interface BaseService<T> {

	/**
	 * 保存
	 * 
	 * @param t
	 *            要保存的实体
	 */
	void save(T t);

	/**
	 * 根据Id删除实体
	 * 
	 * @param id
	 *            id
	 */
	void delete(Serializable id);

	/**
	 * 更新实体
	 * 
	 * @param t
	 *            待更新的实体
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
