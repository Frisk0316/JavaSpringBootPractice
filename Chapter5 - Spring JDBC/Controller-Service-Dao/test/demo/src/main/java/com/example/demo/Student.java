package com.example.demo;

import java.sql.Date;
import java.sql.Timestamp;

public class Student {
    Integer id;
    String name;
    Long age;
    Double height;
    Float weight;
    boolean educated;
    Date createDate;

    public Long getAge() {
        return this.age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Double getHeight() {
        return this.height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Float getWeight() {
        return this.weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public boolean isEducated() {
        return this.educated;
    }

    public boolean getEducated() {
        return this.educated;
    }

    public void setEducated(boolean educated) {
        this.educated = educated;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateDate(Timestamp timestamp) {
    }

}
