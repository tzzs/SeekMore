package com.zhihu.book.pojo;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author tzz
 * @Package com.zhihu.book.pojo
 * @Name Role
 */
public class Role {
    @Id
    private String id;

    private String rRole;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "userRole")
    private List<UserInfo> userInfos;
}
