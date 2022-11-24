package com.project.javarush.repositories;

import com.project.javarush.entity.Question;

import java.util.Map;

public class QuestionRepository {

    private final Map<Integer, Question> idToQuestion;

    public QuestionRepository(Map<Integer, Question> idToQuestion) {
        this.idToQuestion = idToQuestion;
    }

    public Question findQuestionById(Integer id){
        return idToQuestion.get(id);
    }

}
