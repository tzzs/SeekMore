package com.zhihu.book.dao.impl;

import com.zhihu.book.dao.KindDao;
import com.zhihu.book.pojo.Kind;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tzz
 */
@Repository
public class KindDaoImpl implements KindDao {

    @Resource
    private SessionFactory sessionFactory;


    @Override
    public Kind findByType(String type) {
        String hql = "from Kind k where k.type=:type";
        return sessionFactory.getCurrentSession().createQuery(hql, Kind.class).setParameter("type", type).uniqueResult();
    }

    @Override
    public List<Kind> findAll() {
        String hql = "from Kind k order by k.id";
        return sessionFactory.getCurrentSession().createQuery(hql, Kind.class).getResultList();
    }

    @Override
    public void addKind(Kind kind) {
        sessionFactory.getCurrentSession().persist(kind);
    }

    @Override
    public void updateKind(Kind kind) {
        sessionFactory.getCurrentSession().update(kind);
    }

    @Override
    public void deleteKind(Kind kind) {
        sessionFactory.getCurrentSession().delete(kind);
    }

    @Override
    public Kind findById(String id) {
        String hql = "from Kind k where k.id=:id";
        return sessionFactory.getCurrentSession().createQuery(hql, Kind.class).setParameter("id", id).uniqueResult();
    }
}
