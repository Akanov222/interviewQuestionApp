package com.niki.pjd.initdata;

import com.niki.pjd.controller.InterviewQuestionController;
import com.niki.pjd.model.InterviewQuestion;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class InitDataLoader {

    private final InterviewQuestionController interviewQuestionController;

    public InitDataLoader(InterviewQuestionController interviewQuestionController) {
        this.interviewQuestionController = interviewQuestionController;
    }

    @PostConstruct
    private void init() {
        loadTestData();
    }

    private void loadTestData() {
        interviewQuestionController.createInterviewQuestion(
                new InterviewQuestion("Question test 1","Answer test 1"));
        interviewQuestionController.createInterviewQuestion(
                new InterviewQuestion("Question test 2","Answer test 2"));
        System.out.println("INFO: Test questions are loaded" + System.lineSeparator());
    }
}
