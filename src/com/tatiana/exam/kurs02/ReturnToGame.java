package com.tatiana.exam.kurs02;

public class ReturnToGame implements Command{

    private Menu menu;
    public ReturnToGame(Menu menu){
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.returnToGame();
    }
}
