package com.niki.pjd.service.mappers;

import com.niki.pjd.dto.InterviewQuestionDto;
import com.niki.pjd.model.InterviewQuestion;

public class InterviewQuestionMapper {

    public InterviewQuestion toInterviewQuestion(InterviewQuestionDto interviewQuestionDto) {
        return new InterviewQuestion(interviewQuestionDto.getQuestion(),
                interviewQuestionDto.getAnswer());
    }

    public InterviewQuestionDto toInterviewQuestionDto(InterviewQuestion interviewQuestion) {
        return new InterviewQuestionDto(
                interviewQuestion.getId(),
                interviewQuestion.getQuestion(),
                interviewQuestion.getAnswer());
    }
}
