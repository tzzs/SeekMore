package com.zhihu.dao.impl;

import com.zhihu.dao.UserDao;
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
    public UserInfo login(String userName, String userPassword) {
        String hql = "from UserInfo ui where ui.userName=:userName and ui.userPassword=:userPassword";
        return sessionFactory.getCurrentSession().createQuery(hql, UserInfo.class).setParameter("userName", userName).setParameter("userPassword", userPassword).uniqueResult();
    }

    @Override
    public UserInfo findByNage(String userName) {
        String hql = "from UserInfo ui where ui.userName=:userName";
        return sessionFactory.getCurrentSession().createQuery(hql, UserInfo.class).setParameter("userName", userName).uniqueResult();
    }

    @Override
    public void addUserInfo(UserInfo userInfo) {
        sessionFactory.getCurrentSession().persist(userInfo);
    }
}
