package com.zhihu.controller;

import com.zhihu.pojo.Question;
import com.zhihu.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
    public List<Question> findAll(){
        return questionService.findAll();
    }
}
