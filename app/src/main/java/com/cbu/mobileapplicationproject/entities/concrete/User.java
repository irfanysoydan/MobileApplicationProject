package com.cbu.mobileapplicationproject.entities.concrete;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class User extends EntityBase{
    @SerializedName("firstName")
    @Expose
    private String FirstName;
    public String getFirstName() {
        return this.FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public User(String firstName){
        this.FirstName=firstName;
    }

    @SerializedName("name")
    private String Name;
    @SerializedName("surname")
    private String Surname;
    @SerializedName("username")
    private String Username;
    @SerializedName("mail")
    private String Mail;
    @SerializedName("password")
    private String Password;
    @SerializedName("is_verified")
    private boolean IsVerified;
    @SerializedName("auth_level")
    private int AuthLevel;
    private ArrayList<Question> Followings;

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

    public ArrayList<Question> getFollowings() {
        return Followings;
    }

    public void setFollowings(ArrayList<Question> followings) {
        Followings = followings;
    }
}
