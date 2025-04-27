package com.niki.pjd.service;

import com.niki.pjd.model.InterviewQuestion;
import com.niki.pjd.repository.InterviewQuestionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewQuestionService {

    private final InterviewQuestionRepository repository;

    public InterviewQuestionService(InterviewQuestionRepository repository) {
        this.repository = repository;
    }

    public InterviewQuestion create(InterviewQuestion question) {
        return repository.save(question);
    }

    public List<InterviewQuestion> getAll() {
        return repository.findAll();
    }

    @PostConstruct
    public void checkData() {
        System.out.println("Данные в БД:");
        repository.findAll().forEach(System.out::println);
    }
}
