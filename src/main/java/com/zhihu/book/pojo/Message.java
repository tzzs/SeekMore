package com.zhihu.book.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author tzz
 */
public class Message {
    private String msg;

    public Message() {
    }

    public Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
