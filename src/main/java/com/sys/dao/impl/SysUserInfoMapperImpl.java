package com.sys.dao.impl;

import org.springframework.stereotype.Service;
import com.framework.base.BaseDao;
import com.sys.dao.SysUserInfoMapper;
import com.sys.model.SysUserInfo;

/**
 * @describe 
 * @author by - 吥悔
 * @date 2017年4月4日 下午1:59:11
 * @email Java_zlm@163.com
 * @qq 379839355
 * @website http://www.javazlm.com/
 */
@Service
public class SysUserInfoMapperImpl extends BaseDao<SysUserInfo> implements SysUserInfoMapper {
	private static final String NS = "com.sys.dao.SysUserInfoMapper.";

	@Override
	public int deleteByPrimaryKey(String userid) {
		return this.getSqlSession().delete(NS + "deleteByPrimaryKey", userid);
	}

	@Override
	public int insert(SysUserInfo record) {
		return this.getSqlSession().insert(NS + "insert", record);
	}

	@Override
	public int insertSelective(SysUserInfo record) {
		return this.getSqlSession().insert(NS + "insertSelective", record);
	}

	@Override
	public SysUserInfo selectByPrimaryKey(String userid) {
		return this.getSqlSession().selectOne(NS + "selectByPrimaryKey", userid);
	}

	@Override
	public int updateByPrimaryKeySelective(SysUserInfo record) {
		return this.getSqlSession().update(NS + "updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKey(SysUserInfo record) {
		return this.getSqlSession().update(NS + "updateByPrimaryKey", record);
	}

	/**
	 * 根据手机号和密码查询用户信息
	 * 
	 * @param userInfo 用户信息
	 * @return SysUserInfo 当前用户信息
	 */
	@Override
	public SysUserInfo selectUsreInfoByPhonenumberAndPassword(SysUserInfo userInfo) {
		return this.getSqlSession().selectOne(NS + "selectUsreInfoByPhonenumberAndPassword", userInfo);
	}

	/**
	 * 查询当前最大编号
	 * 
	 * @return String 当前最大编号
	 */
	@Override
	public String selectMaxId() {
		return this.getSqlSession().selectOne(NS + "selectMaxId");
	}
}