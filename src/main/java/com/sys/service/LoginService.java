package com.sys.service;

import com.alibaba.fastjson.JSONObject;
import com.sys.model.User;

import java.util.Map;

public interface LoginService {
    /**
     * 向指定的url发送post方法获取session_key和openid
     * @param paramMap
     * @return
     */
    public String sentPost(Map<String, ?> paramMap);

    public void insert(JSONObject user);
}