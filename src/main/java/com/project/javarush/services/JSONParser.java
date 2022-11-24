package com.project.javarush.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.javarush.entity.Answer;
import com.project.javarush.entity.Question;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class JSONParser {

    public Map<Integer, Question> parseQuestionMap(InputStream jsonAnswerFile, ObjectMapper mapper) {
        try {
            return new HashMap<>(mapper.readValue(jsonAnswerFile, new TypeReference<Map<Integer, Question>>() {}));
        } catch (IOException | IllegalArgumentException e) {
            throw new RuntimeException("Parsing Error!");
        }
    }

    public Map<Integer, Answer> parseAnswerMap(InputStream jsonAnswerFile, ObjectMapper mapper) {
        try {
            return new HashMap<>(mapper.readValue(jsonAnswerFile,
                    new TypeReference<Map<Integer, Answer>>() {
                    }));
        } catch (IOException | IllegalArgumentException e) {
            throw new RuntimeException("Parsing Error!");
        }
    }
}
