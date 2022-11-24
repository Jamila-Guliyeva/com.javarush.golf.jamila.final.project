package com.project.javarush.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.javarush.services.JSONParser;


public class ApplicationRepository {

    private final ObjectMapper mapper = new ObjectMapper();
    private final JSONParser parser = new JSONParser();

    public QuestionRepository getQuestionRepository(String filename) {
        return new QuestionRepository(parser.parseQuestionMap
                (ApplicationRepository.class.getClassLoader().getResourceAsStream(filename), mapper));
    }

    public AnswerRepository getAnswerRepository(String filename) {
        return new AnswerRepository(parser.parseAnswerMap
                (ApplicationRepository.class.getClassLoader().getResourceAsStream(filename), mapper));
    }
}
