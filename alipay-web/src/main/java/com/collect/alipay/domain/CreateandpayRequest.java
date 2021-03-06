package com.collect.alipay.domain;

import java.io.Serializable;

public class CreateandpayRequest implements Serializable{

	private static final long serialVersionUID = 8778411778045811813L;

	/**
	 * 支付宝合作商户网站唯一订单号
	 */
	private String tradeNo;
	
	/**
	 * 商品的标题/交易标题/订单 标题/订单关键字等。该参数最长为 128 个汉字。
	 */
	private String subject;
	
	/**
	 * 用来区分是哪种业务类型的下单。目前支持如下 6 类:  
	 * SOUNDWAVE_PAY_O FFLINE:声波支付  
	 * FINGERPRINT_FAST_PAY:指纹支付  
	 * BARCODE_PAY_OFFLINE:条码支付  
	 * TB_SOUNDWAVE_OFFLINE:淘宝声波支付
	 * TB_BARCODE_OFFLINE:淘宝条码支付 
	 * MEMBER_CARD_QR_ OFFLINE:会员卡支付 
	 * FUND_TRADE_FAST_PAY:预授权产品
	 */
	private String productCode;
	
	/**
	 * 该笔订单的资金总额,取值 范围[0.01,100000000],精确 到小数点后 2 位。
	 */
	private String total;
	
	/**
	 * 支付宝客户端扫描的动态条码
	 */
	private String dynamicId;
	
	/**
	 * wave_code 声波 qr_code 二维码　bar_code 条码
	 */
	private String dynamicIdType;
	
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

	public String getDynamicId() {
		return dynamicId;
	}

	public void setDynamicId(String dynamicId) {
		this.dynamicId = dynamicId;
	}

	public String getDynamicIdType() {
		return dynamicIdType;
	}

	public void setDynamicIdType(String dynamicIdType) {
		this.dynamicIdType = dynamicIdType;
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
