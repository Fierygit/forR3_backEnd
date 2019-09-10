package com.Firefly.forR3.entity;

import java.util.Date;

public class InfoDTO {
    private Integer id;

    private String info;

    private  String  string;


    public InfoDTO(){

    }
    public InfoDTO(Integer id, String info, String date) {
        this.id = id;
        this.info = info;
        this.string = date;
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

    public String getDate() {
        return string;
    }

    public void setDate(String date) {
        this.string = date;
    }
}