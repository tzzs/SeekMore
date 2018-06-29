package com.zhihu.dao.impl;

import com.zhihu.dao.CommentDao;
import com.zhihu.pojo.Comment;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Resource
    private SessionFactory sessionFactory;

    public void addComment(Comment comment) {
        sessionFactory.getCurrentSession().merge(comment);
    }

    public List<Comment> findComment(String id) {
        String hql = "from Comment c where answer.id=:id";
        return sessionFactory.getCurrentSession().createQuery(hql, Comment.class).setParameter("id", id).getResultList();
    }

    public List<Comment> findAll() {
        String hql = "from Comment c order by c.id";
        return sessionFactory.getCurrentSession().createQuery(hql, Comment.class).getResultList();
    }
}
