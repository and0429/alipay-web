package com.collect.alipay.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author xu
 *
 */
public class Alilog implements Serializable {

	private static final long serialVersionUID = -6890665988884555785L;

	private String id;
	
	private Integer oper;
	
	private String operUser;
	
	private Date operDate;
	
	private Integer operChannel;
	
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getOper() {
		return oper;
	}

	public void setOper(Integer oper) {
		this.oper = oper;
	}

	public String getOperUser() {
		return operUser;
	}

	public void setOperUser(String operUser) {
		this.operUser = operUser;
	}

	public Integer getOperChannel() {
		return operChannel;
	}

	public void setOperChannel(Integer operChannel) {
		this.operChannel = operChannel;
	}

	public Date getOperDate() {
		return operDate;
	}

	public void setOperDate(Date operDate) {
		this.operDate = operDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
