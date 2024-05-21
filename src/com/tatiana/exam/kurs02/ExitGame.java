package com.tatiana.exam.kurs02;

public class ExitGame implements Command{

    private Menu menu;
    public ExitGame(Menu menu){
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.exitGame();
    }
}


