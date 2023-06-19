package com.example.client

import java.net.Socket
import java.util.Formatter
import java.util.Scanner
import kotlin.concurrent.thread

private const val PORT = 8080
private const val IP = "localhost"

fun main() {
    val socket = Socket(IP, PORT);
    println("Connected to server!")

//    val inputStream = socket.getInputStream()

    val inputStream = socket.getInputStream()
    thread {
        val scanner = Scanner(inputStream)
        while (true) {
            if (scanner.hasNextLine()) {
//                    System.out.println(scanner.nextLine())
                println(scanner.nextLine())
            }
        }
    }

    val outputStream = socket.getOutputStream()
    val terminalInput = Scanner(System.`in`)
    val writer = outputStream.bufferedWriter()

    while (true) {
        writer.write(terminalInput.nextLine())
        writer.newLine()
        writer.flush()
    }

}