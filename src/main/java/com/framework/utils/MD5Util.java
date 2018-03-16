package com.framework.utils;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import com.sys.constant.SystemConstant;

/**
 * @describe 加密/解密
 * @author by - 吥悔
 * @date 2017年4月9日 下午2:45:48
 * @email Java_zlm@163.com
 * @qq 379839355
 * @website http://www.javazlm.com/
 */
public class MD5Util {
	/**
	 * 生成MD5字符串
	 * 
	 * @param str 字符
	 * @return String
	 */
	public static String generateMD5(String str) {
		return generateMD5ByEnCode(str, "utf-8");
	}

	/**
	 * 根据编码生成MD5字符串
	 * 
	 * @param str 字符
	 * @param encode 编码
	 * @return String
	 */
	public static String generateMD5ByEnCode(String str, String encode) {
		String result = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(str.getBytes(encode));
			byte[] digest = md5.digest();

			StringBuffer hexString = new StringBuffer();
			String strTemp;
			for (int i = 0; i < digest.length; i++) {
				// byteVar & 0x000000FF的作用是，如果digest[i]是负数，则会清除前面24个零，正的byte整型不受影响。
				// (...) | 0xFFFFFF00的作用是，如果digest[i]是正数，则置前24位为一，
				// 这样toHexString输出一个小于等于15的byte整型的十六进制时，倒数第二位为零且不会被丢弃，这样可以通过substring方法进行截取最后两位即可。
				strTemp = Integer.toHexString((digest[i] & 0x000000FF) | 0xFFFFFF00).substring(6);
				hexString.append(strTemp);
			}
			result = hexString.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 系统自定义MD5加密方式[ eg: 1 3 5 7 8 10 12 15 ] - 根据索引下标进行再次加密
	 * 
	 * @param md5 生成的MD5值
	 * @return new MD5 String
	 */
	public static String encrypSysMD5(String md5) {
		String[] idx = SystemConstant.GENERATE_MD5_IDX.split(",");
		StringBuffer sb = new StringBuffer();
		char[] c = md5.toCharArray();
		try {
			boolean flag = true;
			for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < idx.length; j++) {
					if(Integer.parseInt(idx[j]) == i) {
						String str = SysStringUtils.randomString(1);
						sb.append(c[i] + str);
						flag = false;
						break;
					}
					flag = true;
				}
				if(!flag) {
					continue;
				}
				sb.append(c[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	/**
	 * 系统自定义MD5解密方式[ eg: 1 3 5 7 8 10 12 15 ] - 根据索引下标进行解密
	 * 
	 * @param sysMD5 系统的MD5值
	 * @return true MD5 String
	 */
	public static String decryptSysMd5(String sysMD5) {
		String[] idx = SystemConstant.GENERATE_MD5_IDX.split(",");
		StringBuffer sb = new StringBuffer();
		List<Character> list = new ArrayList<Character>();
		try {
			for (char c : sysMD5.toCharArray()) {
				list.add(c);
			}
			for (int i = 0; i < sysMD5.length(); i++) {
				for (int j = 0; j < idx.length; j++) {
					int idxVal = Integer.parseInt(idx[j]);
					// 下标 == 新的MD5下标 + 1
					if(idxVal == (i + 1)) {
						list.remove(idxVal + 1);
						break;
					}
				}
			}
			for (char c : list) {
				sb.append(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}