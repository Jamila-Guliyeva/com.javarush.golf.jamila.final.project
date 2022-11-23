package com.project.javarush.controller;

import com.project.javarush.entity.Answer;
import com.project.javarush.entity.Question;
import com.project.javarush.repositories.AnswerRepository;
import com.project.javarush.repositories.ApplicationRepository;
import com.project.javarush.repositories.QuestionRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "questServlet", value = "/questServlet")
public class QuestServlet extends HttpServlet {
    QuestionRepository questionRepository;
    AnswerRepository answerRepository;
    ApplicationRepository applicationRepository;

    @Override
    public void init() {
        applicationRepository = new ApplicationRepository();

        try {
            questionRepository = applicationRepository.getQuestionRepository("questionsList.json");
            answerRepository = applicationRepository.getAnswerRepository("answersList.json");
            super.init();
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        Integer nextQuestionId;

        if ((request.getParameter("nextQuestionId") != null)) {
            nextQuestionId = Integer.parseInt(request.getParameter("nextQuestionId"));
        } else nextQuestionId = 1;

        Question question = questionRepository.findQuestionById(nextQuestionId);
        Integer questionId = question.getId();
        String questionText = question.getQuestionText();
        boolean isLast = question.isLast();
        List<Integer> answersId = question.getAnswersIdList();
        List<Answer> answers = new ArrayList<>();
        for (Integer answerId : answersId) {
            answers.add(answerRepository.findAnswerById(answerId));
        }

        request.setAttribute("questionId", questionId);
        request.setAttribute("questionText", questionText);
        request.setAttribute("answers", answers);
        request.setAttribute("isLast", isLast);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/quest.jsp");
        try {
            dispatcher.forward(request, response);
        }  catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        String name = request.getParameter("name");

        if (name != null) {
            session.setAttribute("name", name);
        } else {
            try {
                response.sendRedirect("quest.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        doGet(request, response);
    }
}
