package com.sys.dao.impl;

import com.framework.base.BaseDao;
import com.sys.dao.UserMapper;
import com.sys.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl extends BaseDao<User> implements UserMapper{
    private static final String NS = "com.sys.dao.UserMapper.";

    public int  deleteByPrimaryKey(String id) {
        return 0;
    }

    public int insert(User record) {
        return this.getSqlSession().insert(NS + "insert", record );
    }

    public int insertSelective(User record) {
        return 0;
    }

    public User selectByPrimaryKey(String id) {
        return null;
    }

    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    public int updateByPrimaryKey(User record) {
        return 0;
    }

    public User selectByOpenId(String openId){
        return this.getSqlSession().selectOne(NS + "selectByOpenId",openId);
    }
}
