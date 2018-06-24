package com.zt.book.service;


import com.zt.book.pojo.Kind;
import com.zt.book.pojo.Message;

import java.util.List;

public interface KindService {

    List<Kind> findAll();

    Message addKind(Kind kind);

    Message updateKind(Kind kind);

    Message deleteKind(String id);
}
