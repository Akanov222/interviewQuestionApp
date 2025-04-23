package com.niki.pjd.initdata;

import com.niki.pjd.controller.InterviewQuestionController;
import com.niki.pjd.dto.InterviewQuestionDto;

public class InitDataLoader {

    private final InterviewQuestionController interviewQuestionController;

    public InitDataLoader(InterviewQuestionController interviewQuestionController) {
        this.interviewQuestionController = interviewQuestionController;
        loadTestData();
    }

    private void loadTestData() {
        interviewQuestionController.createInterviewQuestion(
                new InterviewQuestionDto("Question test 1","Answer test 1"));
        interviewQuestionController.createInterviewQuestion(
                new InterviewQuestionDto("Question test 2","Answer test 2"));
        System.out.println("INFO: Test questions are loaded" + System.lineSeparator());
    }
}
