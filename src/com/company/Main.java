package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("C:\\Users\\User\\Desktop\\romeo-and-juliet.txt");
             FileWriter fileWriter = new FileWriter("Word.txt")) {
            int i;
            String maxWordlength = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ((i = fileReader.read()) != -1) {
                stringBuilder.append((char) i);
            }
            Pattern pattern = Pattern.compile("\\b[A-Za-z]+\\b");
            Matcher matcher = pattern.matcher(stringBuilder);
            while (matcher.find()) {
                if (matcher.group().length() > maxWordlength.length()) {
                    maxWordlength = matcher.group();
                }
            }
            System.out.println(maxWordlength);
            fileWriter.write(maxWordlength);
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
