package com.collect.alipay.domain;
import java.io.Serializable;

public class RefundRequest implements Serializable{

	private static final long serialVersionUID = 7385475449335122764L;

	/**
	 * 商户网站唯一订单号
	 */
	private String tradeNo;
	
	/**
	 * 退款金额
	 */
	private String amount;
	
	private String outRequestNo;
	
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
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

	public String getOutRequestNo() {
		return outRequestNo;
	}

	public void setOutRequestNo(String outRequestNo) {
		this.outRequestNo = outRequestNo;
	}
}
