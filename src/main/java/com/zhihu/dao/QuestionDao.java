package com.zhihu.dao;

import com.zhihu.pojo.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> findAll();

    void addQuestion(Question question);
}
