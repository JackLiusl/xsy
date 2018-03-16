package com.sys.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.framework.base.BaseController;
import com.framework.utils.MD5Util;
import com.framework.utils.SysStringUtils;
import com.sys.exception.ServiceException;
import com.sys.model.SysUserInfo;
import com.sys.service.SysUserInfoService;

/**
 * @author jiangjie
 * @date 2017年3月10日10:29:15
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController<SysUserInfo> {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private SysUserInfoService userService;

	@RequestMapping(value = "/login")
	public ModelAndView submitLoginForm(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		try {
			userService.selectByPrimaryKey("");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return mv;
	}

	// 退出登录
	@RequestMapping(value = "/loginOut")
	public ModelAndView loginOut() {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			subject.logout();
		}
		return new ModelAndView("loginOut");
	}
	
	@RequestMapping(value = "addUser")
	public String insertUserInfo() {
		Date date = new Date();
		Date Registerdate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfRegisterdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse("1990-04-24");
			Registerdate = sdfRegisterdate.parse(sdfRegisterdate.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SysUserInfo userInfo = new SysUserInfo();
		userInfo.setUserid(sdf.format(date).replaceAll("-", ""));
		userInfo.setPhonenumber("15072330003");
		userInfo.setNickname("吥悔");
		userInfo.setUsername("吥悔");
		userInfo.setPassword("miao0421");
		userInfo.setIdcardno("42022219900424671X");
		userInfo.setAddress("广东深圳");
		userInfo.setSex("1");
		userInfo.setBirthday(date);
		userInfo.setRegisterdate(Registerdate);
		LOGGER.info("-----------> " + userInfo);
		try {
			userService.insertSelective(userInfo);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "user/success";
	}
	
	/**
	 * RESTFul风格的SringMVC
	 * 
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryUserInfo/{userId}", method = RequestMethod.GET)
	public SysUserInfo queryUserInfo(@PathVariable("userId") String userId) {
		try {
			return userService.selectByPrimaryKey(userId);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return null;
	}
}