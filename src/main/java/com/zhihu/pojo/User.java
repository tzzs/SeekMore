package com.zhihu.pojo;

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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<Answer> getCollects() {
        return collects;
    }

    public void setCollects(List<Answer> collects) {
        this.collects = collects;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Publish> getPublishes() {
        return publishes;
    }

    public void setPublishes(List<Publish> publishes) {
        this.publishes = publishes;
    }

    public List<Publish> getRecieves() {
        return recieves;
    }

    public void setRecieves(List<Publish> recieves) {
        this.recieves = recieves;
    }
}
