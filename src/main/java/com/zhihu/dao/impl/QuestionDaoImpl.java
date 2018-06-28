package com.zhihu.dao.impl;

import com.zhihu.dao.QuestionDao;
import com.zhihu.pojo.Question;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tzz
 * @Package com.zhihu.dao.impl
 * @Name QuestionDaoImpl
 */
@Repository
public class QuestionDaoImpl implements QuestionDao {
    @Resource
    private SessionFactory sessionFactory;


    @Override
    public List<Question> findAll() {
        String hql = "from Question q order by q.id";
        return sessionFactory.getCurrentSession().createQuery(hql,Question.class).getResultList();
    }
}
