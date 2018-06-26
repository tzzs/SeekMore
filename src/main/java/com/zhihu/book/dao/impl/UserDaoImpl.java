package com.zhihu.book.dao.impl;

import com.zhihu.book.dao.UserDao;
import com.zhihu.book.pojo.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author tzz
 * @Package com.zhihu.book.dao.impl
 * @Name UserDaoImpl
 */
@Repository

public class UserDaoImpl implements UserDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public User login(String userName, String userPassword) {
        String hql = "from User u where u.userName=:userName and u.userPassword=:userPassword";
        return sessionFactory.getCurrentSession().createQuery(hql, User.class).setParameter("userName", userName).setParameter("userPassword", userPassword).uniqueResult();
    }


}
