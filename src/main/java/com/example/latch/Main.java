package com.example.latch;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    private static CountDownLatch latch = new CountDownLatch(10);

    @SneakyThrows
    public static void main(String[] args) {
        new Thread(() -> {
            x();
        }).start();
        new Thread(() -> {
            x();
        }).start();
        new Thread(() -> {
            x();
        }).start();

        latch.await();

        System.out.println("All thread runed!");
    }



    @SneakyThrows
    public static void x() {
        Thread.sleep(3000);
        System.out.println("X");

        latch.countDown();
    }

}
