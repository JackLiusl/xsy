package com.sys.service.impl;

import com.sys.dao.LessonMapper;
import com.sys.model.Lesson;
import com.sys.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:  课程练习
 * @Author: Shanlin Liu
 * @Email: liushanlin1127@163.com
 * @QQ: 757712582
 * @Blog: www.lausl.com
 * @Date: 2017/12/31 16:34
 */

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonMapper lessonMapper;

    public List<Lesson> getStageLesson() {
        return lessonMapper.getStageLesson();
    }

    public List<Lesson> getLessonList(String pId) {
        return lessonMapper.getLessonList(pId);
    }

    public Lesson lessonDetails(String id) {
        return lessonMapper.lessonDetails(id);
    }

    public Lesson pageTrun(Lesson lesson) {
        return lessonMapper.pageTrun(lesson);
    }
}
