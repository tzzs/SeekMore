package com.zhihu.book.service;

import com.zhihu.book.pojo.Record;
import com.zhihu.book.pojo.Message;

import java.util.List;

public interface ReturnService {

    List<Record> findAll();

    Message returnBook(String id);

    List<Record> findByLike(String userName);
}
