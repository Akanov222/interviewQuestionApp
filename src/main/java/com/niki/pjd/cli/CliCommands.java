package com.niki.pjd.cli;

public enum CliCommands {
    MENU("menu"),
    LIST("list"),
    ADD("add"),
    EXIT("exit"),
    UNRECOGNIZED("unrecognized");

    private final String lowerCaseName;

    CliCommands(String lowerCaseName) {
        this.lowerCaseName = lowerCaseName;
    }

    public String getLowerCaseName() {
        return lowerCaseName;
    }
}
