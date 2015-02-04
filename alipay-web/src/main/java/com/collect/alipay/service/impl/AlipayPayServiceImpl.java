package com.collect.alipay.service.impl;

import java.util.Date;
import java.util.Map;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.BindingType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.collect.alipay.domain.Alilog;
import com.collect.alipay.domain.CancelRequest;
import com.collect.alipay.domain.CancelResponse;
import com.collect.alipay.domain.ChannelType;
import com.collect.alipay.domain.CloseRequest;
import com.collect.alipay.domain.CloseResponse;
import com.collect.alipay.domain.CreateandpayRequest;
import com.collect.alipay.domain.CreateandpayResponse;
import com.collect.alipay.domain.OperType;
import com.collect.alipay.domain.PrecreateRequest;
import com.collect.alipay.domain.PrecreateResponse;
import com.collect.alipay.domain.QueryRequest;
import com.collect.alipay.domain.QueryResponse;
import com.collect.alipay.domain.RefundRequest;
import com.collect.alipay.domain.RefundResponse;
import com.collect.alipay.service.AlilogService;
import com.collect.alipay.service.AlipayPayService;
import com.collect.alipay.service.ParseResponseService;
import com.collect.alipay.util.AlipayConfig;
import com.collect.alipay.util.AlipaySubmit;
import com.collect.alipay.util.UUIDUtil;

/**
 * 
 * @author xu
 *
 */
