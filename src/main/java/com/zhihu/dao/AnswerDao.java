package com.zhihu.dao;

import com.zhihu.pojo.Answer;

import java.util.List;

public interface AnswerDao {
    List<Answer> findAll();

    List<Answer> findAnswer(String id);
}
