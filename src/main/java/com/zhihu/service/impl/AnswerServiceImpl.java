package com.zhihu.service.impl;

import com.zhihu.dao.AnswerDao;
import com.zhihu.service.AnswerService;
import com.zhihu.pojo.Answer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tzz
 * @Package com.zhihu.service.impl
 * @Name AnswerServiceImpl
 */
@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {
    @Resource
    private AnswerDao answerDao;

    @Override
    public List<Answer> findAll() {
        return answerDao.findAll();
    }

    @Override
    public List<Answer> findAnswer(String id) {
        return answerDao.findAnswer(id);
    }
}
