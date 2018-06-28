package com.zhihu.dao.impl;

import com.zhihu.dao.UserDao;
import com.zhihu.pojo.User;
import com.zhihu.pojo.UserInfo;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author tzz
 * @Package com.zhihu.dao.impl
 * @Name UserDaoImpl
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public UserInfo findByName(String userName) {
        String hql = "from UserInfo ui where ui.userName=:userName";
        return sessionFactory.getCurrentSession().createQuery(hql, UserInfo.class).setParameter("userName", userName).uniqueResult();
    }

    @Override
    public void addUserInfo(UserInfo userInfo) {
        sessionFactory.getCurrentSession().persist(userInfo);
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    @Override
    public UserInfo login(String userName, String userPassword) {
        String hql = "from UserInfo u where u.userName=:userName and u.userPassword=:userPassword";
        System.out.println(hql + " " + userName + " " + userPassword);
        UserInfo u = sessionFactory.getCurrentSession().createQuery(hql, UserInfo.class).setParameter("userName", userName).setParameter("userPassword", userPassword).uniqueResult();
        System.out.println(u.toString());
        return u;
    }

    @Override
    public User findByUiId(String id) {
        System.out.println("ID:"+id);
        String hql = "from User u where u.id=:id";
        return sessionFactory.getCurrentSession().createQuery(hql, User.class).setParameter("id", id).uniqueResult();
    }
}
