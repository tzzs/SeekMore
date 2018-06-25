package com.zhihu.book.dao.impl;

import com.zhihu.book.dao.BookDao;
import com.zhihu.book.pojo.Book;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tzz
 * @Package com.zt.book.dao.impl
 * @Name BookDaoImpl
 */
@Repository
public class BookDaoImpl implements BookDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public List<Book> findAll() {
        String hql = "from Book book order by book.bookName";
        return sessionFactory.getCurrentSession().createQuery(hql, Book.class).getResultList();
    }

    @Override
    public void addBook(Book book) {
        sessionFactory.getCurrentSession().persist(book);
    }

    @Override
    public List<Book> findById(String id) {
        String hql = "from Book b where b.kind.id=:id";
        return sessionFactory.getCurrentSession().createQuery(hql, Book.class).setParameter("id", id).getResultList();
    }

    @Override
    public void updateBook(Book book) {
        sessionFactory.getCurrentSession().merge(book);
    }

    @Override
    public List<Book> findByLike(String bookName) {
        String hql = "from Book b where b.bookName like :bookName";
        return sessionFactory.getCurrentSession().createQuery(hql, Book.class).setParameter("bookName", "%" + bookName + "%").getResultList();
    }

    @Override
    public Book findByName(String bookName) {
        String hql = "from Book b where b.bookName=:bookName";
        return sessionFactory.getCurrentSession().createQuery(hql,Book.class).setParameter("bookName",bookName).uniqueResult();
    }

    @Override
    public Book findByBId(String id) {
        String hql = "from Book b where b.id=:id";
        return sessionFactory.getCurrentSession().createQuery(hql,Book.class).setParameter("id",id).uniqueResult();
    }

    @Override
    public void deleteBook(Book book) {
        sessionFactory.getCurrentSession().delete(book);
    }
}
