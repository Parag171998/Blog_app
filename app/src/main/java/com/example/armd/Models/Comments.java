package com.example.armd.Models;

import com.google.firebase.database.ServerValue;

public class Comments {

    private String content;
    private String uId;
    private String uName;
    private String uImg;

    private Object timeStamp;

    public Comments() {
    }

    public Comments(String content, String uId, String uName, String uImg) {
        this.content = content;
        this.uId = uId;
        this.uName = uName;
        this.uImg = uImg;

        timeStamp = ServerValue.TIMESTAMP;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuImg() {
        return uImg;
    }

    public void setuImg(String uImg) {
        this.uImg = uImg;
    }

    public Object getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Object timeStamp) {
        this.timeStamp = timeStamp;
    }
}
