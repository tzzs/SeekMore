package com.zhihu.service.impl;

import com.zhihu.dao.RoleDao;
import com.zhihu.dao.UserDao;
import com.zhihu.pojo.Message;
import com.zhihu.pojo.Role;
import com.zhihu.pojo.UserInfo;
import com.zhihu.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
        Md5Hash md5Hash = new Md5Hash(userInfo.getUserPassword());
        userInfo.setUserPassword(md5Hash.toString());
        return userDao.login(userInfo.getUserName(),userInfo.getUserPassword());
    }

    @Override
    public Message addUserInfo(UserInfo userInfo) {
        Message msg = new Message();
        UserInfo userInfo1 = userDao.findByNage(userInfo.getUserName());
        if (userInfo1!=null){
            msg.setMsg("用户名已存在，请重新输入");
        }else{
            String id = UUID.randomUUID().toString().substring(0,4);
            userInfo.setId(id);
            Md5Hash md5Hash = new Md5Hash(userInfo.getUserPassword());
            userInfo.setUserPassword(md5Hash.toString());

            Role role = roleDao.findByName("用户");
            userInfo.setUserRole(role);

            userDao.addUserInfo(userInfo);
            msg.setMsg("true");
        }
        System.out.println("service:"+msg.getMsg());
        return msg;
    }
}
