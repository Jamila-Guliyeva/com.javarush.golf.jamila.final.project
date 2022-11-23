package com.project.javarush.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.project.javarush.annotation.Generated;

import java.util.List;
import java.util.Objects;
@JsonTypeName
public class Question {

    private Integer id;
    private String questionText;
    private List<Integer> answersIdList;
    private boolean isLast;

    public Question(@JsonProperty(value = "id") Integer id,
                    @JsonProperty(value = "questionText") String questionText,
                    @JsonProperty(value = "answersIdList") List<Integer> answersIdList,
                    @JsonProperty(value = "isLast") boolean isLast) {
        this.id = id;
        this.questionText = questionText;
        this.answersIdList = answersIdList;
        this.isLast = isLast;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getAnswersIdList() {
        return answersIdList;
    }

    public void setAnswersIdList(List<Integer> answersIdList) {
        this.answersIdList = answersIdList;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    @Generated
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Question question = (Question) o;
        return isLast == question.isLast &&
                Objects.equals(id, question.id) &&
                Objects.equals(questionText, question.questionText) &&
                Objects.equals(answersIdList, question.answersIdList);
    }

    @Generated
    @Override
    public int hashCode() {
        return Objects.hash(id, questionText, answersIdList, isLast);
    }
}
