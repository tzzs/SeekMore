package com.zhihu.controller;

import com.zhihu.dao.UserDao;
import com.zhihu.pojo.Message;
import com.zhihu.pojo.UserInfo;
import com.zhihu.service.UserService;
import com.zhihu.utils.sendSms;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
            request.getSession().setAttribute("u", userinfo);
            System.out.println(request.getSession().getAttribute("name"));
            System.out.println(request.getSession().getAttribute("u"));
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

    @RequestMapping("/findMessge")
    public ModelAndView findMessge(HttpServletRequest request){
        ModelAndView mav=new ModelAndView();
        UserInfo user=(UserInfo) request.getSession().getAttribute("u");
        JSONArray users=userService.findMessge(user.getId());
        mav.setViewName("/html/userMessage.jsp");
        mav.addObject("publishes",users);
        return mav;
    }


    @RequestMapping("/checkPswd")
    @ResponseBody
    public Message checkPswd(String oldPassword,HttpServletRequest request){
        Message msg=new Message();
        System.out.println(oldPassword);
        UserInfo user=(UserInfo) request.getSession().getAttribute("u");
        System.out.println(user.getUserPassword());
        try {
            return userService.checkPswd(oldPassword,user);
        }catch (Exception e){
            return msg;
        }
    }

    @RequestMapping("/updatePasw")
    @ResponseBody
    public Message updatePasw(String oldpassword,String password,String newpassword,HttpServletRequest request){
        Message msg=new Message();
        System.out.println(oldpassword);
        UserInfo user=(UserInfo) request.getSession().getAttribute("u");
        try {
            return userService.updatePasw(oldpassword,password,newpassword,user);
        }catch (Exception e){
            e.printStackTrace();
            msg.setMsg("操作异常");
            return msg;
        }
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public Message updateUser(UserInfo user, MultipartFile filedata, HttpServletRequest request){
        Message msg=new Message();
        UserInfo user1=(UserInfo) request.getSession().getAttribute("u");
        user.setUserRole(user1.getUserRole());
        user.setUserIcon(user1.getUserIcon());
        try {
            return userService.updateUser(user,filedata,request);
//              return null;
        }catch (Exception e){
            e.printStackTrace();
            msg.setMsg("修改信息失败，操作异常");
            return msg;
        }
    }
}
