package com.sys.dao.impl;

import com.framework.base.BaseDao;
import com.sys.dao.HistoryMapper;
import com.sys.model.History;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: Shanlin Liu
 * @Email: liushanlin1127@163.com
 * @QQ: 757712582
 * @Blog: www.lausl.com
 * @Date: 2018/1/27 0:11
 */
@Service
public class HistoryMapperImpl extends BaseDao<History> implements HistoryMapper {
    private static final String NS = "com.sys.dao.HistoryMapper.";

    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    public int insert(History record) {
        return this.getSqlSession().insert(NS + "insert", record);
    }

    public int insertSelective(History record) {
        return 0;
    }

    public History selectByPrimaryKey(String id) {
        return null;
    }

    public int updateByPrimaryKeySelective(History record) {
        return 0;
    }

    public int updateByPrimaryKey(History record) {
        return 0;
    }

    public BigDecimal getTotalTime(String openId) {
        return this.getSqlSession().selectOne(NS + "getTotalTime", openId);
    }

    public List<Map<String,Object>> getTotalDay(String openId) {
        System.out.printf("1111");
        return this.getSqlSession().selectList(NS + "getTotalDay", openId);
    }

    public BigDecimal getWeekTime(String openId) {
        return this.getSqlSession().selectOne(NS + "getWeekTime", openId);
    }

    public BigDecimal getThisTime(String openId) {
        return this.getSqlSession().selectOne(NS + "getThisTime", openId);
    }
}
