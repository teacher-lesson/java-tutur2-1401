package com.example.server

import java.net.ServerSocket
import kotlin.concurrent.thread


private const val PORT = 8080

fun main() {
    println("Server init ...")
    val server = ServerSocket(PORT) // final ServerSocket server = new ServerSocket(8080)
    println("Server inited! on $PORT")
    val socket = server.accept()
    println("Client connected!")

    thread {
        val inputStream = socket.getInputStream()
        val reader = inputStream.bufferedReader()
        while (true) {
            println(reader.readLine())
        }
    }

    thread {
        val outputStream = socket.getOutputStream()
        val writer = outputStream.bufferedWriter()

        while (true) {
            writer.write(readln())
            writer.newLine()
            writer.flush()
        }
    }


}