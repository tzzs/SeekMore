package com.zhihu.book.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author tzz
 */
@Entity
@Table(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 11)
    private String id;

    @Column(length = 50)
    private String bookName;

    @Column(length = 50)
    private String bookAuthor;

    @Column(length = 100)
    private String intro;

    @Column(length = 50)
    private String address;

    @ManyToOne
    @JoinColumn(name = "kind_id")
    private Kind kind;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName=" + bookName +
                ", bookAuthor='" + bookAuthor +
                ", intro=" + intro +
                ", address=" + address +
                '}';
    }
}
