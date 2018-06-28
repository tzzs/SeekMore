package com.zhihu.service;

import com.zhihu.pojo.Question;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface QuestionService {

    List<Question> findAll();

    void addQuestion(String title, String content, HttpServletRequest request);


    List<Question> findByLike(String qTitle);
}
