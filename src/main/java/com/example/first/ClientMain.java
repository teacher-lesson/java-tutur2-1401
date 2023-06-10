package com.example.first;

import java.io.IOException;
import java.net.Socket;
import java.util.Formatter;

public class ClientMain {

    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket("127.0.0.1", 8080);

        final Formatter formatter = new Formatter(socket.getOutputStream());

        formatter.format("THIS IS SIMPLE TEXT");
        formatter.flush();

        formatter.close();

        socket.close();
    }
}
