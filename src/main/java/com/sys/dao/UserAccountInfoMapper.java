package com.sys.dao;

import com.sys.model.UserAccountInfo;

public interface UserAccountInfoMapper {
	int deleteByPrimaryKey(String accountid);

	int insert(UserAccountInfo record);

	int insertSelective(UserAccountInfo record);

	UserAccountInfo selectByPrimaryKey(String accountid);

	int updateByPrimaryKeySelective(UserAccountInfo record);

	int updateByPrimaryKey(UserAccountInfo record);
}