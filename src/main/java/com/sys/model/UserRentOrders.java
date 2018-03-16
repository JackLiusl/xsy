package com.sys.model;

import java.io.Serializable;
import java.util.Date;

public class UserRentOrders implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String orderid;

	private String userid;

	private String bikeid;

	private String isfinish;

	private String ispay;

	private Date starttime;

	private Date endtime;

	private Long rentingtime;

	private Double amount;

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid == null ? null : orderid.trim();
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid == null ? null : userid.trim();
	}

	public String getBikeid() {
		return bikeid;
	}

	public void setBikeid(String bikeid) {
		this.bikeid = bikeid == null ? null : bikeid.trim();
	}

	public String getIsfinish() {
		return isfinish;
	}

	public void setIsfinish(String isfinish) {
		this.isfinish = isfinish == null ? null : isfinish.trim();
	}

	public String getIspay() {
		return ispay;
	}

	public void setIspay(String ispay) {
		this.ispay = ispay == null ? null : ispay.trim();
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Long getRentingtime() {
		return rentingtime;
	}

	public void setRentingtime(Long rentingtime) {
		this.rentingtime = rentingtime;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}