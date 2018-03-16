package com.sys.constant;

/**
 * @describe 结果集枚举类
 * @author by - 吥悔
 * @date 2017年4月4日 下午11:52:53
 * @email Java_zlm@163.com
 * @qq 379839355
 * @website http://www.javazlm.com/
 */
public enum ResultEnum {
	SUCCESS(200),
	ERROR(500);
	
	/**
	 * 结果代码
	 */
	private int code;
	
	ResultEnum(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}