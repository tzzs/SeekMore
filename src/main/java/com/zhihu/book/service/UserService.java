package com.zhihu.book.service;

import com.zhihu.book.pojo.User;
import com.zhihu.book.pojo.Message;

import java.util.List;

public interface UserService {

    User login(User user);

    List<User> findAll();

    List<User> findByLike(String userName);

    Message delete(String id);

    Message addUser(User user);

    Message updateUser(User user);

    Message updatePassword(String id, String newPwd);

    void addUsers(List<User> users);
}
