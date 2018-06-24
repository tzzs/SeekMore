package com.zt.book.dao;

import com.zt.book.pojo.Record;

import java.util.List;

public interface ReturnDao {
    List<Record> findAll();

    Record findById(String id);

    void returnBook(Record record);

    List<Record> findByLike(String userName);
}
