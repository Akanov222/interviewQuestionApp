package com.niki.pjd;

import com.niki.pjd.cli.CommandLineInterface;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterviewQuestionApp implements CommandLineRunner {

	private final CommandLineInterface commandLineInterface;

    public InterviewQuestionApp(CommandLineInterface commandLineInterface) {
        this.commandLineInterface = commandLineInterface;
    }

    public static void main(String[] args) {
		SpringApplication.run(InterviewQuestionApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		commandLineInterface.run();
	}
}
