package com.tatiana.exam.kurs02;

public class Switch {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

}

