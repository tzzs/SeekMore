package com.zhihu.book.pojo;

import javax.persistence.*;
import java.util.List;

/**
 * @author tzz
 * @Package com.zhihu.book.pojo
 * @Name Role
 */
@Entity
@Table(name = "role")
public class Role {
    @Id
    private String id;

    private String rRole;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "userRole")
    private List<UserInfo> userInfos;
}
