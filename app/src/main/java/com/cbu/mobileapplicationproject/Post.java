package com.cbu.mobileapplicationproject;

public class Post {
    private int logo;
    private String name;
    private String date;
    private String title;

    public Post(int logo, String name, String date, String title) {
        this.logo = logo;
        this.name = name;
        this.date = date;
        this.title = title;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
