package com.hdw.springboot.entity;

import java.util.Date;
import java.io.Serializable;

public class Message {
    private static final long serialVersionUID = 2128346393707857300L;

    private Integer id;
    private String nickName;
    private String ip;
    private Date insertTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "userName:" + this.nickName;
    }
}
