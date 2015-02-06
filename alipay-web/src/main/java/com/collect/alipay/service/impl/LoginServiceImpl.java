package com.collect.alipay.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.collect.alipay.dao.LoginDao;
import com.collect.alipay.domain.Login;
import com.collect.alipay.service.LoginService;

/**
 * 登录业务对象
 * 
 * @author zhangkai
 *
 */
@Named
public class LoginServiceImpl implements LoginService {
	
	@Inject
	private LoginDao loginDao;

	@Override
	public void save(Login t) {
		loginDao.save(t);
	}

	@Override
	public void delete(Serializable id) {
		loginDao.delete(id);
	}

	@Override
	public void update(Login t) {
		loginDao.update(t);
	}

	@Override
	public Login getById(Serializable id) {
		return loginDao.getById(id);
	}

	@Override
	public List<Login> getAll() {
		return loginDao.getAll();
	}

}
