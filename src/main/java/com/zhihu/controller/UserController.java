package com.zhihu.controller;

import com.zhihu.pojo.Message;
import com.zhihu.pojo.UserInfo;
import com.zhihu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author tzz
 * @Package com.zhihu.controller
 * @Name UserController
 */
@Controller
@RequestMapping("/users")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Message login(UserInfo userInfo, HttpServletRequest request) {
        Message msg = new Message();
        UserInfo userinfo = userService.login(userInfo);
        if (userinfo == null) {
            msg.setMsg("false");
        } else {
            msg.setMsg("true");
            request.getSession().setAttribute("u", userInfo);
        }
        return msg;
    }


    @RequestMapping("/register")
    @ResponseBody
    public Message register(String account, String password, HttpServletRequest request) {
        System.out.println(account+"******"+password);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(account);
        userInfo.setUserPassword(password);
        Message msg = userService.addUserInfo(userInfo);
        System.out.println(msg.getMsg());
        if (msg.getMsg().equals("true")) {
            request.getSession().setAttribute("u", userInfo);
        }
        return msg;
    }

}
