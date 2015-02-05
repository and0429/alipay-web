package com.collect.alipay.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户处理类
 * 
 * @author zhangkai
 * 
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public Object users() {

		return null;

	}
}
