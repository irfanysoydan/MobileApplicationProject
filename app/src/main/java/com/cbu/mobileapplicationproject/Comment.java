package com.cbu.mobileapplicationproject;

public class Comment {
    private int icon;
    private String user;
    private String text;


    public Comment(int icon, String user, String text) {
        this.icon = icon;
        this.user = user;
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
