package com.example.exchanger;

import lombok.SneakyThrows;

import java.util.concurrent.Exchanger;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        final Exchanger<String> exchanger = new Exchanger<>();


        new Thread(new Thread1(exchanger)).start();


        new Thread(new Thread2(exchanger)).start();
    }
}

class Thread1 implements Runnable {
    private final Exchanger<String> exchanger;
    Thread1(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }
    @Override
    @SneakyThrows
    public void run() {
        Thread.sleep(1000);
        final String exchange = exchanger.exchange("Bye from thread 1");
        System.out.println("THREAD1 :" + exchange);
    }
}


class Thread2 implements Runnable {
    private final Exchanger<String> exchanger;
    Thread2(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }
    @Override
    @SneakyThrows
    public void run() {
        Thread.sleep(2000);
        final String exchange = exchanger.exchange("Hi from thread 2");
        System.out.println("THREAD2 :" +  exchange);
    }
}
