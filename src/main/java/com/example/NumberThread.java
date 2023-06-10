package com.example;

import lombok.SneakyThrows;

import java.util.concurrent.ThreadLocalRandom;

public class NumberThread extends Thread {

    @Override
    @SneakyThrows
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Number Thread " + i);
            Thread.sleep(ThreadLocalRandom.current().nextInt(200));
        }
    }
}
