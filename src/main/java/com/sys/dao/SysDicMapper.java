package com.sys.dao;

import com.sys.model.SysDic;

public interface SysDicMapper {
	int deleteByPrimaryKey(String dicid);

	int insert(SysDic record);

	int insertSelective(SysDic record);

	SysDic selectByPrimaryKey(String dicid);

	int updateByPrimaryKeySelective(SysDic record);

	int updateByPrimaryKey(SysDic record);
}