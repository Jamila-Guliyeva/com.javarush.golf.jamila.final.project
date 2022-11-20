package com.project.javarush.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.javarush.entity.Answer;
import com.project.javarush.entity.Question;
import com.project.javarush.repositories.AnswerRepository;
import com.project.javarush.repositories.QuestionRepository;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class JSONParser {
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;


    /*
    MyServlet.class.getClassLoader().getResourceAsStream("my.json")

     */
    public QuestionRepository parseQuestionMap(File jsonQuestionFile){

        File questionListJson = jsonQuestionFile;
        ObjectMapper mapper = new ObjectMapper();
        try {
            questionRepository = new QuestionRepository(mapper.readValue(questionListJson,
                    new TypeReference<HashMap<Integer, Question>>() {
            }));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return questionRepository;
    }

    public AnswerRepository parseAnswerMap(File jsonAnswerFile){
        File answerListJson = jsonAnswerFile;
        ObjectMapper mapper = new ObjectMapper();
        try {
            answerRepository = new AnswerRepository(mapper.readValue(answerListJson,
                    new TypeReference<HashMap<Integer, Answer>>() {
            }));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return answerRepository;
    }
}
