package com.zt.book.service;

import com.zt.book.pojo.Message;
import com.zt.book.pojo.User;

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
