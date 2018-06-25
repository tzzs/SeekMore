package com.zhihu.book.service.impl;

import com.zhihu.book.dao.BookDao;
import com.zhihu.book.dao.KindDao;
import com.zhihu.book.pojo.Book;
import com.zhihu.book.pojo.Kind;
import com.zhihu.book.pojo.Message;
import com.zhihu.book.service.KindService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author tzz
 */
@Service
@Transactional
public class KindServiceImpl implements KindService {

    @Resource
    private KindDao kindDao;

    @Resource
    private BookDao bookDao;

    @Override
    public List<Kind> findAll() {
        return kindDao.findAll();
    }

    @Override
    public Message addKind(Kind kind) {
        Message msg = new Message();
        String id = UUID.randomUUID().toString().substring(0, 4);
        kind.setId(id);
        if (!(kind.getType().equals("") || kind.getType() == null)) {
            if (kindDao.findByType(kind.getType()) != null) {
                msg.setMsg("类型已存在");
                return msg;
            }
            kindDao.addKind(kind);
            msg.setMsg("添加成功");
        } else {
            msg.setMsg("必须输入类型名字");
        }
        return msg;
    }

    @Override
    public Message updateKind(Kind kind) {
        Message msg = new Message();
        if (!(kind.getType().equals("") || kind.getType() == null)) {
            if (kindDao.findByType(kind.getType()) != null) {
                msg.setMsg("此分类已存在");
                return msg;
            }
            kindDao.updateKind(kind);
            msg.setMsg("更新成功");
        } else {
            msg.setMsg("必须输入类型名字");
        }
        return msg;
    }

    @Override
    public Message deleteKind(String id) {
        Message msg = new Message();
        Kind kind = kindDao.findById(id);
        if (kind != null && !kind.getType().equals("未知")) {
            List<Book> books = bookDao.findById(id);
            Kind k = kindDao.findByType("未知");
            if (k == null) {
                k = new Kind();
                k.setId(UUID.randomUUID().toString().substring(0, 4));
                k.setType("未知");
                kindDao.addKind(k);
            }
            //设置此分类所有book的外键为空
            if (books != null) {
                for (Book book :
                        books) {
                    book.setKind(k);
                    bookDao.updateBook(book);
                }
            }
            kindDao.deleteKind(kind);
            msg.setMsg("删除成功");
        } else {
            msg.setMsg("分类不存在或默认种类不能被删除");
        }
        return msg;
    }
}
