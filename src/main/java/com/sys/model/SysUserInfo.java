package com.sys.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class SysUserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String userid;

	private String nickname;

	private String phonenumber;

	private String password;

	private String username;

	private String idcardno;

	private String sex;

	private String address;

	private Date birthday;

	private Date registerdate;
	
	private Set<SysUserRoles> role;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid == null ? null : userid.trim();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname == null ? null : nickname.trim();
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber == null ? null : phonenumber.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getIdcardno() {
		return idcardno;
	}

	public void setIdcardno(String idcardno) {
		this.idcardno = idcardno == null ? null : idcardno.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}
	
	public Set<SysUserRoles> getRole() {
		return role;
	}

	public void setRole(Set<SysUserRoles> role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "SysUserInfo [userid=" + userid + ", nickname=" + nickname + ", phonenumber=" + phonenumber
				+ ", password=" + password + ", username=" + username + ", idcardno=" + idcardno + ", sex=" + sex
				+ ", address=" + address + ", birthday=" + birthday + ", registerdate=" + registerdate + "]";
	}
}