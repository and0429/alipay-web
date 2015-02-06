/**
 * 
 */
package com.collect.alipay.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;

import com.collect.alipay.dao.BaseDao;

/**
 * 数据访问基础类
 * 
 * @author zhangkai
 *
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	@Inject
	@Named("sqlSession")
	protected SqlSession session;

	protected Class<T> clazz;

	/**
	 * Constructor
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		if (clazz == null) {
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Type[] types = pt.getActualTypeArguments();
			clazz = (Class<T>) types[0];
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.collect.alipay.dao.BaseDao#save(java.lang.Object)
	 */
	@Override
	public void save(T t) {
		session.insert(clazz.getName() + ".save", t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.collect.alipay.dao.BaseDao#delete(java.io.Serializable)
	 */
	@Override
	public void delete(Serializable id) {
		session.delete(clazz.getName() + ".delete", id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.collect.alipay.dao.BaseDao#update(java.lang.Object)
	 */
	@Override
	public void update(T t) {
		session.update(clazz.getName() + ".update", t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.collect.alipay.dao.BaseDao#getById(java.io.Serializable)
	 */
	@Override
	public T getById(Serializable id) {
		return session.selectOne(clazz.getName() + ".getById", id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.collect.alipay.dao.BaseDao#getAll()
	 */
	@Override
	public List<T> getAll() {
		return session.selectList(clazz.getName() + ".getAll");
	}

}
