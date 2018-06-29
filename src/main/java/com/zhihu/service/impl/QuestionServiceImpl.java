package com.zhihu.service.impl;

import com.zhihu.dao.QuestionDao;
import com.zhihu.dao.UserDao;
import com.zhihu.pojo.Question;
import com.zhihu.pojo.User;
import com.zhihu.pojo.UserInfo;
import com.zhihu.service.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * @author tzz
 * @Package com.zhihu.service.impl
 * @Name QuestionServiceImpl
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
    @Resource
    private QuestionDao questionDao;

    @Resource
    private UserDao userDao;

    @Override
    public List<Question> findAll() {
        return questionDao.findAll();
    }

    @Override
    public void addQuestion(String title, String content, HttpServletRequest request) {
        Question question = new Question();
        question.setqTitle(title);
        question.setqContent(content);
        String id = UUID.randomUUID().toString().substring(0,4);

        question.setId(id);

        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("u");
        System.out.println("idid:"+userInfo.getId());
        User usr = userDao.findByUiId(userInfo.getId());

        question.setUser(usr);

        questionDao.addQuestion(question);
    }

    @Override
    public List<Question> findByLike(String qTitle) {
        return questionDao.findByLike(qTitle);
    }


    @Override
    public List<Question> findByLike2(String qName) {
        return questionDao.findByLike2(qName);
    }

    @Override
    public Question findQuestion(String id) {
        return questionDao.findQuestion(id);
    }
}
