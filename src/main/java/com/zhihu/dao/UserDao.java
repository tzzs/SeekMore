package com.zhihu.dao;

import com.zhihu.pojo.User;
import com.zhihu.pojo.UserInfo;

public interface UserDao {

    UserInfo findByName(String userName);

    void addUserInfo(UserInfo userInfo);

    void addUser(User user);

    UserInfo login(String userName, String userPassword);

    User findByUiId(String id);
}
