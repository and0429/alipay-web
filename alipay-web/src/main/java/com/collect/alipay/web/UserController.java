package com.collect.alipay.web;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collect.alipay.domain.User;
import com.collect.alipay.service.UserService;
import com.collect.alipay.util.UUIDUtil;

/**
 * 用户处理类
 * 
 * @author zhangkai
 * 
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Inject
	private UserService userService;

	/**
	 * 查询所有列表
	 * 
	 * @return 列表对象
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public Object users() {
		return userService.getAll();
	}

	/**
	 * 添加一个实体
	 * 
	 * @param user
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(User user) {

		user.setId(UUIDUtil.randomUUID());
			
		userService.save(user);
	}
}
