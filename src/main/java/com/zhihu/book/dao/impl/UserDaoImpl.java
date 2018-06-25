package com.zhihu.book.dao.impl;

import com.zhihu.book.dao.UserDao;
import com.zhihu.book.pojo.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tzz
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

    @Override
    public User findByName(String userName) {
        String hql = "from User u where u.userName=:userName";
        return sessionFactory.getCurrentSession().createQuery(hql, User.class).setParameter("userName", userName).uniqueResult();
    }

    @Override
    public List<User> findAll() {
        String hql = "from User u order by u.userName";
        return sessionFactory.getCurrentSession().createQuery(hql, User.class).getResultList();
    }

    @Override
    public List<User> findByLike(String userName) {
        String hql = "from User u where u.userName like :userName order by u.id";
        return sessionFactory.getCurrentSession().createQuery(hql, User.class).setParameter("userName", "%" + userName + "%").getResultList();
    }

    @Override
    public User findById(String id) {
        String hql = "from User u where u.id=:id";
        return sessionFactory.getCurrentSession().createQuery(hql, User.class).setParameter("id", id).uniqueResult();
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().merge(user);
    }
}
