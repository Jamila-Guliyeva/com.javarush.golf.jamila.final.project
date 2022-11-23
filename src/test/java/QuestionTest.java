import com.project.javarush.entity.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

 class QuestionTest {

    Question question = new Question(1, "Ты потерял память. Принять вызов НЛО?", List.of(2, 3), false);

    @Test
    void getQuestionIdTest(){
        Assertions.assertEquals(1, question.getId());
    }

    @Test
    void getQuestionTextTest(){
        Assertions.assertEquals("Ты потерял память. Принять вызов НЛО?", question.getQuestionText());
    }

    @Test
    void getAnswersIdListTest(){
        Assertions.assertEquals(List.of(2, 3), (question.getAnswersIdList()));
    }

    @Test
    void checkIfQuestionIsLast(){
        Assertions.assertEquals(false, question.isLast());
    }

    @Test
    void questionSetIdTest(){
        question.setId(10);
        Assertions.assertEquals(10, question.getId());
    }

    @Test
    void questionSetTextTest(){
        question.setQuestionText("Test");
        Assertions.assertEquals("Test", question.getQuestionText());
    }

    @Test
    void setAnswersIdListTest(){
        question.setAnswersIdList(List.of(5, 7));
        Assertions.assertEquals(List.of(5, 7), question.getAnswersIdList());
    }

    @Test
    void ifQuestionIsLast(){
        boolean originalValue = question.isLast();
        question.setLast(true);
        Assertions.assertEquals(true, question.isLast());
        question.setLast(originalValue);
    }

}
