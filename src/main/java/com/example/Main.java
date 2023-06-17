package com.example;

public class Main {

    public static void main(String[] args) {
        new Thread(() -> {
            Simple.a();
        }).start();

        new Thread(() -> {
            Simple.b();
        }).start();
    }
}
