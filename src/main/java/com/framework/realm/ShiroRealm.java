package com.framework.realm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.sys.model.SysUserInfo;
import com.sys.model.SysUserRoles;
import com.sys.service.SysUserInfoService;

/**
 * @author jiangjie
 * @date 2017年3月10日10:31:56
 */
public class ShiroRealm extends AuthorizingRealm {
	@Autowired
	private SysUserInfoService sysUserInfoService;

	/*
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 根据用户配置用户与权限
		/*if (principals == null) {
			throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
		}
		String name = (String) getAvailablePrincipal(principals);

		List<String> roles = new ArrayList<String>();
		SysUserInfo user = sysUserInfoService.getByUserName(name);
		// 用户与用户权限
		SysUserRoles role = new SysUserRoles("1", "admin", "管理员");
		HashSet<SysUserRoles> userRoles = new HashSet<SysUserRoles>();
		userRoles.add(role);
		user.setRole(userRoles);
		if (user.getUserName().equals(name)) {
			if (!user.getRole().isEmpty()) {
				for (Role userRole : user.getRole()) {
					roles.add(userRole.getRoleName());
				}
			}
		} else {
			throw new AuthorizationException();
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 增加角色
		info.addRoles(roles);
		return info;*/
		
		return null;
	}

	/*
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		/*UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		// 简单默认一个用户,实际项目应User user =
		// userService.getByAccount(token.getUsername());
		SysUserInfo user = sysUserInfoService.getByUserName(token.getUsername());
		if (user == null) {
			throw new UnknownAccountException();// 没找到帐号
		}
		SimpleAuthenticationInfo info = null;
		info = new SimpleAuthenticationInfo(user.getUserName(), user.getPassWord(), ByteSource.Util.bytes(user.getPasswordSalt()), getName());
		return info;*/
		return null;
	}
}