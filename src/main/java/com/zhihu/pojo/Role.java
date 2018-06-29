package com.zhihu.pojo;

import javax.persistence.*;
import java.util.List;

/**
 * @author tzz
 * @Package com.zhihu.book.pojo
 * @Name RoleDao
 */
@Entity
@Table(name = "role")
public class Role {
    @Id
    private String id;

    private String rRole;

    //fetch = FetchType.LAZY,
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRole")
    private List<UserInfo> userInfos;

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

    public List<UserInfo> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", rRole='" + rRole + '\'' +
                '}';
    }
}
