package com.framework.utils;

import java.util.Random;
import java.util.UUID;
import com.sys.constant.SystemConstant;

/**
 * @describe StringUtils
 * @author by - 吥悔
 * @date 2017年4月9日 下午1:32:21
 * @email Java_zlm@163.com
 * @qq 379839355
 * @website http://www.javazlm.com/
 */
public class SysStringUtils {
	/**
	 * 生成自定义长度UUID
	 * 
	 * @param maxlength 长度
	 * @return UUID String
	 */
	public static String generateUUID(int maxlength) {
		UUID uuid = UUID.randomUUID();
		String sid = uuid.toString().replaceAll("-", "");
		if (sid.length() > maxlength) {
			sid = sid.substring(0, maxlength);
		}
		return sid;
	}

	/**
	 * 随机生成字符串
	 * 
	 * @param len 长度
	 * @return Random String
	 */
	public static String randomString(int len) {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		int x = 0;
		while(x < len) {
			sb.append(SystemConstant.RANDOM_STRING.charAt(random.nextInt(SystemConstant.RANDOM_STRING.length())));
			++x;
		}
		return sb.toString();
	}
	
	/**
	 * 字符串编号自增
	 * 
	 * @param no 起始编号
	 * @param maxVal 最大编号
	 * @return 自增字符串编号
	 */
	public static String nextStringNumber(String no, long maxVal) {
		int x = Integer.parseInt(no);
		if(maxVal == x) {
			x = 0;
		}
		++x;
		String temp = "" + x;
		String s = "";
		for (int i = 0; i < no.length() - temp.length(); i++) {
			s += "0";
		}
		no = s + x;
		return no;
	}
}