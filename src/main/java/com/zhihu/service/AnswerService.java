package com.zhihu.service;

import com.zhihu.pojo.Answer;

import java.util.List;

public interface AnswerService {

    List<Answer> findAll();

    List<Answer> findAnswer(String id);

}
