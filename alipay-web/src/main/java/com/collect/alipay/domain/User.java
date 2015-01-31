package com.collect.alipay.domain;

import java.io.Serializable;

/**
 * 用户模型
 * 
 * @author zhangkai
 * 
 */
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String passcode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "User [username=" + username + ", passcode=" + passcode + "]";
	}

}
