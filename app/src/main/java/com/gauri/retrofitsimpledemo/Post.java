package com.gauri.retrofitsimpledemo;

import com.google.gson.annotations.SerializedName;

class Post {

    private int userid;
    private int id;
    private String title;

    @SerializedName("body")
    private String text;

    public int getUserid(){
        return userid;
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }

    public String getText(){
        return text;
    }
}
