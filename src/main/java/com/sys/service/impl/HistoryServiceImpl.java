package com.sys.service.impl;

import com.sys.dao.HistoryMapper;
import com.sys.model.History;
import com.sys.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Description:
 * @Author: Shanlin Liu
 * @Email: liushanlin1127@163.com
 * @QQ: 757712582
 * @Blog: www.lausl.com
 * @Date: 2018/1/27 0:04
 */
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    //添加训练历史记录
    public void addTrainHistory(History history) {
        history.preInsert();
        history.setCreateDate(new Date());
        history.setFinishFlag(0);
        historyMapper.insert(history);
    }

    public Map<String, Object> longTrainIime(String openId) {
        Map<String, Object> map = new HashMap<String, Object>();
        BigDecimal totalTime = historyMapper.getTotalTime(openId).divide(new BigDecimal(60), 2).setScale(0, BigDecimal.ROUND_HALF_UP);
        BigDecimal weekTime = historyMapper.getWeekTime(openId).divide(new BigDecimal(60), 2).setScale(0, BigDecimal.ROUND_HALF_UP);
        BigDecimal dayTime = (historyMapper.getThisTime(openId) == null ? BigDecimal.ZERO : historyMapper.getThisTime(openId)).divide(new BigDecimal(60), 2).setScale(0, BigDecimal.ROUND_HALF_UP);
        List<Map<String,Object>> days = historyMapper.getTotalDay(openId);

        map.put("totalTime", totalTime);
        map.put("weekTime", weekTime);
        map.put("dayTime", dayTime);
        map.put("totalDay", days.size());
        return map;
    }
}
