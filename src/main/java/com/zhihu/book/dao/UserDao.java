package com.zhihu.book.dao;

import com.zhihu.book.pojo.User;

public interface UserDao {

    User login(String userName, String userPassword);
}
