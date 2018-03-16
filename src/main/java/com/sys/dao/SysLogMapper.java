package com.sys.dao;

import com.sys.model.SysLog;

public interface SysLogMapper {
	int deleteByPrimaryKey(String logid);

	int insert(SysLog record);

	int insertSelective(SysLog record);

	SysLog selectByPrimaryKey(String logid);

	int updateByPrimaryKeySelective(SysLog record);

	int updateByPrimaryKey(SysLog record);
}