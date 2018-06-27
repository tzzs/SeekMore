package com.zhihu.book.pojo;

import javax.persistence.*;
import java.util.List;

/**
 * @author tzz
 * @Package com.zhihu.book.pojo
 * @Name User
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(length = 20)
    private String id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private UserInfo userInfo;

    //收藏
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "collect")
    private List<Answer> collects;

    //回答
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "user")
    private List<Answer> answers;



    //提问
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "user")
    private List<Question> questions;

    //评论
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "user")
    private List<Comment> comments;


    //发布
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "publisher")
    private List<Publish> publishes;

    //接收
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "reciever")
    private List<Publish> recieves;
}
