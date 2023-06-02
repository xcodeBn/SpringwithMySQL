package com.xcode.SpringMysqlREST.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_number")
    private String department_number = String.valueOf(id);
    @Column(name = "department_name")
    private String department_name;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "industryID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Industry industry;

    public Department(){

    }

    public Department(Long id, String department_number, String department_name, Industry industry) {
        this.id = id;
        this.department_number = department_number;
        this.department_name = department_name;
        this.industry = industry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment_number() {
        return department_number;
    }

    public void setDepartment_number(String department_number) {
        this.department_number = department_number;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }
}
