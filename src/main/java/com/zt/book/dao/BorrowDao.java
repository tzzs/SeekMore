package com.zt.book.dao;

import com.zt.book.pojo.Message;
import com.zt.book.pojo.Record;

public interface BorrowDao {

    void borrow(Record record);
}
