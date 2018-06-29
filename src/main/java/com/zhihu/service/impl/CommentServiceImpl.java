package com.zhihu.service.impl;

import com.zhihu.dao.CommentDao;
import com.zhihu.dao.UserDao;
import com.zhihu.pojo.Comment;
import com.zhihu.pojo.Message;
import com.zhihu.pojo.User;
import com.zhihu.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentDao commentDao;

    @Resource
    private UserDao userDao;

    public Message addComment(String userName, String cCommnet) {
        Message msg = new Message();
        User user = userDao.finduserName(userName);
        Comment comment = new Comment();
        String id = UUID.randomUUID().toString().substring(0,4);
        comment.setId(id);
        comment.setcComment(cCommnet);
        comment.setLikeNum(12);
        comment.setUser(user);
//        Date d = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        commentDao.addComment(comment);
        msg.setMsg("评论成功");
        return msg;

    }

    public List<Comment> findComment(String id) {

        return commentDao.findComment(id);
    }

    public List<Comment> findAll() {

        return commentDao.findAll();
    }
}
