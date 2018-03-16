package com.sys.model;

import java.io.Serializable;

public class SysUserRoles implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String roleid;

	private String userid;

	private String rolename;
	
	public SysUserRoles() {
		
	}

	public SysUserRoles(String roleid, String userid, String rolename) {
		this.roleid = roleid;
		this.userid = userid;
		this.rolename = rolename;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename == null ? null : rolename.trim();
	}

	@Override
	public String toString() {
		return "SysUserRoles [roleid=" + roleid + ", userid=" + userid + ", rolename=" + rolename + "]";
	}
}