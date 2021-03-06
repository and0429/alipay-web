package com.collect.alipay.domain;

import java.io.Serializable;

public class CreateandpayResponse implements Serializable{

	private static final long serialVersionUID = -7155974910299559836L;
	
	/**
	 * 请求是否成功。请求成功不代表业务处理成功。
	 * T代表成功   F代表失败 
	 */
	private String success;
	
	/**
	 * 请求成功时,不存在本参 数; 请求失败时,本参数为错误 代码,参见“10.2 接入错 误码”和“10.3 系统错误 码”。
	 */
	private String error;

	/**
	 * 预下单处理结果响应码。SUCCESS:预下单成功   FAIL:预下单失败  UNKNOWN:结果未知
	 */
	private String resultCode;
	
	/**
	 * 对应商户网站的订单系统中的 唯一订单号,非支付宝交易号。需保证在商户网站中的唯一性。是请求时对应的参数,原样返回。
	 */
	private String outTradeNo;
	
	/**
	 * 支付宝交易号
	 */
	private String tradeNo;
	
	/**
	 * 买家支付 宝用户号
	 */
	private String buyerUserId;
	
	/**
	 * 买家支付 宝账号
	 */
	private String buyerLogonId;
	
	/**
	 * 详细错误码
	 */
	private String detailErrorCode;
	
	/**
	 * 详细错误 描述
	 */
	private String detailErrorDesc;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getBuyerUserId() {
		return buyerUserId;
	}

	public void setBuyerUserId(String buyerUserId) {
		this.buyerUserId = buyerUserId;
	}

	public String getBuyerLogonId() {
		return buyerLogonId;
	}

	public void setBuyerLogonId(String buyerLogonId) {
		this.buyerLogonId = buyerLogonId;
	}

	public String getDetailErrorCode() {
		return detailErrorCode;
	}

	public void setDetailErrorCode(String detailErrorCode) {
		this.detailErrorCode = detailErrorCode;
	}

	public String getDetailErrorDesc() {
		return detailErrorDesc;
	}

	public void setDetailErrorDesc(String detailErrorDesc) {
		this.detailErrorDesc = detailErrorDesc;
	}

}
