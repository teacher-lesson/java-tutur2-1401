package com.example.notify;

import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        Object lock = new Object();

        final MyRunnable target = new MyRunnable();
        target.start();


        synchronized (lock) {
            System.out.println("Wait to target middle of his job");
            target.wait();
            System.out.println("Target thread finished");
        }
    }


    public static class MyRunnable extends Thread {

        @Override
        @SneakyThrows
        public void run() {
            final int j = 100;
            for (int i = 0; i < j; i++) {
                Thread.sleep(100);
                synchronized (this) {
                    if (i >= 50) {
                        notify();
                    }
                }
                System.out.println(i);
            }
        }
    }
}
