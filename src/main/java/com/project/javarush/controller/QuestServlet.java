package com.project.javarush.controller;

import com.project.javarush.entity.Answer;
import com.project.javarush.entity.Question;
import com.project.javarush.repositories.AnswerRepository;
import com.project.javarush.repositories.QuestionRepository;
import com.project.javarush.services.JSONParser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "questServlet", value = "/questServlet")
public class QuestServlet extends HttpServlet {
    QuestionRepository questionRepository;
    AnswerRepository answerRepository;
    JSONParser jsonParser;

    @Override
    public void init() {
        jsonParser = new JSONParser();
        questionRepository = jsonParser.parseQuestionMap(new File("C:\\Users\\Jama\\Desktop\\Java\\com.javarush.golf.jamila.final.project\\src\\main\\resources\\questionsList.json"));
        answerRepository = jsonParser.parseAnswerMap(new File("C:\\Users\\Jama\\Desktop\\Java\\com.javarush.golf.jamila.final.project\\src\\main\\resources\\answersList.json"));

        try{
            super.init();
        } catch(ServletException e){
            throw new RuntimeException(e);
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
        } catch (RuntimeException e) {
            try {
                response.sendRedirect("/WEB-INF/error.jsp");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String name = request.getParameter("name");

        if (name != null) {
            session.setAttribute("name", name);
        } else {
            try {
                response.sendRedirect("quest.jsp");
            } catch (IOException e) {
                response.sendRedirect("/WEB-INF/error.jsp");
                throw new RuntimeException(e);
            }
        }
        doGet(request, response);
    }
}
