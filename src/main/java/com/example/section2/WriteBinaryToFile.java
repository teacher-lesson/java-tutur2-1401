package com.example.section2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

public class WriteBinaryToFile {

    public static void main(String[] args) throws IOException {
        final ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("./data"));

        Map<Long, Student> map = Map.of(
                1000L , new Student("Ali", 20),
                1001L , new Student("Hassan", 21),
                1002L , new Student("HosseinAli", 22),
                1003L , new Student("Reza", 19)
        );

        outputStream.writeObject(map);

        outputStream.close();
    }
}
