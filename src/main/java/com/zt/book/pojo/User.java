package com.zt.book.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 *@author THY
 *@create 2018/6/25
 **/
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 11)
    private String id;

    @OneToMany
    @JoinColumn(name = "userInfo_id")
    private String userInfo;

    @OneToMany
    @JoinColumn(name = "collect_id")
    private String collect;

    @OneToMany
    @JoinColumn(name = "answer_id")
    private String answer;

    @OneToMany
    @JoinColumn(name = "question_id")
    private String question;

    @OneToMany
    @JoinColumn(name = "publish_id")
    private String publish;

    @OneToMany
    @JoinColumn(name = "user_id")
    private String receive;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }
}

