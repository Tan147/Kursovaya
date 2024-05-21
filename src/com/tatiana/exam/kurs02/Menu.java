package com.tatiana.exam.kurs02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Menu {
    public Menu() {
    }
    Scanner scanner = new Scanner(System.in);

    public void startGame(){
        System.out.println("Начать игру");
        System.out.println("Добро пожаловать в игру! Сделай свой выбор");
    }
    public void returnToGame(){}
    public void saveGame() { }

    public void loadGame(){}

    public void returnToMenu(){}

    public void exitGame(){
        System.out.println("Выход из игры");
    }
}

