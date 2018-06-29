package com.zhihu.dao;

import com.zhihu.pojo.Comment;

import java.util.List;

public interface CommentDao {
    void addComment(Comment comment);

    List<Comment> findComment(String id);

    List<Comment> findAll();
}
