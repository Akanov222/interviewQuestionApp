package com.niki.pjd.objects;

import com.niki.pjd.cli.CommandLineInterface;
import com.niki.pjd.controller.InterviewQuestionController;
import com.niki.pjd.dao.inmemory.InMemoryInterviewQuestionStorage;
import com.niki.pjd.initdata.InitDataLoader;
import com.niki.pjd.service.mappers.InterviewQuestionMapper;
import com.niki.pjd.dao.InterviewQuestionStorage;
import com.niki.pjd.service.InterviewQuestionService;

public class ObjectsInitializer {
    private final InterviewQuestionStorage interviewQuestionStorage;
    private final InterviewQuestionMapper interviewQuestionMapper;
    private final InterviewQuestionService interviewQuestionService;
    private final InterviewQuestionController interviewQuestionController;
    private final InitDataLoader initDataLoader;
    private final CommandLineInterface commandLineInterface;

    public ObjectsInitializer() {
        this.interviewQuestionStorage = new InMemoryInterviewQuestionStorage();
        this.interviewQuestionMapper = new InterviewQuestionMapper();
        this.interviewQuestionService = new InterviewQuestionService(
                interviewQuestionMapper, interviewQuestionStorage);
        this.interviewQuestionController = new InterviewQuestionController(interviewQuestionService);
        this.commandLineInterface = new CommandLineInterface(interviewQuestionController);
        this.initDataLoader = new InitDataLoader(interviewQuestionController);
    }

    public void run() {
        commandLineInterface.run();
    }
}
