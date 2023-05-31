package com.example.section2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteBinaryToFile {

    public static void main(String[] args) throws IOException {
        final ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("./stu"));

        final Student ali = new Student("ali", "123456789", 20);

        outputStream.writeObject(ali);

        outputStream.close();
    }
}
