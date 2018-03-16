package com.sys.service;

import com.sys.exception.ServiceException;
import com.sys.model.SysUserInfo;

/**
 * @author jary0524
 * @date 2016年7月12日 上午10:43:32
 */

public interface SysUserInfoService {
	int deleteByPrimaryKey(String userid) throws ServiceException;

	int insert(SysUserInfo record) throws ServiceException;

	int insertSelective(SysUserInfo record) throws ServiceException;

	SysUserInfo selectByPrimaryKey(String userid) throws ServiceException;

	int updateByPrimaryKeySelective(SysUserInfo record) throws ServiceException;

	int updateByPrimaryKey(SysUserInfo record) throws ServiceException;

	/**
	 * 根据手机号和密码查询用户信息
	 * 
	 * @param userInfo 用户信息
	 * @return SysUserInfo 当前用户信息
	 * @throws ServiceException 自定义异常
	 */
	SysUserInfo selectUsreInfoByPhonenumberAndPassword(SysUserInfo userInfo) throws ServiceException;

	/**
	 * 查询当前最大编号
	 * 
	 * @return String 当前最大编号
	 */
	String selectMaxId() throws ServiceException;
}