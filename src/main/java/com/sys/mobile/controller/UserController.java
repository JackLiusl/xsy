package com.sys.mobile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.framework.base.BaseController;
import com.sys.constant.ResultEnum;
import com.sys.dto.Result;
import com.sys.exception.ServiceException;
import com.sys.model.SysUserInfo;
import com.sys.service.SysUserInfoService;

/**
 * @describe 移动端用户管理
 * @author by - 吥悔
 * @date 2017年4月9日 下午1:32:21
 * @email Java_zlm@163.com
 * @qq 379839355
 * @website http://www.javazlm.com/
 */
@Controller("userMobileController")
@RequestMapping("/m/user")
public class UserController extends BaseController<SysUserInfo> {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private SysUserInfoService userService;
	
	/**
	 * 手机移动端 - 注册用户信息
	 * 
	 * TODO 手机号存在时反馈接口
	 * 
	 * @see consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;
	 * 
	 * @see produces: [SpringMVC ResponseBody xxx.html请求乱码，解决方案： produces = "text/html; charset=utf-8"]
	 * 
	 * 指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回；
	 * 
	 * @param userInfo 用户信息
	 * @return 处理结果
	 */
	@ResponseBody
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = "application/json; charset=utf-8")
	public String addUser(@RequestBody SysUserInfo userInfo) {
		LOGGER.info("手机移动端 - 注册用户信息：{}", userInfo);
		Result<JSONObject> result = new Result<JSONObject>(ResultEnum.SUCCESS.getCode(), "注册成功", null);
		try {
			userService.insertSelective(userInfo);
			LOGGER.info("手机移动端 - 注册用户信息注册成功：{}", userInfo);
			// 反馈注册成功的用户信息 - 清空用户密码
			userInfo.setPassword(null);
			JSONObject json = (JSONObject) JSONObject.toJSON(userInfo);
			result.setT(json);
		} catch (ServiceException e) {
			LOGGER.error("手机移动端 - 注册用户请求异常：{}", e.getMessage());
			result = new Result<JSONObject>(ResultEnum.ERROR.getCode(), e.getMessage(), null);
			e.printStackTrace();
		}
		return JSONObject.toJSONString(result);
	}
	
	/**
	 * 手机移动端 - 用户登录
	 * 
	 * @param userInfo 用户信息
	 * @return 处理结果
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json; charset=utf-8")
	public String login(@RequestBody SysUserInfo userInfo) {
		LOGGER.info("手机移动端 - 用户登录信息：{}", userInfo);
		Result<JSONObject> result = new Result<JSONObject>(ResultEnum.SUCCESS.getCode(), "登录成功", null);
		try {
			SysUserInfo user = userService.selectUsreInfoByPhonenumberAndPassword(userInfo);
			// 反馈登录成功的用户信息 - 清空用户密码
			user.setPassword(null);
			JSONObject json = (JSONObject) JSONObject.toJSON(user);
			result.setT(json);
		} catch (ServiceException e) {
			LOGGER.info("手机移动端 - 用户登录请求异常：{}", e.getMessage());
			result = new Result<JSONObject>(ResultEnum.ERROR.getCode(), e.getMessage(), null);
			e.printStackTrace();
		}
		return JSONObject.toJSONString(result);
	}
	
	/**
	 * 手机移动端 - 更新用户信息
	 * 
	 * TODO 原密码校验是做接口,还是在此接口校验 [待定]
	 * 
	 * 1. [密码变更] 密码非空,校验原密码是否正确(正确变更，否之反馈);
	 * 2. [其他变更] 密码为空,变更信息;
	 * 
	 * @param userInfo 用户信息
	 * @return 处理结果
	 */
	@ResponseBody
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST, consumes = "application/json; charset=utf-8")
	public String updateUser(@RequestBody SysUserInfo userInfo) {
		LOGGER.info("手机移动端 - 用户登录信息：{}", userInfo);
		Result<JSONObject> result = new Result<JSONObject>(ResultEnum.SUCCESS.getCode(), "修改成功", null);
		try {
			SysUserInfo user = userService.selectUsreInfoByPhonenumberAndPassword(userInfo);
			// 反馈登录成功的用户信息 - 清空用户密码
			user.setPassword(null);
			JSONObject json = (JSONObject) JSONObject.toJSON(user);
			result.setT(json);
		} catch (ServiceException e) {
			LOGGER.info("手机移动端 - 用户登录请求异常：{}", e.getMessage());
			result = new Result<JSONObject>(ResultEnum.ERROR.getCode(), e.getMessage(), null);
			e.printStackTrace();
		}
		return JSONObject.toJSONString(result);
	}
}