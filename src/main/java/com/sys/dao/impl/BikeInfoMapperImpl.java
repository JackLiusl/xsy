package com.sys.dao.impl;

import org.springframework.stereotype.Service;

import com.framework.base.BaseDao;
import com.sys.dao.BikeInfoMapper;
import com.sys.model.BikeInfo;

/**
 * @describe 
 * @author by - 吥悔
 * @date 2017年3月29日 上午12:55:31
 * @email Java_zlm@163.com
 * @qq 379839355
 * @website http://www.javazlm.com/
 */
@Service
public class BikeInfoMapperImpl extends BaseDao<BikeInfo> implements BikeInfoMapper {
	private static final String NS = "com.sys.dao.BikeInfoMapper.";

	@Override
	public int deleteByPrimaryKey(String bikeid) {
		return this.getSqlSession().delete(NS + "deleteByPrimaryKey", bikeid);
	}

	@Override
	public int insert(BikeInfo record) {
		return this.getSqlSession().insert(NS + "insert", record);
	}

	@Override
	public int insertSelective(BikeInfo record) {
		return this.getSqlSession().insert(NS + "insertSelective", record);
	}

	@Override
	public BikeInfo selectByPrimaryKey(String bikeid) {
		return this.getSqlSession().selectOne(NS + "selectByPrimaryKey", bikeid);
	}

	@Override
	public int updateByPrimaryKeySelective(BikeInfo record) {
		return this.getSqlSession().update(NS + "updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKey(BikeInfo record) {
		return this.getSqlSession().update(NS + "updateByPrimaryKey", record);
	}
}