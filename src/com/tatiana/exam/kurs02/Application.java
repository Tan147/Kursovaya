package com.tatiana.exam.kurs02;

import java.util.Scanner;

public class Application {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        String command;

        // Создаем receiver
        Menu menu = new Menu();

        StartGame startGame = new StartGame(menu);
        ReturnToMenu returnToMenu = new ReturnToMenu(menu);
        ReturnToGame returnToGame = new ReturnToGame(menu);
        ExitGame exitGame = new ExitGame(menu);
        SaveGame saveGame = new SaveGame(menu);
        LoadGame loadGame = new LoadGame(menu);


        // Создаем invoker
        Switch tSwitch = new Switch();

        do {
            System.out.println("Введите 1, чтобы начать новую игру");
            System.out.println("Введите 2, чтобы вернуться к игре");
            System.out.println("Введите 3, чтобы сохранить игру");
            System.out.println("Введите 4, чтобы загрузить игру");
            System.out.println("Введите 5, чтобы вернуться в меню");
            System.out.println("Введите 6, чтобы выйти из игры");

            command = scanner.nextLine();
            switch (command){
                case "1":
                    tSwitch.setCommand(startGame);
                    tSwitch.pressButton();
                    Game game01 = new Game();
                    game01.fox();
                    break;
                case "2":
                    tSwitch.setCommand(returnToGame);
                    tSwitch.pressButton();
                    break;
                case "3":
                    tSwitch.setCommand(saveGame);
                    tSwitch.pressButton();
                    break;
                case "4":
                    tSwitch.setCommand(loadGame);
                    tSwitch.pressButton();
                    break;
                case "5":
                    tSwitch.setCommand(returnToMenu);
                    tSwitch.pressButton();
                    break;

                case "6":
                    tSwitch.setCommand(exitGame);
                    tSwitch.pressButton();
                    break;

                default:
                    System.out.println("Команда не опознана. Попробуйте снова");

            }

        } while (!command.equals("6"));

    }
}


