package com.distro.Container.entity;

import jakarta.persistence.*;

@Entity
@Table(name="container")
public class Container {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="container_code")
    private String containerCode;
    @Column(name="company")
    private String company;

    public Container() {
    }
    public Container(int id, String containerCode, String companyName) {
        this.id = id;
        this.containerCode = containerCode;
        this.company = companyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContainerCode() {
        return containerCode;
    }

    public void setContainerCode(String containerCode) {
        this.containerCode = containerCode;
    }

    public String getCompanyName() {
        return company;
    }

    public void setCompanyName(String companyName) {
        this.company = companyName;
    }


}