package com.zhihu.pojo;

import javax.persistence.*;

/**
 * @author tzz
 * @Package com.zhihu.book.pojo
 * @Name Comment
 */
public class Comment {

    @Id
    private String id;

    private String cComment;

    private int likeNum;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch = FetchType.LAZY)
    private Answer answers;
}