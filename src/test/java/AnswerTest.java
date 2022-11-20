
import com.project.javarush.entity.Answer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnswerTest {

    //"2":{"answerText":"Принять вызов","id":2,"nextQuestionId":4},


    Answer answer = new Answer("Принять вызов", 2, 4);

    @Test
    void getAnswerTextTest(){
        String answerText = answer.getAnswerText();
        Assertions.assertEquals("Принять вызов", answerText);
    }

    @Test
    void getAnswerIdTest(){
        Integer id = answer.getId();
        Assertions.assertEquals(2, id);
    }

    @Test
    void getNexQuestionIdTest(){
        Integer nextQuestionId = answer.getNextQuestionId();
        Assertions.assertEquals(4, nextQuestionId);
    }

    @Test
    void setAnswerTextTest(){
        answer.setAnswerText("Test");
        Assertions.assertEquals("Test", answer.getAnswerText());
    }

    @Test
    void setAnswerIdTest(){
        answer.setId(5);
        Assertions.assertEquals(5, answer.getId());
    }

    @Test
    void setNextQuestionIdTest(){
        answer.setNextQuestionId(7);
        Assertions.assertEquals(7, answer.getNextQuestionId());
    }

    @Test
    void equalsMethodTest(){
        Answer expected = new Answer("Принять вызов", 2, 4);
        Assertions.assertEquals(expected, answer);
    }
}
