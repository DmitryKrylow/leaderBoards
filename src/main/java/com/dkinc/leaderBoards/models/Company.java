package com.dkinc.leaderBoards.models;


import javax.persistence.*;

@Entity
@Table(name = "companys")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long id;
    @Column
    public String name;
    @Column
    public Integer countWorkers;
    @Column
    public String ownerName;
    @Column
    public Integer levelCompany;

    public Company(){

    }

    public Company(String name, Integer countWorkers, String ownerName, Integer levelCompany) {
        this.name = name;
        this.countWorkers = countWorkers;
        this.ownerName = ownerName;
        this.levelCompany = levelCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountWorkers() {
        return countWorkers;
    }

    public void setCountWorkers(int countWorkers) {
        this.countWorkers = countWorkers;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
