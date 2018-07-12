package com.sxsqli.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/*
nid INT PRIMARY KEY AUTO_INCREMENT,
filename VARCHAR(100) NOT NULL,
path VARCHAR(200) NOT NULL,
submittime TIMESTAMP,
userid INT
 */
public class NoteFile implements Serializable {
    private Integer nid;
    private String filename;
    private String path;
    private Timestamp submittime;
    private Integer userid;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Timestamp getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Timestamp submittime) {
        this.submittime = submittime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
