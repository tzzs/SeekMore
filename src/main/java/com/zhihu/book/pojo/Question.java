package com.zhihu.book.pojo;

import javax.persistence.*;
import java.util.List;

/**
 * @author tzz
 * @Package com.zhihu.book.pojo
 * @Name Question
 */
public class Question {

    @Id
    private String id;

    private String qTitle;

    private String qContent;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch = FetchType.LAZY)
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "answers")
    private List<Answer> answers;
}
