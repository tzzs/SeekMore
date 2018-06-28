package com.zhihu.service.impl;

import com.zhihu.dao.RoleDao;
import com.zhihu.dao.UserDao;
import com.zhihu.pojo.Message;
import com.zhihu.pojo.Role;
import com.zhihu.pojo.User;
import com.zhihu.pojo.UserInfo;
import com.zhihu.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author tzz
 * @Package com.zhihu.service.impl
 * @Name UserServiceImpl
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private RoleDao roleDao;

    @Override
    public UserInfo login(UserInfo userInfo) {
        System.out.println(userInfo.getUserName()+" pwd:"+userInfo.getUserPassword());
        Md5Hash md5Hash = new Md5Hash(userInfo.getUserPassword());
        userInfo.setUserPassword(md5Hash.toString());
        System.out.println(userInfo.getUserName()+" pwd2:"+userInfo.getUserPassword());
        System.out.println(userInfo.toString());

        return userDao.login(userInfo.getUserName(),userInfo.getUserPassword());
        // Md5Hash md5Hash = new Md5Hash(userName);
        //
        // return userDao.login(userName,md5Hash.toString());
    }

    @Override
    public Message addUserInfo(UserInfo userInfo) {
        Message msg = new Message();
        UserInfo userInfo1 = userDao.findByName(userInfo.getUserName());
        if (userInfo1 != null) {
            msg.setMsg("用户名已存在，请重新输入");
        } else {
            String id = UUID.randomUUID().toString().substring(0, 4);
            userInfo.setId(id);
            Md5Hash md5Hash = new Md5Hash(userInfo.getUserPassword());
            userInfo.setUserPassword(md5Hash.toString());

            Role role = roleDao.findByName("用户");
            userInfo.setUserRole(role);

            userInfo.setUserIcon("images/img_1.jpg");

            userDao.addUserInfo(userInfo);
            User user = new User(id, null, null, null, null, null, null);
            userDao.addUser(user);
            msg.setMsg("true");
        }
        System.out.println("service:" + msg.getMsg());
        return msg;
    }

    @Override
    public Message addPhoneUser(String userPhone, String authCode, HttpServletRequest request) {
        Message msg = new Message();
        String code = String.valueOf(request.getSession().getAttribute("authCode"));
        System.out.println(code);
        System.out.println(authCode);
        System.out.println(code.equals(authCode));
        if (authCode.equals(code)) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserPhone(userPhone);
            userInfo.setUserName(userPhone);

            Md5Hash md5Hash = new Md5Hash(authCode);
            userInfo.setUserPassword(md5Hash.toString());

            String id = UUID.randomUUID().toString().substring(0, 4);
            userInfo.setId(id);

            Role role = roleDao.findByName("用户");
            userInfo.setUserRole(role);

            userInfo.setUserIcon("images/img_1.jpg");


            userDao.addUserInfo(userInfo);

            User user = new User(id, null, null, null, null, null, null);
            userDao.addUser(user);
            msg.setMsg("true");
        } else {
            msg.setMsg("验证码错误");
        }
        return msg;
    }


}
