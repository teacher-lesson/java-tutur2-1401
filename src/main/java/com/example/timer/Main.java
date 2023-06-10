package com.example.timer;

import lombok.SneakyThrows;

import java.io.OutputStream;
import java.util.Scanner;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {




        final Scanner scanner = new Scanner(System.in);
        final int i = scanner.nextInt();



        Timer timer = new Timer(i, new OutputWindow("Output"));
        startTimer(timer);

        while (true) {
            final String next = scanner.next();
            if ("p".equalsIgnoreCase(next)) {
                timer.setRunning(false);
            }
            if ("r".equalsIgnoreCase(next)) {
                startTimer(timer);
            }
        }
    }

    private static void startTimer(Timer timer) {
        timer.setRunning(true);
        new Thread(timer).start();
    }
}
