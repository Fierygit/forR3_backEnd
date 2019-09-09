package com.Firefly.forR3.entity;

import java.util.Date;

public class Info {
    private Integer id;

    private String info;

    private Date date;


    public Info(){

    }
    public Info(Integer id, String info, Date date) {
        this.id = id;
        this.info = info;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Date getDate1() {
        return date;
    }

    public void setDate1(Date date) {
        this.date = date;
    }
}