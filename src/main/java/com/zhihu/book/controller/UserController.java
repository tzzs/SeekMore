package com.zhihu.book.controller;

import com.zhihu.book.pojo.Message;
import com.zhihu.book.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author tzz
 * @Package com.zhihu.book.controller
 * @Name UserController
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;

    public Message login() {
        Message msg = new Message();

        return msg;
    }
}
