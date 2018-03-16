package com.sys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sys.model.Lesson;
import com.sys.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 课程练习controller
 * @Author: Shanlin Liu
 * @Email: liushanlin1127@163.com
 * @QQ: 757712582
 * @Blog: www.lausl.com
 * @Date: 2017/12/31 14:16
 */
@Controller
@RequestMapping("/lesson")
public class LessonController extends BaseController{

    @Autowired
    private LessonService lessonService;

    /**
     * 练习页面课程分类列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getStageLesson"/*, method = RequestMethod.POST, consumes = "application/json; charset=utf-8"*/)
    public Object getStageLesson(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        List<Lesson> list = new ArrayList<Lesson>();
        list = lessonService.getStageLesson();
        return renderString(response,list);
    }

    /**
     * 根据pid查询所有列表
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getLessonList")
    public Object getLessonList(HttpServletRequest request, HttpServletResponse response){
        String pId = request.getParameter("pId");
        List<Lesson> list = new ArrayList<Lesson>();
        list = lessonService.getLessonList(pId);
        return renderString(response,list);
    }

    /**
     * 根据课程id获取详细课程信息
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "lessonDetails")
    public Object lessonDetails(HttpServletRequest request, HttpServletResponse response){
        String lessonId = request.getParameter("id");
        Lesson lesson = new Lesson();
        lesson = lessonService.lessonDetails(lessonId);
        return renderString(response,lesson);
    }

    @ResponseBody
    @RequestMapping(value = "pageTrun")
    public Object pageTrun(Lesson lesson, HttpServletRequest request, HttpServletResponse response){
        Lesson lessonDetails = lessonService.pageTrun(lesson);
        return renderString(response,lessonDetails);
    }
}
