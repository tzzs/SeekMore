package com.zhihu.service.impl;

import com.zhihu.dao.QuestionDao;
import com.zhihu.pojo.Question;
import com.zhihu.service.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<Question> findAll() {
        return questionDao.findAll();
    }

    @Override
    public void addQuestion() {

    }
}
