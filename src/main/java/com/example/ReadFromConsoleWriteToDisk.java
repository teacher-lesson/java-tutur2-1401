package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ReadFromConsoleWriteToDisk {

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scanner = new Scanner(System.in);


        final Set<String> userInput = new HashSet<>();

        while (true) {
            final String input = scanner.next();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            userInput.add(input);
        }

        final Formatter formatter = new Formatter(new FileOutputStream("./file.txt"));

        for (String s : userInput) {
            formatter.format(s + "\n");
        }

        formatter.close();
    }
}
