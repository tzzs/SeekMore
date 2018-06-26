package com.zt.book.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 *@author THY
 *@create 2018/6/25
 **/
@Entity
@Table(name = "userInfo")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 11)
    private String id;

    @Column(length = 20)
    private String userName;

    @Column(length=40)
    private String userPassword;

    @Column(length = 2)
    private int userSex;

    @Column(length = 40)
    private String userIcon;

    @Column(length = 30)
    private String userEmail;

    @Column(length=11)
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex=" + userSex +
                ", userIcon='" + userIcon + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", phone='" + phone + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @ManyToOne
    @JoinColumn(name = "Role_id")
    private String userRole;
}
