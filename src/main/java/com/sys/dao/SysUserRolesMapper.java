package com.sys.dao;

import com.sys.model.SysUserRoles;

public interface SysUserRolesMapper {
	int deleteByPrimaryKey(String roleid);

	int insert(SysUserRoles record);

	int insertSelective(SysUserRoles record);

	SysUserRoles selectByPrimaryKey(String roleid);

	int updateByPrimaryKeySelective(SysUserRoles record);

	int updateByPrimaryKey(SysUserRoles record);
}