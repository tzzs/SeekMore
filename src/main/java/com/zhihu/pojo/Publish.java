package com.zhihu.pojo;

import javax.persistence.*;

/**
 * @author tzz
 * @Package com.zhihu.book.pojo
 * @Name Publish
 */
@Entity
@Table(name = "publish")
public class Publish {

    @Id
    private String id;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch = FetchType.LAZY)
    private User publisher;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch = FetchType.LAZY)
    private User reciever;

    private String mContent;

    private String mType;
}
