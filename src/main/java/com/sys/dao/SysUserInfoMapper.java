package com.sys.dao;

import com.sys.model.SysUserInfo;

public interface SysUserInfoMapper {
	int deleteByPrimaryKey(String userid);

	int insert(SysUserInfo record);

	int insertSelective(SysUserInfo record);

	SysUserInfo selectByPrimaryKey(String userid);

	int updateByPrimaryKeySelective(SysUserInfo record);

	int updateByPrimaryKey(SysUserInfo record);

	/**
	 * 根据手机号和密码查询用户信息
	 * 
	 * @param userInfo 用户信息
	 * @return SysUserInfo 当前用户信息
	 */
	SysUserInfo selectUsreInfoByPhonenumberAndPassword(SysUserInfo userInfo);

	/**
	 * 查询当前最大编号
	 * 
	 * @return String 当前最大编号
	 */
	String selectMaxId();
}