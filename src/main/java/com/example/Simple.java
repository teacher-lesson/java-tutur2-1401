package com.example;

import lombok.SneakyThrows;

public class Simple {

    private final static Object FIRST_LOCK = new Object();
    private final static Object SECOND_LOCK = new Object();

    @SneakyThrows
    public static void a() {
        synchronized (FIRST_LOCK) {
            Thread.sleep(3000);
            System.out.println("This is A");
        }
    }

    @SneakyThrows
    public static void a2() {
        synchronized (FIRST_LOCK) {
            Thread.sleep(3000);
            System.out.println("This is A2");
        }
    }


    public static void b() {
        synchronized (SECOND_LOCK) {
            System.out.println("This is B");
        }
    }
}
