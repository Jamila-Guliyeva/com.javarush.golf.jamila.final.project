package com.project.javarush.repositories;


import com.project.javarush.entity.Answer;

import java.util.Map;


public class AnswerRepository {

    private final Map<Integer, Answer> idToAnswer;

    public AnswerRepository(Map<Integer, Answer> idToAnswer) {
        this.idToAnswer = idToAnswer;
    }

    public Answer findAnswerById(Integer id){
        return idToAnswer.get(id);
    }

    public Map<Integer, Answer> getIdToAnswer() {
        return idToAnswer;
    }
}