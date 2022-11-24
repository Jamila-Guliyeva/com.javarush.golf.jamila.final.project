
import com.project.javarush.entity.Answer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

 class AnswerTest {
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
        answer.setAnswerText("Test.txt");
        Assertions.assertEquals("Test.txt", answer.getAnswerText());
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
}
