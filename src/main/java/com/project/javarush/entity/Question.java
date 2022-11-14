package com.project.javarush.entity;

import java.util.List;

public class Question {

    private Long id;
    private String questionText;
    private List<Long> answersIdList;
    private boolean isLast;

    public Question(Long id, String questionText, List<Long> answersIdList, boolean isLast) {
        this.questionText = questionText;
        this.id = id;
        this.answersIdList = answersIdList;
        this.isLast = isLast;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getAnswersIdList() {
        return answersIdList;
    }

    public void setAnswersIdList(List<Long> answersIdList) {
        this.answersIdList = answersIdList;
    }

    public boolean isLast() {
        return isLast;
    }
}
