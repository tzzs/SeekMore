package com.zt.book.pojo;

import javax.persistence.*;
import java.io.Serializable;


/**
 *
 *@author THY
 *@create 2018/6/25
 **/
@Entity
@Table(name="question")
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 11)
    private String id;

    public String getqTitle() {
        return qTitle;
    }

    public void setqTitle(String qTitle) {
        this.qTitle = qTitle;
    }

    public String getqContent() {
        return qContent;
    }

    public void setqContent(String qContent) {
        this.qContent = qContent;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAswer() {
        return aswer;
    }

    public void setAswer(String aswer) {
        this.aswer = aswer;
    }

    @Column(length = 40)
    private String qTitle;

    @Column(length = 20000)
    private String qContent;

    @OneToOne
    @JoinColumn(name = "user_id")
    private String user;

    @OneToMany
    @JoinColumn(name = "aswer_id")
    private String aswer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
