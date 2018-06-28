package com.zhihu.service;

import com.zhihu.pojo.Message;
import com.zhihu.pojo.UserInfo;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    UserInfo login(UserInfo userInfo);

    Message addUserInfo(UserInfo userInfo);

    Message addPhoneUser(String userPhone, String authCode, HttpServletRequest request);
}
