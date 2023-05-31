package com.example.section2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadFromFileBinary {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("./stu"));

        final Student student = (Student) inputStream.readObject();

        System.out.println(student);
    }
}
