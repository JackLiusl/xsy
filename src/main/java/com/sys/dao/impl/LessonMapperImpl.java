package com.sys.dao.impl;

import com.framework.base.BaseDao;
import com.sys.dao.LessonMapper;
import com.sys.model.Lesson;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Shanlin Liu
 * @Email: liushanlin1127@163.com
 * @QQ: 757712582
 * @Blog: www.lausl.com
 * @Date: 2017/12/31 16:40
 */
@Service
public class LessonMapperImpl extends BaseDao<Lesson> implements LessonMapper {
    private static final String NS = "com.sys.dao.LessonMapper.";

    public int insert(Lesson record) {
        return 0;
    }

    public int insertSelective(Lesson record) {
        return 0;
    }

    public List<Lesson> getStageLesson() {
        return this.getSqlSession().selectList(NS + "getStageLesson");
    }

    public List<Lesson> getLessonList(String pId) {
        return this.getSqlSession().selectList(NS + "getLessonList", pId);
    }

    public Lesson lessonDetails(String id) {
        return this.getSqlSession().selectOne(NS + "lessonDetails", id);
    }

    public Lesson pageTrun(Lesson lesson) {
        return this.getSqlSession().selectOne(NS + "pageTrun", lesson);
    }

}
