package com.example;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

//        System.out.println("c".matches("^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$"));


        System.out.println(String.format("%d Hi this is test %s and my num %.4f ssss", 20, "Ali", 13.131415));



        StringBuilder builder = new StringBuilder();


        for (int i = 0; i < 100; i++) {
            builder.append("This").append(' ').append(i).append(' ');

            builder.append("END");
            builder.append("\n");
        }

        final String string = builder.toString();
        System.out.println(string);


    }
}
