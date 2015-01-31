package com.collect.alipay.service;

import com.collect.alipay.domain.CancelResponse;
import com.collect.alipay.domain.CloseResponse;
import com.collect.alipay.domain.CreateandpayResponse;
import com.collect.alipay.domain.PrecreateResponse;
import com.collect.alipay.domain.QueryResponse;
import com.collect.alipay.domain.RefundResponse;

public interface ParseResponseService {

	/**
	 * 解析查询返回结果
	 * @param xml
	 * @return
	 */
	public QueryResponse parseQueryResponse(String xml);
	
	/**
	 * 解析统一预下单返回结果
	 * @param xml
	 * @return
	 */
	public PrecreateResponse parsePrecreateResponse(String xml);
	
	public PrecreateResponse parsePrecreatePicResponse(String xml);
	
	public PrecreateResponse parsePrecreatePicArrayResponse(String xml);
	
	/**
	 * 解析统一预下单并支付返回结果
	 * @return
	 */
	public CreateandpayResponse parseCreateandpayResponse(String xml);
	
	/**
	 * 解析关闭返回结果
	 * @param xml
	 * @return
	 */
	public CloseResponse parseCloseResponse(String xml);
	
	/**
	 * 解析收单撤销接口
	 * @param xml
	 * @return
	 */
	public CancelResponse parseCancelResponse(String xml);
	
	/**
	 * 解析退款返回结果
	 * @param xml
	 * @return
	 */
	public RefundResponse parseRefundResponse(String xml);
	
}
