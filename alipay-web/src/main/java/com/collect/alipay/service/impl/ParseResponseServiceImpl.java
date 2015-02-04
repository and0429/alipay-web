package com.collect.alipay.service.impl;

import java.io.IOException;

import javax.inject.Named;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import com.collect.alipay.domain.CancelResponse;
import com.collect.alipay.domain.CloseResponse;
import com.collect.alipay.domain.CreateandpayResponse;
import com.collect.alipay.domain.PrecreateResponse;
import com.collect.alipay.domain.QueryResponse;
import com.collect.alipay.domain.RefundResponse;
import com.collect.alipay.service.ParseResponseService;
import com.collect.alipay.util.ImageRequestUtil;
import com.collect.alipay.util.XmlUtil;

/**
 * 
 * @author zhangkai
 *
 */
@Named("parseResponseService")
public class ParseResponseServiceImpl implements ParseResponseService {

	private String imagePath = "/Users/xzy_del/tools/image";
	
	private String getNodeText(Element root, String path) {
		Node node = root.selectSingleNode(path);
		if (node != null) {
			return node.getText();
		}
		return null;
	}

	@Override
	public QueryResponse parseQueryResponse(String xml) {
		QueryResponse queryResponse = new QueryResponse();
		Document document = XmlUtil.getDocument(xml);
		Element root = document.getRootElement();
		queryResponse.setSuccess(getNodeText(root, "is_success"));
		queryResponse.setError(getNodeText(root, "error"));
		queryResponse.setResultCode(getNodeText(root,"response/alipay/result_code"));
		queryResponse.setOutTradeNo(getNodeText(root,"response/alipay/out_trade_no"));
		queryResponse.setPartner(getNodeText(root, "response/alipay/partner"));
		queryResponse.setTradeNo(getNodeText(root, "response/alipay/trade_no"));
		queryResponse.setBuyerLogonId(getNodeText(root, "response/alipay/buyer_logon_id"));
		queryResponse.setBuyerUserId(getNodeText(root, "response/alipay/buyer_user_id"));
		queryResponse.setStatus(getNodeText(root, "response/alipay/trade_status"));
		queryResponse.setDetailErrorCode(getNodeText(root, "response/alipay/detail_error_code"));
		queryResponse.setDetailErrorDesc(getNodeText(root, "response/alipay/detail_error_des"));
		return queryResponse;
	}
	
	@Override
	public PrecreateResponse parsePrecreateResponse(String xml) {
		PrecreateResponse precreateResponse = new PrecreateResponse();
		Document document = XmlUtil.getDocument(xml);
		Element root = document.getRootElement();
		precreateResponse.setSuccess(getNodeText(root, "is_success"));
		precreateResponse.setError(getNodeText(root, "error"));
		
		precreateResponse.setResultCode(getNodeText(root,"response/alipay/result_code"));
		precreateResponse.setBigPicUrl(getNodeText(root,"response/alipay/big_pic_url"));
		precreateResponse.setOutTradeNo(getNodeText(root,"response/alipay/out_trade_no"));
		precreateResponse.setPicUrl(getNodeText(root, "response/alipay/pic_url"));
		precreateResponse.setQrCode(getNodeText(root, "response/alipay/qr_code"));
		precreateResponse.setResultCode(getNodeText(root, "response/alipay/result_code"));
		precreateResponse.setSmallPicUrl(getNodeText(root, "response/alipay/small_pic_url"));
		precreateResponse.setVoucherType(getNodeText(root, "response/alipay/voucher_type"));
		
		precreateResponse.setDetailErrorCode(getNodeText(root, "response/alipay/detail_error_code"));
		precreateResponse.setDetailErrorDesc(getNodeText(root, "response/alipay/detail_error_des"));
		return precreateResponse;
	}

	@Override
	public CreateandpayResponse parseCreateandpayResponse(String xml) {
		CreateandpayResponse createandpayResponse = new CreateandpayResponse();
		Document document = XmlUtil.getDocument(xml);
		Element root = document.getRootElement();
		createandpayResponse.setSuccess(getNodeText(root, "is_success"));
		createandpayResponse.setError(getNodeText(root, "error"));
		createandpayResponse.setDetailErrorCode(getNodeText(root, "response/alipay/detail_error_code"));
		createandpayResponse.setDetailErrorDesc(getNodeText(root, "response/alipay/detail_error_des"));
			
		createandpayResponse.setBuyerLogonId(getNodeText(root,"response/alipay/buyer_logon_id"));
		createandpayResponse.setBuyerUserId(getNodeText(root,"response/alipay/buyer_user_id"));
		createandpayResponse.setOutTradeNo(getNodeText(root, "response/alipay/out_trade_no"));
		createandpayResponse.setResultCode(getNodeText(root, "response/alipay/result_code"));
		createandpayResponse.setTradeNo(getNodeText(root, "response/alipay/trade_no"));
		
		return createandpayResponse;
	}

	@Override
	public CloseResponse parseCloseResponse(String xml) {
		CloseResponse closeResponse = new CloseResponse();
		Document document = XmlUtil.getDocument(xml);
		Element root = document.getRootElement();
		closeResponse.setSuccess(getNodeText(root, "is_success"));
		closeResponse.setError(getNodeText(root, "error"));
		closeResponse.setResultCode(getNodeText(root,"response/alipay/result_code"));
		closeResponse.setOutTradeNo(getNodeText(root,"response/alipay/out_trade_no"));
		closeResponse.setTradeNo(getNodeText(root, "response/alipay/trade_no"));
		closeResponse.setDetailErrorCode(getNodeText(root, "response/alipay/detail_error_code"));
		closeResponse.setDetailErrorDesc(getNodeText(root, "response/alipay/detail_error_des"));
		return closeResponse;
	}

