package com.project.javarush.entity;

public class Answer {

    private String answerText;
    private long id;
    private long nextQuestionId;


    public Answer(String answerText, long id, long nextQuestionId) {
        this.answerText = answerText;
        this.id = id;
        this.nextQuestionId = nextQuestionId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNextQuestionId() {
        return nextQuestionId;
    }

    public void setNextQuestionId(long nextQuestionId) {
        this.nextQuestionId = nextQuestionId;
    }

}
