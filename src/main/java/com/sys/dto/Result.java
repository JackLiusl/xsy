package com.sys.dto;

import java.io.Serializable;

/**
 * @describe 业务处理返回结果对象
 * @author by - 吥悔
 * @date 2017年4月5日 上午1:21:30
 * @email Java_zlm@163.com
 * @qq 379839355
 * @website http://www.javazlm.com/
 */
public class Result<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 返回代码
	 */
	private int code;

	/**
	 * 返回消息提示
	 */
	private String msg;

	/**
	 * 返回内容
	 */
	private T t;
	
	public Result() {
		super();
	}

	public Result(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public Result(int code, String msg, T t) {
		super();
		this.code = code;
		this.msg = msg;
		this.t = t;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "Result [code=" + code + ", msg=" + msg + ", t=" + t + "]";
	}
}