package com.sys.service;

import com.sys.model.History;

import java.util.List;
import java.util.Map;

/**
 * @Description:  训练历史列表
 * @Author: Shanlin Liu
 * @Email: liushanlin1127@163.com
 * @QQ: 757712582
 * @Blog: www.lausl.com
 * @Date: 2018/1/26 23:29
 */
public interface HistoryService {

    //添加历史记录
    public void addTrainHistory(History history);

    //获取训练时长
    public Map<String, Object> longTrainIime(String openId);
}
