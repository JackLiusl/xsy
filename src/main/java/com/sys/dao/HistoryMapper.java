package com.sys.dao;

import com.sys.model.History;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface HistoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(History record);

    int insertSelective(History record);

    History selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);

    //获取总时长
    BigDecimal getTotalTime(String openId);

    List<Map<String,Object>> getTotalDay(String openId);

    //获取周时长
    BigDecimal getWeekTime(String openId);

    //获取当日时长
    BigDecimal getThisTime(String openId);
}