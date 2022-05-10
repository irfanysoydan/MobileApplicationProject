package com.cbu.mobileapplicationproject.entities.concrete;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question extends EntityBase implements Serializable {

    @SerializedName("title")
    private String Title;
    @SerializedName("content")
    private Content Content;
    @SerializedName("tags")
    private List<Tag> Tags;
    @SerializedName("viewCount")
    private int ViewCount;
    @SerializedName("rate")
    private int Rate;
    @SerializedName("answers")
    private List<Answer> Answers;
    @SerializedName("userId")
    private int UserId;
    @SerializedName("user")
    private User User;

    public Question(String title, Content content, List<Tag> tags, int viewCount, int rate, List<Answer> answers, int userId, User user) {
        Title = title;
        Content = content;
        Tags = tags;
        ViewCount = viewCount;
        Rate = rate;
        Answers = answers;
        UserId = userId;
        User = user;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int rate) {
        Rate = rate;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {

        Title = title;
    }

    public Content getContent() {
        return Content;
    }

    public void setContent(Content content) {
        Content = content;
    }

    public int getViewCount() {
        return ViewCount;
    }

    public void setViewCount(int viewCount) {
        ViewCount = viewCount;
    }

    public List<Tag> getTags() {
        return Tags;
    }

    public void setTags(List<Tag> tags) {
        Tags = tags;
    }

    public List<Answer> getAnswers() {
        return Answers;
    }

    public void setAnswers(List<Answer> answers) {
        Answers = answers;
    }
}
