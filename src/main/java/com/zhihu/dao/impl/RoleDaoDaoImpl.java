package com.zhihu.dao.impl;

import com.zhihu.dao.RoleDao;
import com.zhihu.pojo.Role;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author tzz
 * @Package com.zhihu.dao.impl
 * @Name RoleDaoDaoImpl
 */
@Repository
public class RoleDaoDaoImpl implements RoleDao {
    @Resource
    private SessionFactory sessionFactory;

    @Override
    public Role findByName(String name) {
        String hql = "from Role r where r.rRole=:name";
        return sessionFactory.getCurrentSession().createQuery(hql, Role.class).setParameter("name", name).uniqueResult();
    }
}
