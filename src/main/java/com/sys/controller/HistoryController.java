package com.sys.controller;

import com.sys.model.History;
import com.sys.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Description: 训练历史记录
 * @Author: Shanlin Liu
 * @Email: liushanlin1127@163.com
 * @QQ: 757712582
 * @Blog: www.lausl.com
 * @Date: 2018/1/25 23:46
 */

@Controller
@RequestMapping("/history")
public class HistoryController extends BaseController{

    @Autowired
    private HistoryService historyService;

    /**
     * 添加训练历史
     * @param response
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addTrainHistory")
    public Object addTrainHistory(History history, HttpServletResponse response, HttpServletRequest request){
        historyService.addTrainHistory(history);
        return renderString(response,true);
    }

    /**
     * 根据用户的openid获取训练时长
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "longTrainIime")
    public Object longTrainIime(HttpServletRequest request, HttpServletResponse response){
        String openId = request.getParameter("openId");
        Map<String,Object> list = historyService.longTrainIime(openId);
        return renderString(response, list);
    }
}
