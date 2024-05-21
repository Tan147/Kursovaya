package com.tatiana.exam.kurs02;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class ReadFiles {

    public static void readWithFilesToList(String filename) throws IOException {
        List<String> stringList = Files.readAllLines(Path.of(filename));
    }

    public static void readWithFilesToStream(String filename) throws IOException {
        try (Stream<String> lines = Files.lines(Path.of(filename))) {

        }
    }
    public static void readWithBuffer(String filename) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(filename);
             BufferedInputStream buffered = new BufferedInputStream(fileInputStream, 1024);
             ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ) {

            byte[] buf = new byte[512];
            int data;

            while ((data = buffered.read(buf)) != -1) {
                byteArray.write(buf, 0, data);
            }

            String text = byteArray.toString();
        }

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8)) {
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        }
    }
}
