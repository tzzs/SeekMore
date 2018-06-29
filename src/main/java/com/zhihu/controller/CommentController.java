package com.zhihu.controller;


import com.zhihu.pojo.Message;
import com.zhihu.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 *
 *@author THY
 **/
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @RequestMapping("/addComment")
    @ResponseBody
    public Message addComment(String userName, String cCommnet){
        Message msg = new Message();
        System.out.println("asdas"+cCommnet);
        try{
            return commentService.addComment(userName,cCommnet);
        }catch (Exception e){

            msg.setMsg("网络异常");
            return msg;
        }
    }



}
