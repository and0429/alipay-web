package com.collect.alipay.domain;

public class OperType {

	/**
	 * 预下单
	 */
	public static final Integer PRECREATE = 1;
	
	/**
	 * 统一预下单并支付
	 */
	public static final Integer CREATEPAY = 2;
	
	/**
	 * 关闭
	 */
	public static final Integer CLOSE = 3;
	
	/**
	 * 撤销
	 */
	public static final Integer CANCEL = 4;

	/**
	 * 退款
	 */
	public static final Integer REFUND = 5;
	
}
