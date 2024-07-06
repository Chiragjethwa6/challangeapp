package com.learningChirag.challangesApp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Challange {
    @Id
    private Integer id;

    @Column(name = "challangeMonth")
    private String month;
    private String description;

    public Challange(){

    }

    public Challange(Integer id, String month, String description) {
        this.id = id;
        this.month = month;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
