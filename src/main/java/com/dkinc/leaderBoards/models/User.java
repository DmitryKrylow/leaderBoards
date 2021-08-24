package com.dkinc.leaderBoards.models;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long id;
    @Column
    public String nickname;
    @Column
    public Integer level;
    @Column
    public String email;

    public User() {
    }

    @Override
    public String toString() {
        return nickname + " " + level;
    }

    public User(String nickname, Integer level, String email) {
        this.nickname = nickname;
        this.level = level;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
