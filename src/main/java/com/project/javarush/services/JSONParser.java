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

    public Map<Integer, Question> parseQuestionMap(InputStream jsonAnswerFile, ObjectMapper mapper) throws IOException {
        return new HashMap<>(mapper.readValue(jsonAnswerFile, new TypeReference<HashMap<Integer, Question>>() {}));
    }

    public Map<Integer, Answer> parseAnswerMap(InputStream jsonAnswerFile, ObjectMapper mapper) throws IOException {
        return new HashMap<>(mapper.readValue(jsonAnswerFile,
                new TypeReference<HashMap<Integer, Answer>>() {
                }));
    }
}
