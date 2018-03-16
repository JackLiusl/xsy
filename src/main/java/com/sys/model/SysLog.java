package com.sys.model;

import java.io.Serializable;
import java.util.Date;

public class SysLog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String logid;

	private String userid;

	private String diccode;

	private String logcontent;

	private Date operationtime;

	public String getLogid() {
		return logid;
	}

	public void setLogid(String logid) {
		this.logid = logid == null ? null : logid.trim();
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid == null ? null : userid.trim();
	}

	public String getDiccode() {
		return diccode;
	}

	public void setDiccode(String diccode) {
		this.diccode = diccode == null ? null : diccode.trim();
	}

	public String getLogcontent() {
		return logcontent;
	}

	public void setLogcontent(String logcontent) {
		this.logcontent = logcontent == null ? null : logcontent.trim();
	}

	public Date getOperationtime() {
		return operationtime;
	}

	public void setOperationtime(Date operationtime) {
		this.operationtime = operationtime;
	}
	
	@Override
	public String toString() {
		return "SysLog [logid=" + logid + ", userid=" + userid + ", diccode=" + diccode + ", logcontent=" + logcontent
				+ ", operationtime=" + operationtime + "]";
	}
}