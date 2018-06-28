package com.zhihu.service;

import com.zhihu.pojo.Message;
import com.zhihu.pojo.UserInfo;

public interface UserService {
    UserInfo login(UserInfo userInfo);

    Message addUserInfo(UserInfo userInfo);
}
