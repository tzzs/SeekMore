package com.zhihu.controller;

import com.zhihu.pojo.Answer;
import com.zhihu.pojo.Comment;
import com.zhihu.pojo.Message;
import com.zhihu.pojo.Question;
import com.zhihu.service.AnswerService;
import com.zhihu.service.CommentService;
import com.zhihu.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author tzz
 * @Package com.zhihu.controller
 * @Name QuestionController
 */
@Controller
@RequestMapping("/questions")
public class QuestionController {
    @Resource
    private QuestionService questionService;

    @Resource
    private CommentService commentService;

    @Resource
    private AnswerService answerService;


    @RequestMapping("/findAll")
    @ResponseBody
    public List<Question> findAll() {
        return questionService.findAll();
    }

    @RequestMapping("/addQuestion")
    @ResponseBody
    public Message addQuestion(String title, String content , HttpServletRequest request) {
        Message msg = new Message();
        try{
            questionService.addQuestion(title,content,request);
            msg.setMsg("添加完成");
        }catch (Exception e){
            e.printStackTrace();
            msg.setMsg("添加失败");
        }
        return msg;
    }


    @RequestMapping("/findByLike")
    @ResponseBody
    public List<Question> findByLike(String qTitle){
        System.out.println("qTitle:"+qTitle);
        return questionService.findByLike(qTitle);
    }




    @RequestMapping("/findByLike2")
    public ModelAndView findByLike2(String qName) {
        ModelAndView mav = new ModelAndView();
        List<Question> questions = questionService.findByLike2(qName);
        mav.setViewName("/answer/html/Answer.jsp");
        mav.addObject("questions", questions);
        return mav;
    }

    @RequestMapping("/addQuestion2")
    @ResponseBody
    public Message addQuestion2() {
        Message msg = new Message();
        return msg;
    }

    @RequestMapping("/findQuestion2")
    @ResponseBody
    public ModelAndView findQuestion(String id) {
        ModelAndView mav = new ModelAndView();
        Question question = questionService.findQuestion(id);
        if (question != null) {
//            List<Answer> answers = answerService.findAnswer(question.getId());
            List<Answer> answers = answerService.findAll();
//            List<Comment> comments = commentService.findComment(question.getId());
//            mav.addObject("comments",comments);
            if (answers != null) {
                List<Comment> comments = commentService.findAll();
                mav.addObject("comments", comments);
            }
            mav.addObject("answers", answers);
        }
        mav.addObject("question", question);
        mav.setViewName("/answer/html/Answer.jsp");
        return mav;
    }

}
