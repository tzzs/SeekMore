package com.zhihu.dao;

import com.zhihu.pojo.UserInfo;

public interface UserDao {
    UserInfo login(String userName, String userPassword);

    UserInfo findByNage(String userName);

    void addUserInfo(UserInfo userInfo);
}
