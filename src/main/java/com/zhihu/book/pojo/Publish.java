package com.zhihu.book.pojo;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author tzz
 * @Package com.zhihu.book.pojo
 * @Name Publish
 */
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
