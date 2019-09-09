package com.Firefly.forR3.entity;

import java.util.Date;

public class Usr {
    private Integer id;

    private Integer uid;

    private String ip;

    private Date date;


    public Usr(){

    }
    public Usr(Integer id, Integer uid, String ip, Date date) {
        this.id = id;
        this.uid = uid;
        this.ip = ip;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}