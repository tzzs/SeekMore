package com.zt.book.pojo;


import javax.persistence.*;
import java.io.Serializable;
/**
 *
 *@author THY
 *@create 2018/6/25
 **/
@Entity
@Table(name = "message")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(length = 11)
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private String publisher;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private String reciever;
    
    @Column(length = 300)
    private String mContent;
    
    @Column(length = 40)
    private String mType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }
}
