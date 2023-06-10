package com.example;

import lombok.SneakyThrows;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        final NumberThread thread = new NumberThread();
        thread.setDaemon(true);
        thread.start();


//        final RunnableEx target = new RunnableEx();
//        final Thread thradFromRunable = new Thread(target);
//        thradFromRunable.start();


        for (int i = 0; i < 10; i++) {
            System.out.println("main " + i);
            Thread.sleep(ThreadLocalRandom.current().nextInt(200));
        }    }
}
