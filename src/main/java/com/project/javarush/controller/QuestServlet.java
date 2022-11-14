package com.project.javarush.controller;

import com.project.javarush.entity.Answer;
import com.project.javarush.entity.Question;
import com.project.javarush.repositories.AnswerRepository;
import com.project.javarush.repositories.QuestionRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "questServlet", value = "/questServlet")
public class QuestServlet extends HttpServlet {
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    @Override
    public void init() {
        questionRepository = new QuestionRepository(Map.of(1L, new Question(1L, "Ты потерял память. Принять вызов НЛО?", List.of(2L, 3L), false),
                4L, new Question(4L, "Ты принял вызов! Поднимаешься на мостик к капитану?", List.of(5L, 6L), false),
                9L, new Question(9L, "Ты поднялся на мостик. Кто ты?", List.of(8L, 9L), false),
                10L, new Question(10L, "Ты отклонил вызов! Поражение!", List.of(), true),
                11L, new Question(11L, "Ты не пошел на переговоры! Поражение", List.of(), true),
                12L, new Question(12L, "Твою ложь разоблачили! Поражение", List.of(), true),
                13L, new Question(13L, "Ты рассказал правду о себе! Тебя вернули домой", List.of(), true)));

        answerRepository = new AnswerRepository(Map.of(2L, new Answer("Принять вызов", 2L, 4L),
                3L, new Answer("Отклонить вызов", 3L, 10L),
                5L, new Answer("Подняться на мостик", 5L, 9L),
                6L, new Answer("Отказаться подниматься на мостик", 6L, 11L),
                9L, new Answer("Солгать о себе", 9L, 12L),
                8L, new Answer("Рассказать правду о себе", 8L, 13L)));
        try {
            super.init();
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        Long nextQuestionId;

        if ((request.getParameter("nextQuestionId") != null)){
            nextQuestionId = Long.parseLong(request.getParameter("nextQuestionId"));
        }
        else nextQuestionId = 1L;

        Question question = questionRepository.findAQuestionById(nextQuestionId);
        Long questionId = question.getId();
        String questionText = question.getQuestionText();
        boolean isLast = question.isLast();
        List<Long> answersId = question.getAnswersIdList();
        List<Answer> answers = new ArrayList<>();
        for (Long answerId : answersId) {
            answers.add(answerRepository.findAnswerById(answerId));
        }

        request.setAttribute("questionId", questionId);
        request.setAttribute("questionText", questionText);
        request.setAttribute("answers", answers);
        request.setAttribute("isLast", isLast);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/quest.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");

        if (name != null) {
            session.setAttribute("name", name);
        } else {
            try {
                response.sendRedirect("quest.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        doGet(request, response);
    }
}
