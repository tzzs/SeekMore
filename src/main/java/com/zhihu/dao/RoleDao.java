package com.zhihu.dao;

import com.zhihu.pojo.Role;

public interface RoleDao {
    Role findByName(String name);
}
