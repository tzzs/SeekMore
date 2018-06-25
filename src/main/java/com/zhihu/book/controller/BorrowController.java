package com.zhihu.book.controller;

import com.zhihu.book.pojo.Record;
import com.zhihu.book.pojo.Message;
import com.zhihu.book.service.BorrowService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author tzz
 * @Package com.zt.book.controller
 * @Name BorrowController
 */
@Controller
@RequestMapping("/borrows")
public class BorrowController {
    @Resource
    private BorrowService borrowService;

    @RequestMapping("/borrow")
    @ResponseBody
    public Message borrow(Record record) {
        try {
            return borrowService.borrow(record);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message("系统异常，借阅失败");
        }
    }
}
