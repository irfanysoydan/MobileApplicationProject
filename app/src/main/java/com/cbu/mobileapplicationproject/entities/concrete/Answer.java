package com.cbu.mobileapplicationproject.entities.concrete;

public class Answer extends EntityBase{

    private Content content;
    private int QuestionId;
    private Boolean IsVerified;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
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
