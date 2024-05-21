package com.tatiana.exam.kurs02;

public class ReturnToMenu implements Command{

    private Menu menu;
    public ReturnToMenu(Menu menu){
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.returnToMenu();
        System.out.println("Возврат в меню");
    }
}
