package com.collect.alipay.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.collect.alipay.dao.UserDao;
import com.collect.alipay.domain.User;
import com.collect.alipay.service.UserService;

/**
 * 用户业务实现
 * 
 * @author zhangkai
 *
 */
@Named
public class UserServiceImpl implements UserService {

	@Inject
	private UserDao userDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.collect.alipay.service.BaseService#save(java.lang.Object)
	 */
	@Override
	public void save(User user) {
		userDao.save(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.collect.alipay.service.BaseService#delete(java.io.Serializable)
	 */
	@Override
	public void delete(Serializable id) {
		userDao.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.collect.alipay.service.BaseService#update(java.lang.Object)
	 */
	@Override
	public void update(User user) {
		userDao.update(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.collect.alipay.service.BaseService#getById(java.io.Serializable)
	 */
	@Override
	public User getById(Serializable id) {
		return userDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.collect.alipay.service.BaseService#getAll()
	 */
	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

}
