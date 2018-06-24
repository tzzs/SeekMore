package com.zt.book.dao;

import com.zt.book.pojo.Kind;

import java.util.List;

public interface KindDao {

    Kind findByType(String type);

    List<Kind> findAll();

    void addKind(Kind kind);

    void updateKind(Kind kind);

    void deleteKind(Kind kind);

    Kind findById(String id);
}
