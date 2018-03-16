package com.sys.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.framework.utils.PropertiesUtil;
import com.sys.controller.UserController;

/**
 * @describe 系统常量
 * @author by - 吥悔
 * @date 2017年4月9日 下午5:37:51
 * @email Java_zlm@163.com
 * @qq 379839355
 * @website http://www.javazlm.com/
 */
@Component
public class SystemConstant implements ApplicationContextAware {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	/**
	 * 登录是获取session_key和openid所需常量
	 */
	public static String grantType = "authorization_code";
	public static String appid = "wxc8b116b7c0feb661";
	public static String secret = "7ac0a1f55c6c5793992b4cbe72b5a325";
	public static String url = "https://api.weixin.qq.com/sns/jscode2session?";



	
	/**
	 * 系统随机加密字符串
	 */
	public static String RANDOM_STRING;
	
	/**
	 * 系统加密规则索引
	 */
	public static String GENERATE_MD5_IDX;
	
	/**
	 * 用户ID前缀
	 */
	public static String USRE_ID_PREFIX;
	
	/**
	 * 用户最大限制ID
	 */
	public static long SYS_ID_MAX;

	/**
	 * 初始化系统变量
	 */
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		LOGGER.info("-----------------------> 系统初始化数据 <-----------------------");
		PropertiesUtil propertiesUtil = new PropertiesUtil("config/common.properties");
		RANDOM_STRING = propertiesUtil.getProperty("sys.randomString");
		GENERATE_MD5_IDX = propertiesUtil.getProperty("sys.generateMD5Idx");
		USRE_ID_PREFIX = propertiesUtil.getProperty("sys.user.id.prefix");
		SYS_ID_MAX = Long.parseLong(propertiesUtil.getProperty("sys.id.maxVal"));
		LOGGER.info("--------------> 系统初始化数据：{}", RANDOM_STRING, GENERATE_MD5_IDX);
	}
}