package com.zhihu.controller;

import com.zhihu.dao.UserDao;
import com.zhihu.pojo.Message;
import com.zhihu.pojo.UserInfo;
import com.zhihu.service.UserService;
import com.zhihu.utils.sendSms;
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

    @Resource
    private UserDao userDao;


    @RequestMapping("/login")
    @ResponseBody
    public Message login(UserInfo userInfo, HttpServletRequest request) {
        Message msg = new Message();
        // userInfo.setUserName(userInfo.getUserName().substring(0,userInfo.getUserName().length()-1));
        System.out.println(userInfo.getUserName());
        UserInfo userinfo = userService.login(userInfo);
        System.out.println(userinfo.toString());
        if (userinfo.getUserName() == null) {
            msg.setMsg("false");
        } else {
            msg.setMsg("true");
            request.getSession().setAttribute("name", userInfo.getUserName());
            // UserInfo u = userDao.findByName(userInfo.getUserName());
            // request.getSession().setAttribute("u", u);
            // System.out.println(request.getSession().getAttribute("name"));
        }
        return msg;
    }


    @RequestMapping("/register")
    @ResponseBody
    public Message register(String account, String password, HttpServletRequest request) {
        System.out.println(account + "******" + password);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(account);
        userInfo.setUserPassword(password);
        Message msg = userService.addUserInfo(userInfo);
        System.out.println(msg.getMsg());
        if (msg.getMsg().equals("true")) {
            request.getSession().setAttribute("name", account);
            UserInfo u = userDao.findByName(account);
            request.getSession().setAttribute("u", u);
        }
        return msg;
    }

    @RequestMapping("/getAuthCode")
    @ResponseBody
    public Message getAuthCode(String userPhone, HttpServletRequest request) {
        Message msg = new Message();
        //后台返回的验证码
        int ac = sendSms.sendCode(userPhone);
        if (ac == 0) {
            msg.setMsg("验证码发送失败");
        } else {
            msg.setMsg("验证码发送成功，请注意查收");
            request.getSession().setAttribute("authCode", ac);
        }

        return msg;
    }

    @RequestMapping("/pRegister")
    @ResponseBody
    public Message pRegister(String userPhone, String authCode, HttpServletRequest request) {
        System.out.println(userPhone + "******" + authCode);
        Message msg = new Message();
        try {
            msg = userService.addPhoneUser(userPhone, authCode, request);
            request.getSession().setAttribute("name", userPhone);
            UserInfo u = userDao.findByName(userPhone);
            request.getSession().setAttribute("u", u);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setMsg("系统异常，注册失败");
        }
        return msg;
    }
}
