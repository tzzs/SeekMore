package com.zhihu.book.service.impl;

import com.zhihu.book.service.BookService;
import com.zhihu.book.dao.BookDao;
import com.zhihu.book.dao.KindDao;
import com.zhihu.book.pojo.Book;
import com.zhihu.book.pojo.Kind;
import com.zhihu.book.pojo.Message;
import com.zhihu.book.utils.UpUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * @author tzz
 * @Package com.zt.book.service.impl
 * @Name BookServiceImpl
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Resource
    private BookDao bookDao;

    @Resource
    private KindDao kindDao;

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Message addBook(Book book, String type, MultipartFile filedata, HttpServletRequest request) {
        Message msg = new Message();
        Book b = bookDao.findByName(book.getBookName());
        if (b == null) {
            String id = UUID.randomUUID().toString().substring(0, 4);
            book.setId(id);
            Kind kind = kindDao.findByType(type);
            if (kind == null) {
                kind = new Kind();
                String kid = UUID.randomUUID().toString().substring(0, 4);
                kind.setId(kid);
                kind.setType(type);
                kindDao.addKind(kind);
            }
            book.setKind(kind);

            //判断上传文件
            if (filedata.getSize() > 0) {
                String src = UpUtils.getSrc(filedata, request);
                book.setAddress(src);
            } else {
                book.setAddress("");
            }

            bookDao.addBook(book);
            msg.setMsg("添加成功");
        } else {
            msg.setMsg("此书已存在");
        }
        return msg;
    }

    @Override
    public Message updateBook(Book book, String type, MultipartFile filedata, HttpServletRequest request) {
        Kind kind = kindDao.findByType(type);
        Book b = bookDao.findByBId(book.getId());
        System.out.println("b:" + b.toString());
        Book bk = bookDao.findByName(book.getBookName());
        if (bk != null && !bk.getId().equals(book.getId())) {
            return new Message("书名重复");
        }
        if (kind == null) {
            kind = new Kind();
            kind.setId(UUID.randomUUID().toString().substring(0, 4));
            kind.setType(type);
            kindDao.addKind(kind);
        }
        book.setKind(kind);

        //判断上传文件是否为空
        String src = UpUtils.getSrc(filedata, request);
        System.out.println(filedata.getSize());
        if (filedata.getSize() > 0) {
            book.setAddress(src);
        } else {
            book.setAddress(b.getAddress());
        }

        System.out.println(book.toString());

        bookDao.updateBook(book);
        return new Message("修改成功");
    }

    @Override
    public List<Book> findByLike(String bookName) {
        return bookDao.findByLike(bookName);
    }

    @Override
    public Message deleteBook(String id) {
        Message msg = new Message();
        Book book = bookDao.findByBId(id);
        if (book == null) {
            msg.setMsg("已被删除或此书不存在");
        } else {
            bookDao.deleteBook(book);
            msg.setMsg("删除成功");
        }
        return msg;
    }
}
