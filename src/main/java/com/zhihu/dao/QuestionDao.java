package com.zhihu.dao;

import com.zhihu.pojo.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> findAll();

    void addQuestion(Question question);

    List<Question> findByLike(String qTitle);


    List<Question> findByLike2(String qName);

    Question findQuestion(String id);
}