@WebService(serviceName = "alipayService", targetNamespace = "http://www.alipay.com", endpointInterface = "com.collect.alipay.service.AlipayPayService")
@SOAPBinding(style = Style.RPC)
@BindingType(value = javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class AlipayPayServiceImpl implements AlipayPayService {

	private static final Log logger = LogFactory.getLog(AlipayPayServiceImpl.class);

	private Map<String, AlipayConfig> alipayConfigs;

	private ParseResponseService parseResponseService;

	private AlilogService alilogService;

	private Boolean logMock = true;

	private AlipaySubmit getAlipaySubmit(String key) {
		AlipayConfig alipayConfig = alipayConfigs.get(key);
		AlipaySubmit alipaySubmit = new AlipaySubmit(alipayConfig);
		return alipaySubmit;
	}

	private AlipayConfig getAlipayConfig(String key) {
		return alipayConfigs.get(key);
	}

	@Override
	public QueryResponse alipayQuery(QueryRequest queryRequest) {
		logger.info("alipay query,tradeNo is ... ... ..." + queryRequest.getTradeNo());
		AlipaySubmit alipaySubmit = getAlipaySubmit(queryRequest.getTradeNo().substring(0, 3));
		Map<String, String> parameter = alipaySubmit.getParmMap("alipay.acquire.query");
		parameter.put("out_trade_no", queryRequest.getTradeNo());
		String reslut = null;
		try {
			reslut = alipaySubmit.buildRequest("", "", parameter);
			logger.info("alipay query result,tradeNo is:" + queryRequest.getTradeNo() + ":" + reslut);
		} catch (Exception e) {
			e.printStackTrace();
		}

		QueryResponse queryResponse = parseResponseService.parseQueryResponse(reslut);
		logger.info("alipay query parseResponse success,tradeNo is:" + queryRequest.getTradeNo());
		return queryResponse;
	}

	@Override
	public PrecreateResponse alipayPrecreate(PrecreateRequest precreateRequest) {
		logger.info("alipay precreate,tradeNo is ... ... ..." + precreateRequest.getTradeNo());
		AlipaySubmit alipaySubmit = getAlipaySubmit(precreateRequest.getTradeNo().substring(0, 3));
		Map<String, String> parameter = alipaySubmit.getParmMap("alipay.acquire.precreate");
		parameter.put("extend_params", getAlipayConfig(precreateRequest.getTradeNo().substring(0, 3)).getExtendParam());
		parameter.put("out_trade_no", precreateRequest.getTradeNo());
		parameter.put("subject", precreateRequest.getSubject());
		parameter.put("total_fee", precreateRequest.getTotal());
		parameter.put("product_code", precreateRequest.getProductCode());
		String reslut = null;
		try {
			reslut = alipaySubmit.buildRequest("", "", parameter);
			logger.info("alipay precreate result,tradeNo is:" + precreateRequest.getTradeNo() + ":" + reslut);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrecreateResponse precreateResponse = parseResponseService.parsePrecreateResponse(reslut);
		logger.info("alipay precreate parseResponse success,tradeNo is:" + precreateRequest.getTradeNo());
		if (getLogMock()) {
			Alilog alilog = new Alilog();
			alilog.setOper(OperType.PRECREATE);
			alilog.setOperChannel(ChannelType.ALIPAY);
			alilog.setOperDate(new Date());
			alilog.setOperUser(precreateRequest.getUser());
			alilog.setRemark(precreateRequest.getRemark());
			alilog.setId(UUIDUtil.randomUUID());

			alilogService.save(alilog);
		}

		return precreateResponse;
	}

	@Override
	public CreateandpayResponse alipayCreateandPay(CreateandpayRequest createandpayRequest) {
		logger.info("alipay createandpayRequest,tradeNo is ... ... ..." + createandpayRequest.getTradeNo());
		AlipaySubmit alipaySubmit = getAlipaySubmit(createandpayRequest.getTradeNo().substring(0, 3));
		Map<String, String> parameter = alipaySubmit.getParmMap("alipay.acquire.createandpay");
		parameter.put("extend_params", getAlipayConfig(createandpayRequest.getTradeNo().substring(0, 3)).getExtendParam());
		parameter.put("out_trade_no", createandpayRequest.getTradeNo());
		parameter.put("subject", createandpayRequest.getSubject());
		parameter.put("total_fee", createandpayRequest.getTotal());
		parameter.put("product_code", createandpayRequest.getProductCode());
		parameter.put("dynamic_id_type", createandpayRequest.getDynamicIdType());
		parameter.put("dynamic_id", createandpayRequest.getDynamicId());
		String reslut = null;
		try {
			reslut = alipaySubmit.buildRequest("", "", parameter);
			logger.info("alipay CreateandPay result,tradeNo is:" + createandpayRequest.getTradeNo() + ":" + reslut);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CreateandpayResponse createandpayResponse = parseResponseService.parseCreateandpayResponse(reslut);
		logger.info("alipay CreateandPay parseResponse success,tradeNo is:" + createandpayRequest.getTradeNo());
		if (getLogMock()) {
			Alilog alilog = new Alilog();
			alilog.setOper(OperType.CREATEPAY);
			alilog.setOperChannel(ChannelType.ALIPAY);
			alilog.setOperDate(new Date());
			alilog.setOperUser(createandpayRequest.getUser());
			alilog.setRemark(createandpayRequest.getRemark());
			alilog.setId(UUIDUtil.randomUUID());

			alilogService.save(alilog);
		}

		return createandpayResponse;
	}

	@Override
	public CloseResponse alipayClose(CloseRequest closeRequest) {
		logger.info("alipay close,tradeNo is ... ... ..." + closeRequest.getTradeNo());
		AlipaySubmit alipaySubmit = getAlipaySubmit(closeRequest.getTradeNo().substring(0, 3));
		Map<String, String> parameter = alipaySubmit.getParmMap("alipay.acquire.close");
		parameter.put("out_trade_no", closeRequest.getTradeNo());
		String reslut = null;
		try {
			reslut = alipaySubmit.buildRequest("", "", parameter);
			logger.info("alipay close result,tradeNo is:" + closeRequest.getTradeNo() + ":" + reslut);
		} catch (Exception e) {
			e.printStackTrace();
		}

		CloseResponse closeResponse = parseResponseService.parseCloseResponse(reslut);
		if (logMock) {
			Alilog alilog = new Alilog();
			alilog.setOper(OperType.CLOSE);
			alilog.setOperChannel(ChannelType.ALIPAY);
			alilog.setOperDate(new Date());
			alilog.setOperUser(closeRequest.getUser());
			alilog.setRemark(closeRequest.getRemark());
			alilog.setId(UUIDUtil.randomUUID());

			alilogService.save(alilog);
		}

		return closeResponse;

	}

	@Override
	public CancelResponse alipayCancel(CancelRequest cancelRequest) {
		logger.info("alipay cancel,tradeNo is ... ... ..." + cancelRequest.getTradeNo());
		AlipaySubmit alipaySubmit = getAlipaySubmit(cancelRequest.getTradeNo().substring(0, 3));
		Map<String, String> parameter = alipaySubmit.getParmMap("alipay.acquire.cancel");
		parameter.put("out_trade_no", cancelRequest.getTradeNo());
		String reslut = null;
		try {
			reslut = alipaySubmit.buildRequest("", "", parameter);
			logger.info("alipay cancel result,tradeNo is:" + cancelRequest.getTradeNo() + ":" + reslut);
		} catch (Exception e) {
			e.printStackTrace();
		}

		CancelResponse cancelResponse = parseResponseService.parseCancelResponse(reslut);

		if (logMock) {
			Alilog alilog = new Alilog();
			alilog.setOper(OperType.CANCEL);
			alilog.setOperChannel(ChannelType.ALIPAY);
			alilog.setOperDate(new Date());
			alilog.setOperUser(cancelRequest.getUser());
			alilog.setRemark(cancelRequest.getRemark());
			alilog.setId(UUIDUtil.randomUUID());

			alilogService.save(alilog);
		}

		return cancelResponse;
	}

	@Override
	public RefundResponse alipayRefund(RefundRequest refundRequest) {
		logger.info("alipay refund,tradeNo is ... ... ..." + refundRequest.getTradeNo());
		logger.info("alipay refund,amount is ... ... ..." + refundRequest.getAmount());
		AlipaySubmit alipaySubmit = getAlipaySubmit(refundRequest.getTradeNo().substring(0, 3));
		Map<String, String> parameter = alipaySubmit.getParmMap("alipay.acquire.refund");
		parameter.put("out_trade_no", refundRequest.getTradeNo());
		parameter.put("refund_amount", refundRequest.getAmount());
		parameter.put("out_request_no", refundRequest.getOutRequestNo());
		String reslut = null;
		try {
			reslut = alipaySubmit.buildRequest("", "", parameter);
			logger.info("alipay refund result,tradeNo is:" + refundRequest.getTradeNo() + ":" + reslut);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RefundResponse refundResponse = parseResponseService.parseRefundResponse(reslut);
		if (getLogMock()) {
			Alilog alilog = new Alilog();
			alilog.setOper(OperType.REFUND);
			alilog.setOperChannel(ChannelType.ALIPAY);
			alilog.setOperDate(new Date());
			alilog.setOperUser(refundRequest.getUser());
			alilog.setRemark(refundRequest.getRemark());
			alilog.setId(UUIDUtil.randomUUID());

			alilogService.save(alilog);
		}
		return refundResponse;
	}

	public void setParseResponseService(ParseResponseService parseResponseService) {
		this.parseResponseService = parseResponseService;
	}

	public AlilogService getAlipayLogService() {
		return alilogService;
	}

	public void setAlipayLogService(AlilogService alipayLogService) {
		this.alilogService = alipayLogService;
	}

	@Override
	public PrecreateResponse alipayPrecreatePic(PrecreateRequest precreateRequest) {
		logger.info("alipay alipayPrecreatePic,tradeNo is ... ... ..." + precreateRequest.getTradeNo());
		AlipaySubmit alipaySubmit = getAlipaySubmit(precreateRequest.getTradeNo().substring(0, 3));
		Map<String, String> parameter = alipaySubmit.getParmMap("alipay.acquire.precreate");
		parameter.put("extend_params", getAlipayConfig(precreateRequest.getTradeNo().substring(0, 3)).getExtendParam());
		parameter.put("out_trade_no", precreateRequest.getTradeNo());
		parameter.put("subject", precreateRequest.getSubject());
		parameter.put("total_fee", precreateRequest.getTotal());
		parameter.put("product_code", precreateRequest.getProductCode());
		String reslut = null;
		try {
			reslut = alipaySubmit.buildRequest("", "", parameter);
			logger.info("alipay precreate result,tradeNo is:" + precreateRequest.getTradeNo() + ":" + reslut);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrecreateResponse precreateResponse = parseResponseService.parsePrecreatePicResponse(reslut);
		logger.info("alipay precreate parseResponse success,tradeNo is:" + precreateRequest.getTradeNo());
		if (getLogMock()) {
			Alilog alilog = new Alilog();
			alilog.setOper(OperType.PRECREATE);
			alilog.setOperChannel(ChannelType.ALIPAY);
			alilog.setOperDate(new Date());
			alilog.setOperUser(precreateRequest.getUser());
			alilog.setRemark(precreateRequest.getRemark());
			alilog.setId(UUIDUtil.randomUUID());

			alilogService.save(alilog);
		}
		return precreateResponse;
	}

	@Override
	public PrecreateResponse alipayPrecreatePicArray(PrecreateRequest precreateRequest) {
		AlipaySubmit alipaySubmit = getAlipaySubmit(precreateRequest.getTradeNo().substring(0, 3));
		Map<String, String> parameter = alipaySubmit.getParmMap("alipay.acquire.precreate");
		parameter.put("extend_params", getAlipayConfig(precreateRequest.getTradeNo().substring(0, 3)).getExtendParam());
		parameter.put("out_trade_no", precreateRequest.getTradeNo());
		parameter.put("subject", precreateRequest.getSubject());
		parameter.put("total_fee", precreateRequest.getTotal());
		parameter.put("product_code", precreateRequest.getProductCode());
		String reslut = null;
		try {
			reslut = alipaySubmit.buildRequest("", "", parameter);
			logger.info("alipay precreate result,tradeNo is:" + precreateRequest.getTradeNo() + ":" + reslut);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrecreateResponse precreateResponse = parseResponseService.parsePrecreatePicArrayResponse(reslut);
		logger.info("alipay precreate parseResponse success,tradeNo is:" + precreateRequest.getTradeNo());
		if (getLogMock()) {
			Alilog alilog = new Alilog();
			alilog.setOper(OperType.PRECREATE);
			alilog.setOperChannel(ChannelType.ALIPAY);
			alilog.setOperDate(new Date());
			alilog.setOperUser(precreateRequest.getUser());
			alilog.setRemark(precreateRequest.getRemark());
			alilog.setId(UUIDUtil.randomUUID());

			alilogService.save(alilog);
		}
		return precreateResponse;
	}

	public Boolean getLogMock() {
		return logMock;
	}

	public void setLogMock(Boolean logMock) {
		this.logMock = logMock;
	}

	public Map<String, AlipayConfig> getAlipayConfigs() {
		return alipayConfigs;
	}

	public void setAlipayConfigs(Map<String, AlipayConfig> alipayConfigs) {
		this.alipayConfigs = alipayConfigs;
	}

}
