package com.sys.model;

import java.io.Serializable;

public class SysDicType implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String dictypeid;

	private String dictypecode;

	private String dictypename;

	private String isusiing;

	public String getDictypeid() {
		return dictypeid;
	}

	public void setDictypeid(String dictypeid) {
		this.dictypeid = dictypeid == null ? null : dictypeid.trim();
	}

	public String getDictypecode() {
		return dictypecode;
	}

	public void setDictypecode(String dictypecode) {
		this.dictypecode = dictypecode == null ? null : dictypecode.trim();
	}

	public String getDictypename() {
		return dictypename;
	}

	public void setDictypename(String dictypename) {
		this.dictypename = dictypename == null ? null : dictypename.trim();
	}

	public String getIsusiing() {
		return isusiing;
	}

	public void setIsusiing(String isusiing) {
		this.isusiing = isusiing == null ? null : isusiing.trim();
	}
	
	@Override
	public String toString() {
		return "SysDicType [dictypeid=" + dictypeid + ", dictypecode=" + dictypecode + ", dictypename=" + dictypename
				+ ", isusiing=" + isusiing + "]";
	}
}