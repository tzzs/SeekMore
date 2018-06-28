package com.zhihu.controller;

import com.zhihu.pojo.Message;
import com.zhihu.pojo.Question;
import com.zhihu.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author tzz
 * @Package com.zhihu.controller
 * @Name QuestionController
 */
@Controller
@RequestMapping("/questions")
public class QuestionController {
    @Resource
    private QuestionService questionService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Question> findAll() {
        return questionService.findAll();
    }

    @RequestMapping("/addQuestion")
    @ResponseBody
    public Message addQuestion(String title, String content , HttpServletRequest request) {
        Message msg = new Message();
        try{
            questionService.addQuestion(title,content,request);
            msg.setMsg("添加完成");
        }catch (Exception e){
            e.printStackTrace();
            msg.setMsg("添加失败");
        }
        return msg;
    }

}
