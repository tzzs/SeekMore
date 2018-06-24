package com.zt.book.service;

import com.zt.book.pojo.Message;
import com.zt.book.pojo.Record;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tzz
 * @Package com.zt.book.service
 * @Name BorrowService
 */
public interface BorrowService {

    Message borrow(Record record);
}
