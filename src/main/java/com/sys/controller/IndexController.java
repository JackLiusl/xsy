package com.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.framework.base.BaseController;
import com.sys.model.SysUserInfo;

/**
 * @author jiangjie
 * @date 2017年3月10日10:28:59
 */
@Controller
public class IndexController extends BaseController<SysUserInfo> {
	/**
	 * 首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index")
	public ModelAndView index() {
		return new ModelAndView("addUser");
	}
}