	@Override
	public CancelResponse parseCancelResponse(String xml) {
		CancelResponse cancelResponse = new CancelResponse();
		Document document = XmlUtil.getDocument(xml);
		Element root = document.getRootElement();
		cancelResponse.setSuccess(getNodeText(root, "is_success"));
		cancelResponse.setError(getNodeText(root, "error"));
		cancelResponse.setResultCode(getNodeText(root,"response/alipay/result_code"));
		cancelResponse.setOutTradeNo(getNodeText(root,"response/alipay/out_trade_no"));
		cancelResponse.setTradeNo(getNodeText(root, "response/alipay/trade_no"));
		cancelResponse.setRetryFlag(getNodeText(root, "response/alipay/retry_flag"));
		cancelResponse.setDetailErrorCode(getNodeText(root, "response/alipay/detail_error_code"));
		cancelResponse.setDetailErrorDesc(getNodeText(root, "response/alipay/detail_error_des"));
		return cancelResponse;
	}

	@Override
	public RefundResponse parseRefundResponse(String xml) {
		RefundResponse refundResponse = new RefundResponse();
		Document document = XmlUtil.getDocument(xml);
		Element root = document.getRootElement();
		refundResponse.setSuccess(getNodeText(root, "is_success"));
		refundResponse.setError(getNodeText(root, "error"));
		refundResponse.setResultCode(getNodeText(root,"response/alipay/result_code"));
		refundResponse.setOutTradeNo(getNodeText(root,"response/alipay/out_trade_no"));
		refundResponse.setTradeNo(getNodeText(root, "response/alipay/trade_no"));
		refundResponse.setFundChange(getNodeText(root, "response/alipay/fund_change"));
		refundResponse.setDetailErrorCode(getNodeText(root, "response/alipay/detail_error_code"));
		refundResponse.setDetailErrorDesc(getNodeText(root, "response/alipay/detail_error_des"));
		return refundResponse;
	}

	@Override
	public PrecreateResponse parsePrecreatePicResponse(String xml) {
		PrecreateResponse precreateResponse = new PrecreateResponse();
		Document document = XmlUtil.getDocument(xml);
		Element root = document.getRootElement();
		precreateResponse.setSuccess(getNodeText(root, "is_success"));
		precreateResponse.setError(getNodeText(root, "error"));
		precreateResponse.setResultCode(getNodeText(root,"response/alipay/result_code"));
		
//		precreateResponse.setBigPicUrl(getNodeText(root,"response/alipay/big_pic_url"));
		precreateResponse.setOutTradeNo(getNodeText(root,"response/alipay/out_trade_no"));
		precreateResponse.setPicUrl(getNodeText(root, "response/alipay/pic_url"));
		precreateResponse.setQrCode(getNodeText(root, "response/alipay/qr_code"));
		precreateResponse.setResultCode(getNodeText(root, "response/alipay/result_code"));
		precreateResponse.setSmallPicUrl(getNodeText(root, "response/alipay/small_pic_url"));
		precreateResponse.setVoucherType(getNodeText(root, "response/alipay/voucher_type"));
		precreateResponse.setDetailErrorCode(getNodeText(root, "response/alipay/detail_error_code"));
		precreateResponse.setDetailErrorDesc(getNodeText(root, "response/alipay/detail_error_des"));
		
		String bigPic = getNodeText(root,"response/alipay/big_pic_url");
		String local = imagePath+"/"+precreateResponse.getOutTradeNo()+".png";
		ImageRequestUtil.writeImage(bigPic,local);
		
		precreateResponse.setBigPicLocal(local);
		return precreateResponse;
	}

	@Override
	public PrecreateResponse parsePrecreatePicArrayResponse(String xml) {
		PrecreateResponse precreateResponse = new PrecreateResponse();
		Document document = XmlUtil.getDocument(xml);
		Element root = document.getRootElement();
		precreateResponse.setSuccess(getNodeText(root, "is_success"));
		precreateResponse.setError(getNodeText(root, "error"));
		
		precreateResponse.setResultCode(getNodeText(root,"response/alipay/result_code"));
		
		
//		precreateResponse.setBigPicUrl(getNodeText(root,"response/alipay/big_pic_url"));
		precreateResponse.setOutTradeNo(getNodeText(root,"response/alipay/out_trade_no"));
		precreateResponse.setPicUrl(getNodeText(root, "response/alipay/pic_url"));
		precreateResponse.setQrCode(getNodeText(root, "response/alipay/qr_code"));
		precreateResponse.setResultCode(getNodeText(root, "response/alipay/result_code"));
		precreateResponse.setSmallPicUrl(getNodeText(root, "response/alipay/small_pic_url"));
		precreateResponse.setVoucherType(getNodeText(root, "response/alipay/voucher_type"));
		precreateResponse.setDetailErrorCode(getNodeText(root, "response/alipay/detail_error_code"));
		precreateResponse.setDetailErrorDesc(getNodeText(root, "response/alipay/detail_error_des"));
		String bigPic = getNodeText(root,"response/alipay/big_pic_url");
		try {
			String array = ImageRequestUtil.readInputStream(bigPic);
			System.out.println(array);
			precreateResponse.setBigPicArray(array);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return precreateResponse;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
