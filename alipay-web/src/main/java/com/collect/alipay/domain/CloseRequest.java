package com.collect.alipay.domain;

import java.io.Serializable;

public class CloseRequest implements Serializable{

	private static final long serialVersionUID = 7110240299323777881L;
	
	/**
	 * 商户网站唯一订单号
	 */
	private String tradeNo;
	
	private String user;
	
	/**
	 * 备注
	 */
	private String remark;

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
