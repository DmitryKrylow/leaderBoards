package com.dkinc.leaderBoards.models;


import javax.persistence.*;

@Entity
@Table (name = "company")
public class Company {
    @Column
    public int levelComapny;
    @Column
    public String name;
    @Column
    public int countWorkers;
    @Column
    public String ownerName;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long id;
    public Company(){}

    public Company(String name, int countWorkers, String ownerName, int levelComapny) {
        this.name = name;
        this.countWorkers = countWorkers;
        this.ownerName = ownerName;
        this.levelComapny = levelComapny;
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
