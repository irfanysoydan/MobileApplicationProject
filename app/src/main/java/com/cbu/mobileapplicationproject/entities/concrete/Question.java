package com.cbu.mobileapplicationproject.entities.concrete;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Question extends EntityBase{

    @SerializedName("title")
    private String Title;
    @SerializedName("content")
    private Content Content;
    @SerializedName("tags")
    private List<Tag> Tags;
    @SerializedName("view_count")
    private int ViewCount;
    @SerializedName("rate")
    private int Rate;
    @SerializedName("answers")
    private List<Answer> Answers;

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

    public com.cbu.mobileapplicationproject.entities.concrete.Content getContent() {
        return Content;
    }

    public void setContent(com.cbu.mobileapplicationproject.entities.concrete.Content content) {
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
