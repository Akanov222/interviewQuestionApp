package com.niki.pjd.controller;

import com.niki.pjd.model.InterviewQuestion;
import com.niki.pjd.dto.InterviewQuestionDto;
import com.niki.pjd.service.InterviewQuestionService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InterviewQuestionController {

    private final InterviewQuestionService service;

    public InterviewQuestionController(InterviewQuestionService service) {
        this.service = service;
    }

    public InterviewQuestion createInterviewQuestion(InterviewQuestionDto questionDto) {
        return service.create(questionDto);
    }

    public List<InterviewQuestionDto> getAllInterviewQuestions() {
        return service.getAll();
    }
}
