package com.collect.alipay.util;

import java.io.Serializable;

/**
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 */

public class AlipayConfig implements Serializable{
	

	private static final long serialVersionUID = 4314836483167984028L;

	/**
	 * 合作身份者ID，以2088开头由16位纯数字组成的字符串
	 */
	private String partner;
	
	/**
	 * 商户的私钥
	 */
	private String key;

	/**
	 * 字符编码格式 目前支持 gbk 或 utf-8
	 */
	private String charset;
	
	/**
	 * 签名方式 MD5
	 */
	private String signType;
	
	/**
	 * 支付宝支付网关
	 */
	private String getWay;
	
	/**
	 * 公用业务扩展信息
	 */
	private String extendParam;

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getGetWay() {
		return getWay;
	}

	public void setGetWay(String getWay) {
		this.getWay = getWay;
	}

	public String getExtendParam() {
		return extendParam;
	}

	public void setExtendParam(String extendParam) {
		this.extendParam = extendParam;
	}
	
}
