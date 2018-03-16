package com.sys.model;

import java.io.Serializable;

public class SysDic implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String dicid;

	private String dictypecode;

	private String diccode;

	private String dicname;

	private String isusing;

	public String getDicid() {
		return dicid;
	}

	public void setDicid(String dicid) {
		this.dicid = dicid == null ? null : dicid.trim();
	}

	public String getDictypecode() {
		return dictypecode;
	}

	public void setDictypecode(String dictypecode) {
		this.dictypecode = dictypecode == null ? null : dictypecode.trim();
	}

	public String getDiccode() {
		return diccode;
	}

	public void setDiccode(String diccode) {
		this.diccode = diccode == null ? null : diccode.trim();
	}

	public String getDicname() {
		return dicname;
	}

	public void setDicname(String dicname) {
		this.dicname = dicname == null ? null : dicname.trim();
	}

	public String getIsusing() {
		return isusing;
	}

	public void setIsusing(String isusing) {
		this.isusing = isusing == null ? null : isusing.trim();
	}
	
	@Override
	public String toString() {
		return "SysDic [dicid=" + dicid + ", dictypecode=" + dictypecode + ", diccode=" + diccode + ", dicname="
				+ dicname + ", isusing=" + isusing + "]";
	}
}