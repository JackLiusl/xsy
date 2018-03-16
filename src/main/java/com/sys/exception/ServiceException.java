package com.sys.exception;

import com.sys.constant.ErrorEnum;

/**
 * @describe ServiceException 自定义异常
 * @author by - 吥悔
 * @date 2017年4月4日 下午11:10:50
 * @email Java_zlm@163.com
 * @qq 379839355
 * @website http://www.javazlm.com/
 */
public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 系统异常枚举类
	 */
	private ErrorEnum errorEnum;
	
	public ServiceException() {
		super();
	}
	
	public ServiceException(ErrorEnum errorEnum) {
		super(errorEnum.getMsg());
		this.errorEnum = errorEnum;
	}
	
	public ServiceException(ErrorEnum errorEnum, String params) {
		super(params + errorEnum.getMsg());
		this.errorEnum = errorEnum;
	}
	
	public ServiceException(ErrorEnum errorEnum, Throwable cause) {
		super(errorEnum.getMsg(), cause);
		this.errorEnum = errorEnum;
	}

	public ErrorEnum getErrorEnum() {
		return errorEnum;
	}
	
	@Override
	public String getMessage() {
		return errorEnum.getMsg();
	}
}