package com.zhihu.pojo;

import javax.persistence.*;

/**
 * @author tzz
 * @Package com.zhihu.book.pojo
 * @Name UserInfo
 */
@Entity
@Table(name = "userInfo")
public class UserInfo {

    @Id
    private String id;

    private String userName;

    private String userPassword;

    private String userSex;

    private String userIcon;

    private String userEmail;

    private String userPhone;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch = FetchType.LAZY)
    private Role userRole;

}
