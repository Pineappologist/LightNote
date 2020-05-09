package com.nanasdev.lightnote;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {
    private Date createdDate;
    private Date modifiedDate;
    private String header;
    private String body;

    public Note() {
    }

    public Note(Date date, String header, String body) {
        this.createdDate = date;
        this.header = header;
        this.body = body;
        this.modifiedDate = date;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
