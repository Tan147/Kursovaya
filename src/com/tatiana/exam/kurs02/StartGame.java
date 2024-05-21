package com.tatiana.exam.kurs02;

public class StartGame implements Command{
    private Menu menu;
    public StartGame(Menu menu){
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.startGame();
    }
}
