package com.zt.book.dao;

import com.zt.book.pojo.User;

import java.util.List;

public interface UserDao {

    User login(String userName, String userPassword);

    User findByName(String userName);

    List<User> findAll();

    List<User> findByLike(String userName);

    User findById(String id);

    void delete(User user);

    void addUser(User user);

    void update(User user);
}
