package com.tatiana.exam.kurs02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SaveGame implements Command{

    private Menu menu;
    public SaveGame(Menu menu){
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.saveGame();
        Resource resource = new Resource();
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
            System.out.println("Игра сохранена");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

