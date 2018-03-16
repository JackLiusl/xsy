package com.framework.utils;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import com.sys.model.SysUserInfo;

/**
 * @author jiangjie
 * @date 2017年3月10日10:32:11
 */
public class EndecryptUtils {
	/**
	 * 对密码进行md5加密,并返回密文和salt，包含在User对象中
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 密文和salt
	 */
	public static SysUserInfo md5Password(SysUserInfo user) {
		SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
		String salt = secureRandomNumberGenerator.nextBytes().toHex();
		// 组合username,两次迭代，对密码进行加密
		String password_cipherText = new Md5Hash(user.getPassword(), salt, 2).toBase64();
		user.setPassword(password_cipherText);
//		user.setPasswordSalt(salt);
		return user;
	}

	/**
	 * 通过username,password,salt,校验密文是否匹配 ，校验规则其实在配置文件中，这里为了清晰，写下来
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            原密码
	 * @param salt
	 *            盐
	 * @param md5cipherText
	 *            密文
	 * @return
	 */
	public static boolean checkMd5Password(String password, String salt, String md5cipherText) {
		// 组合username,两次迭代，对密码进行加密
		String password_cipherText = new Md5Hash(password, salt, 2).toHex();
		return md5cipherText.equals(password_cipherText);
	}
}