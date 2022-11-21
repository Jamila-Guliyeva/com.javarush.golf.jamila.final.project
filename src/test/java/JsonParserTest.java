import com.project.javarush.entity.Answer;
import com.project.javarush.entity.Question;
import com.project.javarush.repositories.AnswerRepository;
import com.project.javarush.repositories.QuestionRepository;
import com.project.javarush.services.JSONParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class JsonParserTest {

    JSONParser parser = new JSONParser();

    AnswerRepository answerRepository = new AnswerRepository(Map.of(2, new Answer("Принять вызов", 2, 4),
            3, new Answer("Отклонить вызов", 3, 10),
            5, new Answer("Подняться на мостик", 5, 9),
            6, new Answer("Отказаться подниматься на мостик", 6, 11),
            9, new Answer("Солгать о себе", 9, 12),
            8, new Answer("Рассказать правду о себе", 8, 13)));

    QuestionRepository questionRepository = new QuestionRepository(Map.of(1, new Question(1, "Ты потерял память. Принять вызов НЛО?", List.of(2, 3), false),
            4, new Question(4, "Ты принял вызов! Поднимаешься на мостик к капитану?", List.of(5, 6), false),
            9, new Question(9, "Ты поднялся на мостик. Кто ты?", List.of(8, 9), false),
            10, new Question(10, "Ты отклонил вызов! Поражение!", List.of(), true),
            11, new Question(11, "Ты не пошел на переговоры! Поражение", List.of(), true),
            12, new Question(12, "Твою ложь разоблачили! Поражение", List.of(), true),
            13, new Question(13, "Ты рассказал правду о себе! Тебя вернули домой", List.of(), true)));
    @Test
    void parseAnswerMapTest(){
        AnswerRepository expected = parser.parseAnswerMap(JsonParserTest.class.getClassLoader().getResourceAsStream("answersList.json"));
        Assertions.assertAll(() ->  Assertions.assertEquals(expected.findAnswerById(2), answerRepository.findAnswerById(2)),
                () -> Assertions.assertEquals(expected.findAnswerById(3), answerRepository.findAnswerById(3)),
                () -> Assertions.assertEquals(expected.findAnswerById(5), answerRepository.findAnswerById(5)),
                () -> Assertions.assertEquals(expected.findAnswerById(6), answerRepository.findAnswerById(6)),
                () -> Assertions.assertEquals(expected.findAnswerById(8), answerRepository.findAnswerById(8)),
                () -> Assertions.assertEquals(expected.findAnswerById(9), answerRepository.findAnswerById(9)));
    }
    @Test
    void parseQuestionMapTest(){
        QuestionRepository expected = parser.parseQuestionMap(JsonParserTest.class.getClassLoader().getResourceAsStream("questionsList.json"));
        Assertions.assertAll(() ->  Assertions.assertEquals(expected.findQuestionById(1), questionRepository.findQuestionById(1)),
                () -> Assertions.assertEquals(expected.findQuestionById(4), questionRepository.findQuestionById(4)),
                () -> Assertions.assertEquals(expected.findQuestionById(9), questionRepository.findQuestionById(9)),
                () -> Assertions.assertEquals(expected.findQuestionById(10), questionRepository.findQuestionById(10)),
                () -> Assertions.assertEquals(expected.findQuestionById(11), questionRepository.findQuestionById(11)),
                () -> Assertions.assertEquals(expected.findQuestionById(12), questionRepository.findQuestionById(12)),
                () -> Assertions.assertEquals(expected.findQuestionById(13), questionRepository.findQuestionById(13)));
    }

}
