package com.collect.alipay.domain;

import java.io.Serializable;

public class QueryRequest implements Serializable{

	private static final long serialVersionUID = -8995367560341702235L;

	/**
	 * 商品唯一号
	 */
	private String tradeNo;

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
}
