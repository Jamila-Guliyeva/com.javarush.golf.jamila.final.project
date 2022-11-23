import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.javarush.entity.Answer;
import com.project.javarush.entity.Question;
import com.project.javarush.services.JSONParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

class JsonParserTest {

    JSONParser parser = new JSONParser();
    ObjectMapper mapper = new ObjectMapper();

    Map<Integer, Answer> answerRepositoryMap = Map.of(2, new Answer("Принять вызов", 2, 4),
            3, new Answer("Отклонить вызов", 3, 10),
            5, new Answer("Подняться на мостик", 5, 9),
            6, new Answer("Отказаться подниматься на мостик", 6, 11),
            9, new Answer("Солгать о себе", 9, 12),
            8, new Answer("Рассказать правду о себе", 8, 13));

    Map<Integer, Question> questionRepositoryMap = Map.of(1, new Question(1, "Ты потерял память. Принять вызов НЛО?", List.of(2, 3), false),
            4, new Question(4, "Ты принял вызов! Поднимаешься на мостик к капитану?", List.of(5, 6), false),
            9, new Question(9, "Ты поднялся на мостик. Кто ты?", List.of(8, 9), false),
            10, new Question(10, "Ты отклонил вызов! Поражение!", List.of(), true),
            11, new Question(11, "Ты не пошел на переговоры! Поражение", List.of(), true),
            12, new Question(12, "Твою ложь разоблачили! Поражение", List.of(), true),
            13, new Question(13, "Ты рассказал правду о себе! Тебя вернули домой", List.of(), true));
    @Test
    void parseAnswerMapTest() throws IOException {
        Map<Integer, Answer> expected = parser.parseAnswerMap(JsonParserTest.class.getClassLoader().getResourceAsStream("answersList.json"), mapper);
        Assertions.assertAll(() ->  Assertions.assertEquals(expected.get(2), answerRepositoryMap.get(2)),
                () -> Assertions.assertEquals(expected.get(3), answerRepositoryMap.get(3)),
                () -> Assertions.assertEquals(expected.get(5), answerRepositoryMap.get(5)),
                () -> Assertions.assertEquals(expected.get(6), answerRepositoryMap.get(6)),
                () -> Assertions.assertEquals(expected.get(8), answerRepositoryMap.get(8)),
                () -> Assertions.assertEquals(expected.get(9), answerRepositoryMap.get(9)));
    }
    @Test
    void parseQuestionMapTest() throws IOException {
        Map<Integer, Question> expected = parser.parseQuestionMap(JsonParserTest.class.getClassLoader().getResourceAsStream("questionsList.json"), mapper);
        Assertions.assertAll(() ->  Assertions.assertEquals(expected.get(1), questionRepositoryMap.get(1)),
                () -> Assertions.assertEquals(expected.get(4), questionRepositoryMap.get(4)),
                () -> Assertions.assertEquals(expected.get(9), questionRepositoryMap.get(9)),
                () -> Assertions.assertEquals(expected.get(10), questionRepositoryMap.get(10)),
                () -> Assertions.assertEquals(expected.get(11), questionRepositoryMap.get(11)),
                () -> Assertions.assertEquals(expected.get(12), questionRepositoryMap.get(12)),
                () -> Assertions.assertEquals(expected.get(13), questionRepositoryMap.get(13)));
    }
}
