package com.driver;

import java.util.Date;

public class Mail {

    private String message;
    private Date date;
    private String sender;

    public Mail(String message, Date date, String sender) {
        this.message = message;
        this.date = date;
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

}
