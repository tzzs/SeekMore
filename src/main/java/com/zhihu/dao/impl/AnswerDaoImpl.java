package com.zhihu.dao.impl;

import com.zhihu.dao.AnswerDao;
import com.zhihu.pojo.Answer;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tzz
 * @Package com.zhihu.dao.impl
 * @Name AnswerDaoImpl
 */
@Repository
public class AnswerDaoImpl implements AnswerDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public List<Answer> findAll() {
        String hql = "from Answer answer order by answer.id";
        return sessionFactory.getCurrentSession().createQuery(hql,Answer.class).getResultList();
    }
}
