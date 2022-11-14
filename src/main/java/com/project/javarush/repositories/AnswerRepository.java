package com.project.javarush.repositories;


import com.project.javarush.entity.Answer;

import java.util.Map;
import java.util.Optional;

public class AnswerRepository {

    private final Map<Long, Answer> idToAnswer;

    public AnswerRepository(Map<Long, Answer> idToAnswer) {
        this.idToAnswer = idToAnswer;
    }

    public Answer findAnswerById(long id){
        return Optional.ofNullable(idToAnswer.get(id)).get();
    }
}
