package com.zhihu.book.service;

import com.zhihu.book.pojo.Record;
import com.zhihu.book.pojo.Message;

/**
 * @author tzz
 * @Package com.zt.book.service
 * @Name BorrowService
 */
public interface BorrowService {

    Message borrow(Record record);
}
