package com.collect.alipay.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.collect.alipay.domain.User;

/**
 * 用户相关的控制器
 * 
 * @author zhangkai
 *
 */
@Controller
@SessionAttributes("user")
public class LoginController {

	/**
	 * 登录方法处理
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, User user) {
		model.addAttribute("user", user);
		return "redirect:/user/users.do";
	}

	/**
	 * 注销
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout(Model model, HttpSession session) {
		session.invalidate();
		model.asMap().remove("user");
		return "redirect:/";
	}

}
