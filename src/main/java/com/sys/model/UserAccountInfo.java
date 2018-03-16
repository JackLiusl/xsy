package com.sys.model;

import java.io.Serializable;

public class UserAccountInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String accountid;

	private String userid;

	private Double accountsum;

	private Double rentingforegift;

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid == null ? null : accountid.trim();
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid == null ? null : userid.trim();
	}

	public Double getAccountsum() {
		return accountsum;
	}

	public void setAccountsum(Double accountsum) {
		this.accountsum = accountsum;
	}

	public Double getRentingforegift() {
		return rentingforegift;
	}

	public void setRentingforegift(Double rentingforegift) {
		this.rentingforegift = rentingforegift;
	}

	@Override
	public String toString() {
		return "UserAccountInfo [accountid=" + accountid + ", userid=" + userid + ", accountsum=" + accountsum
				+ ", rentingforegift=" + rentingforegift + "]";
	}
}