package com.collect.alipay.domain;

import java.io.Serializable;

/**
 * longin
 * 
 * @author zhangkai
 * 
 */
public class Login implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String passcode;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

}
