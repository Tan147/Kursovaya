package com.tatiana.exam.kurs02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LoadGame implements Command{

    private Menu menu;
    public LoadGame(Menu menu){
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.loadGame();
        String filename = "save.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
            Files.writeString(Paths.get("second.txt"), line, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Игра загружена");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
