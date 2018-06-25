package com.zhihu.book.dao;

import com.zhihu.book.pojo.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAll();

    void addBook(Book book);

    List<Book> findById(String id);

    void updateBook(Book book);

    List<Book> findByLike(String bookName);

    Book findByName(String bookName);

    Book findByBId(String id);

    void deleteBook(Book book);
}
