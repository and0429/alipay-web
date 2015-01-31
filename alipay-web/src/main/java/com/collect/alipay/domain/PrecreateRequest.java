package com.collect.alipay.domain;

import java.io.Serializable;

public class PrecreateRequest implements Serializable{

	private static final long serialVersionUID = 7878395726773602593L;

	/**
	 * 支付宝合作商户网站唯一订单号
	 */
	private String tradeNo;
	
	/**
	 * 商品的标题/交易标题/订单 标题/订单关键字等。该参数最长为 128 个汉字。
	 */
	private String subject;
	
	/**
	 * 目前只支持 QR_CODE_OFFLINE(二维码支付)。
	 */
	private String productCode;
	
	/**
	 * 该笔订单的资金总额,取值 范围[0.01,100000000],精确 到小数点后 2 位。
	 */
	private String total;
	
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
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
