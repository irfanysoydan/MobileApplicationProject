package com.cbu.mobileapplicationproject.entities.concrete;

import com.google.gson.annotations.SerializedName;

public class Answer extends EntityBase{

    @SerializedName("content")
    private Content Content;
    @SerializedName("question_id")
    private int QuestionId;
    @SerializedName("is_verified")
    private Boolean IsVerified;
    @SerializedName("userId")
    private int UserId;

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

    private User User;

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
