package com.zhihu.book.service;


import com.zhihu.book.pojo.Kind;
import com.zhihu.book.pojo.Message;

import java.util.List;

public interface KindService {

    List<Kind> findAll();

    Message addKind(Kind kind);

    Message updateKind(Kind kind);

    Message deleteKind(String id);
}
