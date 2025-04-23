package com.niki.pjd.cli;

import com.niki.pjd.controller.InterviewQuestionController;
import com.niki.pjd.dto.InterviewQuestionDto;

import java.util.List;
import java.util.Scanner;

public class CommandLineInterface {
    public static final String ADD_INTERVIEW_QUESTION_MENU_TEXT = """
            === Добавление интервью вопроса ===
                    введите текст вопроса
                (для возврата введите "menu"):            
            """;
    private final InterviewQuestionController interviewQuestionController;

    private static final String APP_WELCOME_TEXT = "WELCOME TO JAVA INTERVIEW QUESTION APP!";

    public CommandLineInterface(InterviewQuestionController interviewQuestionController) {
        this.interviewQuestionController = interviewQuestionController;
    }

    public static final String APP_MENU_TEXT = """
            Доступные комманды:
                        
            1. list - показать все вопросы
            2. add - добавить вопрос
            3. exit - выйти
            
            Введите комманду:
            """;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        CliCommands input;

        System.out.println(APP_WELCOME_TEXT);

        do {
            System.out.print(APP_MENU_TEXT);
            CliCommandParsingResult cliCommandParsingResult = getInputFromCli(scanner);
            if (!cliCommandParsingResult.successful()) {
                input = cliCommandParsingResult.cliCommand();
                System.out.println(cliCommandParsingResult.errorMessage);
            } else {
                input = cliCommandParsingResult.cliCommand();

                switch (input) {
                    case CliCommands.LIST ->
                            printAllInterviewQuestions(interviewQuestionController.getAllInterviewQuestions());
                    case CliCommands.ADD -> addInterviewQuestion(scanner);
                }
            }
        } while (!input.equals(CliCommands.EXIT));

        List<InterviewQuestionDto> allInterviewQuestions = interviewQuestionController.getAllInterviewQuestions();
        allInterviewQuestions.forEach(System.out::println);
    }

    private void addInterviewQuestion(Scanner scanner) {
        System.out.println(ADD_INTERVIEW_QUESTION_MENU_TEXT);

        System.out.println("Введите вопрос:");
        String question = scanner.nextLine();
        if (question.equalsIgnoreCase(CliCommands.MENU.getLowerCaseName())) {
            return;
        }
        System.out.println("Введите ответ:");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase(CliCommands.MENU.getLowerCaseName())) {
            return;
        }
        interviewQuestionController.createInterviewQuestion(new InterviewQuestionDto(question, answer));
    }

    private static void printAllInterviewQuestions(List<InterviewQuestionDto> questionDtos) {
        System.out.println(questionDtos.size() + " вопросов доступно" + System.lineSeparator());

        int questionNumber = 1;
        for (InterviewQuestionDto question : questionDtos) {
            System.out.println(questionNumber + " " + question + System.lineSeparator());
            questionNumber++;
        }
    }

    private CliCommandParsingResult getInputFromCli(Scanner scanner) {
        CliCommands command;
        try {
            String stringInput = scanner.nextLine().trim().toUpperCase();
            command = CliCommands.valueOf(stringInput);
            return new CliCommandParsingResult(command, true, null);
        } catch (IllegalArgumentException e) {
            return new CliCommandParsingResult(CliCommands.UNRECOGNIZED, false, "Unrecognized CLI command");
        }
    }

    private record CliCommandParsingResult(
            CliCommands cliCommand,
            boolean successful,
            String errorMessage
    ) {
    }
}
