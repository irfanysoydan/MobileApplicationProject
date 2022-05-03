package com.cbu.mobileapplicationproject.entities.concrete;

import java.util.ArrayList;

public class Question extends EntityBase{

    private String Title;
    private Content Content;
    private ArrayList<Tag> TagIds;
    private int ViewCount;
    private int Rate;
    private ArrayList<Answer> Answers;

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

    public ArrayList<Tag> getTagIds() {
        return TagIds;
    }

    public void setTagIds(ArrayList<Tag> tagIds) {
        TagIds = tagIds;
    }

    public int getViewCount() {
        return ViewCount;
    }

    public void setViewCount(int viewCount) {
        ViewCount = viewCount;
    }

    public ArrayList<Answer> getAnswers() {
        return Answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        Answers = answers;
    }

}
