package com.collect.alipay.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户处理类
 * 
 * @author zhangkai
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "users", method = RequestMethod.GET)
	public String users() {
		return "user/users";
	}

}
