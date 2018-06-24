package com.zt.book.service;

import com.zt.book.pojo.Book;
import com.zt.book.pojo.Message;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BookService {

    List<Book> findAll();

    Message addBook(Book book, String type, MultipartFile filedata, HttpServletRequest request);

    Message updateBook(Book book, String type, MultipartFile filedata, HttpServletRequest request);

    List<Book> findByLike(String bookName);

    Message deleteBook(String id);
}
