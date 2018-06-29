package com.zhihu.service;

import com.zhihu.pojo.Comment;
import com.zhihu.pojo.Message;

import java.util.List;

public interface CommentService {
    Message addComment(String userName, String cCommnet);

    List<Comment> findComment(String id);

    List<Comment> findAll();
}
