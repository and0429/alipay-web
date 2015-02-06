package com.collect.alipay.service.impl;

import static org.apache.log4j.Logger.getLogger;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.collect.alipay.dao.AlilogDao;
import com.collect.alipay.domain.Alilog;
import com.collect.alipay.service.AlilogService;

/**
 * 支付日志业务类实现
 * 
 * @author zhangkai
 *
 */
@Named("alipayLogService")
public class AlilogServiceImpl implements AlilogService {

	@Inject
	private AlilogDao alilogDao;

	@Override
	public void save(Alilog alilog) {
		getLogger(this.getClass()).debug("add log... ... ...");
		alilogDao.save(alilog);
	}

	@Override
	public void delete(Serializable id) {
		alilogDao.delete(id);
	}

	@Override
	public void update(Alilog t) {
		alilogDao.update(t);
	}

	@Override
	public Alilog getById(Serializable id) {
		return alilogDao.getById(id);
	}

	@Override
	public List<Alilog> getAll() {
		return alilogDao.getAll();
	}
}
