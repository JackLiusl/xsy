package com.sys.constant;

/**
 * @describe 系统异常枚举类
 * @author by - 吥悔
 * @date 2017年4月4日 下午11:12:26
 * @email Java_zlm@163.com
 * @qq 379839355
 * @website http://www.javazlm.com/
 */
public enum ErrorEnum {
	ISNULL_COLUMNS(10001, "", "字段不允许为空"),
	ISNULL_OBJECT(10002, "", "对象不允许为空"),
	JSON_READ_ERROR(-20001, "JSON", "字符串转换对象异常"),
	JSON_WRITE_ERROR(-20002, "JSON", "对象转换字符串异常"),
	DATE_READ_ERROR(-20003, "DATE", "字符串转换对象异常"),
	DATE_WRITE_ERROR(-20004, "DATE", "对象转换字符串异常"),
	QUERY_ERROR(-30001, "", "数据查询异常"),
	INSECT_ERROR(-30002, "", "数据保存异常"),
	UPDATE_ERROR(-30003, "", "数据变更异常"),
	DELETE_ERROR(-30004, "", "数据删除异常");
	
	/**
	 * 错误代码
	 */
	private int code;
	
	/**
	 * 错误描述
	 */
	private String userDefined;
	
	/**
	 * 错误描述
	 */
	private String msg;
	
	/**
	 * 枚举实例
	 * 
	 * @param code 错误代码
	 * @param userDefined 用户自定义描述(eg: [password + #{msg} = password字段不允许为空])
	 * @param msg 错误描述
	 */
	ErrorEnum(int code, String userDefined, String msg) {
		this.code = code;
		this.userDefined = userDefined;
		this.msg = this.userDefined + msg;
	}

	public int getCode() {
		return code;
	}

	public void setUserDefined(String userDefined) {
		this.userDefined = userDefined;
	}

	public String getMsg() {
		return this.userDefined + msg;
	}
}