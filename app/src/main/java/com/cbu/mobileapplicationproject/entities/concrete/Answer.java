package com.cbu.mobileapplicationproject.entities.concrete;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Answer extends EntityBase implements Serializable {

    @SerializedName("contentId")
    private int ContentId;
    @SerializedName("content")
    private Content Content;
    @SerializedName("questionId")
    private int QuestionId;
    @SerializedName("isVerified")
    private Boolean IsVerified;
    @SerializedName("userId")
    private int UserId;

    private User User;

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
    }

    public int getContentId() {
        return ContentId;
    }

    public void setContentId(int contentId) {
        ContentId = contentId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public Content getContent() {
        return Content;
    }

    public void setContent(Content content) {
        this.Content = content;
    }

    public int getQuestionId() {
        return QuestionId;
    }

    public void setQuestionId(int questionId) {
        QuestionId = questionId;
    }

    public Boolean getVerified() {
        return IsVerified;
    }

    public void setVerified(Boolean verified) {
        IsVerified = verified;
    }
}
