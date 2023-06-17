package com.example.join;

import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        final Main main = new Main();

        final Thread thread1 = new Thread(main.new MyRunnable(), "Thread 1");
        final Thread thread2 = new Thread(main.new MyRunnable(), "Thread 2");
        final Thread thread3 = new Thread(main.new MyRunnable(), "Thread 3");

        thread1.start();
//        thread1.join(4000);

        thread2.start();
//        thread2.join(4000);

        thread3.start();
//        thread3.join(4000);

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("End of Main");
    }


    public class MyRunnable implements Runnable {

        @Override
        @SneakyThrows
        public void run() {
            System.out.println("Thead started : " + Thread.currentThread().getName());

            Thread.sleep(10000);

            System.out.println("Thread stoped : " + Thread.currentThread().getName());

        }
    }
}
