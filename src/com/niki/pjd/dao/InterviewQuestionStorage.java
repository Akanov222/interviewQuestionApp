package com.niki.pjd.dao;

import com.niki.pjd.dto.InterviewQuestionDto;
import com.niki.pjd.model.InterviewQuestion;

import java.util.List;

public interface InterviewQuestionStorage {

    InterviewQuestion createInterviewQuestion(InterviewQuestion question);

    List<InterviewQuestion> getAll();
}
