package com.cbu.mobileapplicationproject.entities.concrete;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User extends EntityBase implements Serializable{

    @SerializedName("name")
    private String Name;
    @SerializedName("surname")
    private String Surname;
    @SerializedName("username")
    private String Username;
    @SerializedName("email")
    private String Mail;
    @SerializedName("password")
    private String Password;
    @SerializedName("is_verified")
    private boolean IsVerified;
    @SerializedName("auth_level")
    private int AuthLevel;
    @SerializedName("followings")
    private List<Question> Followings;

    public User(String mail, String password) {
        Mail = mail;
        Password = password;
    }

    public User(String name, String surname, String mail, String password) {
        Name = name;
        Surname = surname;
        Mail = mail;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isVerified() {
        return IsVerified;
    }

    public void setVerified(boolean verified) {
        IsVerified = verified;
    }

    public int getAuthLevel() {
        return AuthLevel;
    }

    public void setAuthLevel(int authLevel) {
        AuthLevel = authLevel;
    }

    public List<Question> getFollowings() {
        return Followings;
    }

    public void setFollowings(List<Question> followings) {
        Followings = followings;
    }
}
