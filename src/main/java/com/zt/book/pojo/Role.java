package com.zt.book.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 *@author THY
 *@create 2018/6/25
 **/

@Entity
@Table(name = "role")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 11)
    private String id;

    @Column(length = 20)
    private String rRole;

    @OneToMany
    @JoinColumn(name = "user_id")
    private String user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getrRole() {
        return rRole;
    }

    public void setrRole(String rRole) {
        this.rRole = rRole;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
