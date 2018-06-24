package com.zt.book.service.impl;

import com.zt.book.dao.BookDao;
import com.zt.book.dao.BorrowDao;
import com.zt.book.dao.UserDao;
import com.zt.book.pojo.Book;
import com.zt.book.pojo.Message;
import com.zt.book.pojo.Record;
import com.zt.book.pojo.User;
import com.zt.book.service.BorrowService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author tzz
 * @Package com.zt.book.service.impl
 * @Name BorrowServiceImpl
 */
@Service
@Transactional
public class BorrowServiceImpl implements BorrowService {

    @Resource
    private BorrowDao borrowDao;
    @Resource
    private BookDao bookDao;
    @Resource
    private UserDao userDao;

    @Override
    public Message borrow(Record record) {
        Book book = bookDao.findByName(record.getBookName());
        Message msg = new Message();
        if (book != null) {
            User user = userDao.findByName(record.getUserName());
            if (user != null) {
                String id = UUID.randomUUID().toString().substring(0, 4);
                record.setId(id);
                borrowDao.borrow(record);
                msg.setMsg("借书成功");
            } else {
                msg.setMsg("当前用户不存在");
            }
        } else {
            msg.setMsg("此书不存在");
        }
        return msg;
    }
}
