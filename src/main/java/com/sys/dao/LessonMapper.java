package com.sys.dao;

import com.sys.model.Lesson;

import java.util.List;

public interface LessonMapper {
    int insert(Lesson record);

    int insertSelective(Lesson record);

    List<Lesson> getStageLesson();

    List<Lesson> getLessonList(String pId);

    Lesson lessonDetails(String id);

    Lesson pageTrun(Lesson lesson);
}