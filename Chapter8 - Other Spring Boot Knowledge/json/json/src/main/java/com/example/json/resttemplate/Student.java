package com.example.json.resttemplate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {

    Integer id;
    String name;

    @JsonProperty("contact_phone")
    String contactPhone;

    public String getContactPhone() {
        return this.contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
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
    
}
