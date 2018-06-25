package com.zhihu.book.controller;

import com.zhihu.book.pojo.User;
import com.zhihu.book.service.UserService;
import com.zhihu.book.pojo.Message;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tzz
 */
@Controller
@RequestMapping("/users")
public class UserController {

    //注解 声明Service对象
    @Resource
    private UserService userService;


    @RequestMapping("/login")
    public ModelAndView login(User user, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        User u = userService.login(user);
        if (u != null) {//重定向 redirect:
            request.getSession().setAttribute("u", u);
            mav.setViewName("/index.jsp");
        } else {
            mav.addObject("msg", "用户名或者密码错误");
            mav.setViewName("/login.jsp");
        }
        return mav;
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView();
        List<User> users = userService.findAll();
        mav.setViewName("/userList.jsp");
        mav.addObject("users", users);
        return mav;
    }

    @RequestMapping("/findByLike")
    public ModelAndView findByLike(String userName) {
        ModelAndView mav = new ModelAndView();
        List<User> users = userService.findByLike(userName);
        mav.setViewName("/userList.jsp");
        mav.addObject("users", users);
        return mav;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Message addUser(User user) {
        Message msg = new Message();
        try {
            return userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setMsg("系统异常，添加失败");
            return msg;
        }
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public Message deleteUser(String id) {
        try {
            return userService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message("系统异常，删除失败");
        }
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public Message updateUser(User user) {
        try {
            return userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message("系统异常，更新失败");
        }
    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    public Message updatePassword(String id, String newpwd) {
        System.out.println(id + "\n" + newpwd);
        try {
            return userService.updatePassword(id, newpwd);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message("系统异常，密码修改失败");
        }
    }

    @RequestMapping("/upUser")
    @ResponseBody
    public Message upUser(MultipartFile filedata, HttpServletRequest request) {
        Message msg = new Message();
        //声明一个模板对象 先设置为空 目的为了判断excel的版本 2003版后缀。xls 新版为。xlsx
        Workbook book = null;
        try {
            //先判断是否了上传文件
            if (filedata.getSize() == 0) {
                msg.setMsg("请选择上传文件！");
                return msg;
            }
            //判断excel版本
            if (filedata.getOriginalFilename().endsWith(".xlsx")) {
                book = new XSSFWorkbook(filedata.getInputStream());
            } else if (filedata.getOriginalFilename().endsWith(".xls")) {
                book = new HSSFWorkbook(filedata.getInputStream());
            } else {
                msg.setMsg("文件格式错误");
                return msg;
            }
            //获取表格
            Sheet sheet = book.getSheetAt(0);
            //判断sheet文本中是否有数据
            if (sheet.getLastRowNum() < 1) {
                msg.setMsg("无数据，请核对文件");
                return msg;
            }
            //用于存放遍历封装的User
            List<User> users = new ArrayList<>();
            //遍历sheet每行
            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                User user = new User();
                user.setUserName(row.getCell(0).getStringCellValue());
                user.setEmail(row.getCell(1).getStringCellValue());
                user.setPhone(row.getCell(2).getStringCellValue());
                users.add(user);
            }
            userService.addUsers(users);

            msg.setMsg("数据导入成功");
            return msg;
        } catch (Exception e) {
            // e.printStackTrace();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream pout = new PrintStream(out);
            e.printStackTrace(pout);
            String error = new String(out.toByteArray());
            try {
                out.close();
                pout.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            int index = error.indexOf("Duplicate entry");
            int end = error.indexOf("for key 'UNIQUE'");
            String m = error.substring(index + 15, end);
            System.out.println("User:" + m);
            msg.setMsg(m + " 用户名重复");
            // msg.setMsg("系统异常，导入失败！");
            return msg;
        }
    }


    @RequestMapping("/getMd5")
    @ResponseBody
    public String getMd5(String pwd) {
        Md5Hash md5Hash = new Md5Hash(pwd);
        return md5Hash.toString();
    }
}
