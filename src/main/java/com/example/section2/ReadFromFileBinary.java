package com.example.section2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

public class ReadFromFileBinary {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("./data"));

        final Map<Long, Student> read = (Map<Long, Student>) inputStream.readObject();

        System.out.println(read);

        inputStream.close();
    }
}
