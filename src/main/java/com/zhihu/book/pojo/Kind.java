package com.zhihu.book.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 图书种类实体
 *
 * @author tzz
 */
@Entity
@Table(name = "kind")
public class Kind implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 11)
    private String id;

    @Column(length = 30)
    private String type;

    @OneToMany(mappedBy = "kind")
    private List<Book> books;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Kind{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", books=" + books +
                '}';
    }
}
