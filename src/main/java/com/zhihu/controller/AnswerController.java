package com.zhihu.controller;

import com.zhihu.service.AnswerService;
import com.zhihu.pojo.Answer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tzz
 * @Package com.zhihu.controller
 * @Name AnswerController
 */
@Controller
@RequestMapping("/answers")
public class AnswerController {
    @Resource
    private AnswerService answerService;


    @RequestMapping("/findAll")
    @ResponseBody
    public List<Answer> answers(){
        return answerService.findAll();
    }

}
