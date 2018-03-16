package com.sys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sys.constant.SystemConstant;
import com.sys.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 小程序登录
 * @Author lauSl
 * @Date 2017-12-18 23:34:46
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @ResponseBody
    @RequestMapping(value = "login")
    public Object login(HttpServletRequest request, HttpServletResponse response){
        String code = request.getParameter("code");
        String encryptedData = request.getParameter("encryptedData");
        String iv = request.getParameter("iv");

        Map<String,String> requestUrlParam = new HashMap<String,String>();
        requestUrlParam.put("appid", SystemConstant.appid);  //开发者设置中的appId
        requestUrlParam.put("secret", SystemConstant.secret); //开发者设置中的appSecret
        requestUrlParam.put("js_code", code); //小程序调用wx.login返回的code
        requestUrlParam.put("grant_type", SystemConstant.grantType);    //默认参数

//        JSONObject jsonObject = JSON.parseObject(loginService.sentPost(requestUrlParam));
        return loginService.sentPost(requestUrlParam);
    }
}
