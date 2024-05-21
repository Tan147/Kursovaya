package com.tatiana.exam.kurs02;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteFiles {
    public static void writeWithFiles(String filename, String data) throws IOException {

        Files.writeString(Paths.get(filename), data, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
