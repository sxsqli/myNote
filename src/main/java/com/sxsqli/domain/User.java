package com.sxsqli.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/*
uid INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(16) NOT NULL UNIQUE,
password CHAR(41) NOT NULL,
registertime TIMESTAMP
 */
public class User implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private Timestamp registertime;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Timestamp registertime) {
        this.registertime = registertime;
    }
}
