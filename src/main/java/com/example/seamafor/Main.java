package com.example.seamafor;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

public class Main {

    private static Semaphore sem = new Semaphore(2);

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

        x();
    }



    @SneakyThrows
    public static void x() {
        sem.acquire();
        Thread.sleep(3000);
        System.out.println("X");
        sem.release();
    }

}
