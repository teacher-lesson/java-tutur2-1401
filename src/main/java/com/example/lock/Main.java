package com.example.lock;

import lombok.SneakyThrows;

import java.util.concurrent.Exchanger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {

        final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        new Thread(new MyRunnable(lock)).start();

        Thread.sleep(100);

        new Thread(new Runnable() {
            @Override
            @SneakyThrows
            public void run() {
                System.out.println("Locking Write");
                lock.writeLock().lock();
                try {
                    Thread.sleep(3000);
                    System.out.println("Unlocking Write");
                } finally {
                    lock.writeLock().unlock();
                }
            }
        }).start();

        Thread.sleep(100);

        new Thread(new Runnable() {
            @Override
            @SneakyThrows
            public void run() {
                System.out.println("Locking Write");
                lock.writeLock().lock();
                try {
                    Thread.sleep(3000);
                    System.out.println("Unlocking Write");
                } finally {
                    lock.writeLock().unlock();
                }
            }
        }).start();

        Thread.sleep(100);


        new Thread(new MyRunnable(lock)).start();
        Thread.sleep(100);

        new Thread(new MyRunnable(lock)).start();
        Thread.sleep(100);

        new Thread(new MyRunnable(lock)).start();
        Thread.sleep(100);




    }

    static class MyRunnable implements Runnable {


        private final ReentrantReadWriteLock lock;

        public MyRunnable(ReentrantReadWriteLock lock) {
            this.lock = lock;
        }

        @Override
        @SneakyThrows
        public void run() {
            lock.writeLock().lock();
            try {
                Thread.sleep(3000);
                System.out.println("TEST READ");
            }finally {
                lock.writeLock().unlock();
            }
        }
    }
}
