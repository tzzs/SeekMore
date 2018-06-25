package com.zhihu.book.controller;

import com.zhihu.book.pojo.Record;
import com.zhihu.book.service.ReturnService;
import com.zhihu.book.pojo.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tzz
 * @Package com.zt.book.controller
 * @Name returnController
 */
@RequestMapping("/returns")
@Controller
public class ReturnController {

    @Resource
    private ReturnService returnSerivice;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView();
        List<Record> records = returnSerivice.findAll();
        mav.addObject("records", records);
        mav.setViewName("/return.jsp");
        return mav;
    }


    @RequestMapping("/returnBook")
    @ResponseBody
    public Message returnBook(String id) {
        System.out.println(id);
        try {
            return returnSerivice.returnBook(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message("系统异常，还书失败");
        }
    }

    @RequestMapping("/findByLike")
    public ModelAndView findByLike(String userName) {
        ModelAndView mav = new ModelAndView();
        List<Record> records = returnSerivice.findByLike(userName);
        mav.addObject("records",records);
        mav.setViewName("/return.jsp");
        return mav;
    }
}
