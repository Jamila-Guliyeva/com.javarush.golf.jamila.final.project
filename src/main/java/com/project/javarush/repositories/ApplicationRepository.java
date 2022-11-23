package com.project.javarush.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.javarush.services.JSONParser;

import java.io.IOException;


public class ApplicationRepository {

    private final ObjectMapper mapper = new ObjectMapper();
    private final JSONParser parser = new JSONParser();

    public QuestionRepository getQuestionRepository(String filename) throws IOException {
        return new QuestionRepository(parser.parseQuestionMap
                (ApplicationRepository.class.getClassLoader().getResourceAsStream(filename), mapper));
    }

    public AnswerRepository getAnswerRepository(String filename) throws IOException {
        return new AnswerRepository(parser.parseAnswerMap
                (ApplicationRepository.class.getClassLoader().getResourceAsStream(filename), mapper));
    }
}
