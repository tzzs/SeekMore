package com.zt.book.service;

import com.zt.book.pojo.Message;
import com.zt.book.pojo.Record;

import java.util.List;

public interface ReturnService {

    List<Record> findAll();

    Message returnBook(String id);

    List<Record> findByLike(String userName);
}
