package com.sys.service;

import com.sys.model.Lesson;

import java.util.List;

/**
 * @Description:
 * @Author: Shanlin Liu
 * @Email: liushanlin1127@163.com
 * @QQ: 757712582
 * @Blog: www.lausl.com
 * @Date: 2017/12/31 16:33
 */
public interface LessonService {

    /**
     * 获取所有大类
     * @return
     */
    public List<Lesson> getStageLesson();

    /**
     * 获取所有子列表
     * @param pId
     * @return
     */
    public List<Lesson> getLessonList(String pId);

    /**
     * 根据id获取课程详细信息
     * @param id
     * @return
     */
    public Lesson lessonDetails(String id);

    public Lesson pageTrun(Lesson lesson);
}
