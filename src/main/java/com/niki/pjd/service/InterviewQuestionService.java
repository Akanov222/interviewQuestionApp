package com.niki.pjd.service;

import com.niki.pjd.model.InterviewQuestion;
import com.niki.pjd.dto.InterviewQuestionDto;
import com.niki.pjd.service.mappers.InterviewQuestionMapper;
import com.niki.pjd.dao.InterviewQuestionStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewQuestionService {

    private final InterviewQuestionMapper interviewQuestionMapper;
    private final InterviewQuestionStorage storage;

    public InterviewQuestionService(InterviewQuestionMapper interviewQuestionMapper,
                                    InterviewQuestionStorage storage) {
        this.interviewQuestionMapper = interviewQuestionMapper;
        this.storage = storage;
    }

    public InterviewQuestion create(InterviewQuestionDto questionDto) {
        InterviewQuestion interviewQuestion = interviewQuestionMapper.toInterviewQuestion(questionDto);
        return storage.createInterviewQuestion(interviewQuestion);
    }

    public List<InterviewQuestionDto> getAll() {
        List<InterviewQuestion> questions = storage.getAll();
        return questions.stream()
                .map(interviewQuestionMapper::toInterviewQuestionDto)
                .toList();
    }
}
