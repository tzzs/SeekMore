package com.zhihu.book.dao;

import com.zhihu.book.pojo.Record;

import java.util.List;

public interface ReturnDao {
    List<Record> findAll();

    Record findById(String id);

    void returnBook(Record record);

    List<Record> findByLike(String userName);
}
