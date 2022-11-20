package com.project.javarush.repositories;

import com.project.javarush.entity.Question;

import java.util.Map;
import java.util.Optional;

public class QuestionRepository {

    private final Map<Integer, Question> idToQuestion;

    public QuestionRepository(Map<Integer, Question> idToQuestion) {
        this.idToQuestion = idToQuestion;
    }

    public Question findAQuestionById(Integer id){
        return idToQuestion.get(id);
    }

    public Map<Integer, Question> getIdToQuestion() {
        return idToQuestion;
    }

    @Override
    public String toString() {
        return "QuestionRepository{" +
                "idToQuestion=" + idToQuestion +
                '}';
    }
}
