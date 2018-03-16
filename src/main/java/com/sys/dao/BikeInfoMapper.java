package com.sys.dao;

import com.sys.model.BikeInfo;

public interface BikeInfoMapper {
	int deleteByPrimaryKey(String bikeid);

	int insert(BikeInfo record);

	int insertSelective(BikeInfo record);

	BikeInfo selectByPrimaryKey(String bikeid);

	int updateByPrimaryKeySelective(BikeInfo record);

	int updateByPrimaryKey(BikeInfo record);
}