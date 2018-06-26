package com.zt.book.pojo;


import javax.persistence.*;
import java.io.Serializable;
/**
 *
 *@author THY
 *@create 2018/6/25
 **/
@Entity
@Table(name = "comment")
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 11)
    private String id;

    @Column(length = 20000)
    private String cComment;

    @Column(length = 1000)
    private int like;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private String user;

    public String getcComment() {
        return cComment;
    }

    public void setcComment(String cComment) {
        this.cComment = cComment;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
