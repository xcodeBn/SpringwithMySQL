package com.xcode.SpringMysqlREST.model;

import jakarta.persistence.*;


@Entity
@Table
public class Industry {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long industryID;

    @Column(name = "industry_name")
    private String industryName;


    public Industry(){

    }
    public Industry(long industryID, String industryName) {
        this.industryID = industryID;
        this.industryName = industryName;
    }

    public long getIndustryID() {
        return industryID;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }
}
