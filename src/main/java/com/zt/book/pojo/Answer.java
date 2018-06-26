package com.zt.book.pojo;

import javax.persistence.*;
import java.io.Serializable;
/**
 *
 *@author THY
 *@create 2018/6/25
 **/
@Entity
@Table(name = "answer")
public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 11)
    private String id;

    @Column(length = 20000)
    private String aContent;

    @OneToOne
    @JoinColumn(name = "user_id")
    private String user;

    @OneToMany
    @JoinColumn(name = "comment_id")
    private String comment;

    @Column(length = 10000)
    private int like;

    public String getaContent() {
        return aContent;
    }

    public void setaContent(String aContent) {
        this.aContent = aContent;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private String collect;
}
