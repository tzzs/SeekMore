package com.zhihu.book.controller;

import com.zhihu.book.service.BookService;
import com.zhihu.book.pojo.Book;
import com.zhihu.book.pojo.Message;
import com.zhihu.book.utils.UpUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author tzz
 * @Package com.zt.book.controller
 * @Name BookController
 */
@Controller
@RequestMapping("/books")
public class BookController {
    @Resource
    private BookService bookService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView();
        List<Book> books = bookService.findAll();
        mav.addObject("books", books);
        // request.getSession().setAttribute("books", books);
        mav.setViewName("/book.jsp");
        return mav;
    }

    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
        List<Book> books = bookService.findAll();
        mav.addObject("books", books);
        mav.setViewName("/home.jsp");
        return mav;
    }


    @RequestMapping("/findByLike")
    public ModelAndView findByLike(String bookName) {
        ModelAndView mav = new ModelAndView();
        List<Book> books = bookService.findByLike(bookName);
        mav.addObject("books", books);
        mav.setViewName("/book.jsp");
        // request.getSession().setAttribute("books", books);
        return mav;
    }

    @RequestMapping("/addBook")
    public ModelAndView addBook(Book book, String type, MultipartFile filedata, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        try {
            Message msg = bookService.addBook(book, type, filedata, request);
            mav.addObject("msg", msg);
            List<Book> books = bookService.findAll();
            mav.setViewName("/book.jsp");
            mav.addObject("books", books);
            // request.getSession().setAttribute("books", books);
            return mav;
        } catch (Exception e) {
            e.printStackTrace();
            Message msg = new Message();
            msg.setMsg("系统异常");
            mav.addObject("msg", msg);
            List<Book> books = bookService.findAll();
            mav.addObject("books", books);
            mav.setViewName("/book.jsp");
            return mav;
        }
    }

    @RequestMapping("/updateBook")
    @ResponseBody
    public Message updateBook(Book book, String type, MultipartFile filedata, HttpServletRequest request) {
        try {
            return bookService.updateBook(book, type, filedata, request);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message("更新失败");
        }
    }

    // @RequestMapping("/updateBook")
    // public ModelAndView updateBook(Book book, String type, MultipartFile filedata, HttpServletRequest request) {
    //     ModelAndView mav = new ModelAndView();
    //     try {
    //         Message msg = bookService.updateBook(book,type,filedata,request);
    //         mav.addObject("msg", msg);
    //         List<Book> books = bookService.findAll();
    //         mav.addObject("books", books);
    //         mav.setViewName("/book.jsp");
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         mav.addObject("msg", new Message("更新失败"));
    //         List<Book> books = bookService.findAll();
    //         mav.addObject("books", books);
    //         mav.setViewName("/book.jsp");
    //     }
    //     return mav;
    // }

    @RequestMapping("/deleteBook")
    @ResponseBody
    public Message deleteBook(String id) {
        try {
            return bookService.deleteBook(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message("系统异常");
        }
    }

    @RequestMapping("/up")
    public void up(MultipartFile filedata, HttpServletRequest request) {
        String src = UpUtils.getSrc(filedata, request);
        System.out.println(src);
    }
}
