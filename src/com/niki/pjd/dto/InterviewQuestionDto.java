package com.niki.pjd.dto;

public class InterviewQuestionDto {
    Long id;
    String question;
    String answer;

    public InterviewQuestionDto() {
    }

    public InterviewQuestionDto(Long id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public InterviewQuestionDto(String question, String answer) {
        this(null, question, answer);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "InterviewQuestionDto{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
