package com.zt.book.dao.impl;

import com.zt.book.dao.BorrowDao;
import com.zt.book.pojo.Record;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author tzz
 * @Package com.zt.book.dao.impl
 * @Name BorrowDaoImpl
 */
@Repository
public class BorrowDaoImpl implements BorrowDao {
    @Resource
    private SessionFactory sessionFactory;


    @Override
    public void borrow(Record record) {
        sessionFactory.getCurrentSession().persist(record);
    }
}
