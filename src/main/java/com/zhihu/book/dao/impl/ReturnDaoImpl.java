package com.zhihu.book.dao.impl;

import com.zhihu.book.dao.ReturnDao;
import com.zhihu.book.pojo.Record;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tzz
 * @Package com.zt.book.dao.impl
 * @Name ReturnDaoImpl
 */
@Repository
public class ReturnDaoImpl implements ReturnDao {
    @Resource
    private SessionFactory sessionFactory;


    @Override
    public List<Record> findAll() {
        String hql = "from Record r order by r.id";
        return sessionFactory.getCurrentSession().createQuery(hql, Record.class).getResultList();
    }

    @Override
    public Record findById(String id) {
        String hql = "from Record r where r.id=:id";
        return sessionFactory.getCurrentSession().createQuery(hql, Record.class).setParameter("id", id).uniqueResult();
    }

    @Override
    public void returnBook(Record record) {
        sessionFactory.getCurrentSession().delete(record);
    }

    @Override
    public List<Record> findByLike(String userName) {
        String hql = "from Record r where r.userName like :userName";
        return sessionFactory.getCurrentSession().createQuery(hql, Record.class).setParameter("userName", "%" + userName + "%").getResultList();
    }
}
