package com.zt.book.controller;

import com.zt.book.pojo.Kind;
import com.zt.book.pojo.Message;
import com.zt.book.service.KindService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tzz
 */
@Controller
@RequestMapping("/kinds")
public class KindController {

    @Resource
    private KindService kindService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView();
        List<Kind> kinds = kindService.findAll();
        mav.addObject("kinds", kinds);
        mav.setViewName("/bookKind.jsp");
        return mav;
    }

    @RequestMapping("/addKind")
    @ResponseBody //转换为json返回
    public Message addKind(Kind kind) {
        try {
            return kindService.addKind(kind);
        } catch (Exception e) {
            e.printStackTrace();
            Message msg = new Message();
            msg.setMsg("系统异常");
            return msg;
        }
    }

    @RequestMapping("/updateKind")
    @ResponseBody
    public Message updateKind(String id, String type) {
        try {
            Kind kind = new Kind();
            kind.setId(id);
            kind.setType(type);
            System.out.println(kind.toString());
            return kindService.updateKind(kind);
        } catch (Exception e) {
            e.printStackTrace();
            Message msg = new Message();
            msg.setMsg("系统异常");
            return msg;
        }
    }

    @RequestMapping("/deleteKind")
    @ResponseBody
    public Message deleteKind(String id) {
        System.out.println(id);
        try {
            return kindService.deleteKind(id);
        } catch (Exception e) {
            e.printStackTrace();
            Message msg = new Message();
            msg.setMsg("删除异常");
            return msg;
        }
    }
}
