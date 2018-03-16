package com.sys.dao;

import com.sys.model.SysDicType;

public interface SysDicTypeMapper {
	int deleteByPrimaryKey(String dictypeid);

	int insert(SysDicType record);

	int insertSelective(SysDicType record);

	SysDicType selectByPrimaryKey(String dictypeid);

	int updateByPrimaryKeySelective(SysDicType record);

	int updateByPrimaryKey(SysDicType record);
}