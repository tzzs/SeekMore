package com.zhihu.dao;

import com.zhihu.pojo.Publish;
import com.zhihu.pojo.User;
import com.zhihu.pojo.UserInfo;

import java.util.List;

public interface UserDao {

    UserInfo findByName(String userName);

    void addUserInfo(UserInfo userInfo);

    void addUser(User user);

    UserInfo login(String userName, String userPassword);

    User findByUiId(String id);


    void updatePasw(UserInfo user);

    UserInfo findById(String id);

    void updakteUser(UserInfo user);

    List<Publish> findMessge(String id);

    UserInfo findPublish(User publisher);

    User finduserName(String userName);
}
