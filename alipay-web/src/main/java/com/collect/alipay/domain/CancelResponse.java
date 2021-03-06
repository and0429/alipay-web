package com.collect.alipay.domain;

import java.io.Serializable;

public class CancelResponse implements Serializable{

	private static final long serialVersionUID = 3566534827824104918L;
	
	/**
	 * 请求是否成功。请求成功不代表业务处理成功。
	 * T代表成功   F代表失败 
	 */
	private String success;
	
	/**
	 * 错误代码
	 */
	private String error;

	/**
	 * 查询处理结果响应码。
      * SUCCESS:查询成功
      * FAIL:查询失败
      * PROCESS_EXCEPTION:处理异常
	 */
	private String resultCode;
	
	/**
	 * 详细错误码
	 * 当 result_code 响应码为 SUCCESS 时,不返回该参数。
	 */
	private String detailErrorCode;
	
	/**
	 * 详细错误描述
	 * 当 result_code 响应码为 SUCCESS 时,不返回该参数。
	 */
	private String detailErrorDesc;
	
	/**
	 * 商户网站唯一订单号
	 */
	private String outTradeNo;
	
	/**
	 * 该交易在支付宝系统中的交易流水号。
	 */
	private String tradeNo;
	
	/**
	 * 对撤销失败的情况下,是否可以继续发起撤销请求的建议。  
	 * Y:可继续发起撤销请求;   
	 * N:不可继续发起撤销请求,即后续的撤销请求也不会成功。
	 */
	private String retryFlag;

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

	public String getRetryFlag() {
		return retryFlag;
	}

	public void setRetryFlag(String retryFlag) {
		this.retryFlag = retryFlag;
	}

}
