package com.example.first;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {

    public static void main(String[] args) throws IOException {
        System.out.println("Server init!");
        final ServerSocket server = new ServerSocket(8080);

        final Socket socket = server.accept();
        System.out.println("Client connected!");

        final InputStream inputStream = socket.getInputStream();

        final Scanner scanner = new Scanner(inputStream);

        System.out.println(scanner.nextLine());

        scanner.close();

        inputStream.close();

        socket.close();

    }
}
