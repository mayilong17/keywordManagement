package com.cs.entity;

import java.util.Date;

public class KeyWord {
    private int id;
    private String name;
    private String type;
    private Date createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public KeyWord() {
    }

    public KeyWord(int id, String name, String type, Date createDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "KeyWord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
