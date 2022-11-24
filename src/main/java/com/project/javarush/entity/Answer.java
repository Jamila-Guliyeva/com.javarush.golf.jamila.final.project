package com.project.javarush.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.project.javarush.annotation.Generated;

import java.util.Objects;

@JsonTypeName
public class Answer {
    private String answerText;
    private Integer id;
    private Integer nextQuestionId;


    public Answer(@JsonProperty(value = "answerText") String answerText,
                  @JsonProperty(value = "id") Integer id,
                  @JsonProperty(value = "nextQuestionId") Integer nextQuestionId) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNextQuestionId() {
        return nextQuestionId;
    }

    public void setNextQuestionId(Integer nextQuestionId) {
        this.nextQuestionId = nextQuestionId;
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
        Answer answer = (Answer) o;
        return Objects.equals(answerText, answer.answerText) &&
                Objects.equals(id, answer.id) &&
                Objects.equals(nextQuestionId, answer.nextQuestionId);
    }

    @Generated
    @Override
    public int hashCode() {
        return Objects.hash(answerText, id, nextQuestionId);
    }
}
