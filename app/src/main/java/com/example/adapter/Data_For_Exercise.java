package com.example.adapter;

import java.io.Serializable;

public class Data_For_Exercise implements Serializable {

    //Serializable عشان يبقى قابل للتحويل من نص لاوبجيكت والعكس

    private String date;
    private String name;
    private String body;
    private int followers;
    private int posts;
    private int following;

    public Data_For_Exercise(String date, String name, String body, int followers, int posts, int following) {
        this.date = date;
        this.name = name;
        this.body = body;
        this.followers = followers;
        this.posts = posts;
        this.following = following;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getBody() {
        return body;
    }

    public int getFollowers() {
        return followers;
    }

    public int getPosts() {
        return posts;
    }

    public int getFollowing() {
        return following;
    }
}
