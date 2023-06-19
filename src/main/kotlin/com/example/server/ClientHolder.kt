package com.example.server

import com.example.utils.Color
import java.io.BufferedReader
import java.io.BufferedWriter
import java.net.Socket
import java.net.SocketException
import java.util.*

data class ClientHolder(
    val socket: Socket
) {
    val reader: BufferedReader = socket.getInputStream().bufferedReader()
    val writer: BufferedWriter = socket.getOutputStream().bufferedWriter()
    val blackList: MutableList<String> = mutableListOf()
    fun message(input: String) {
        this.writer.write(input)
        this.writer.newLine()
        this.writer.flush()
    }

    fun readMessage(): String {
        try {
            val message = this.reader.readLine()

            if (message == null || message.isBlank() || message.equals("exit", true)) {
                message("exit")
                return quitSocket()
            }

            return message
        } catch (e: SocketException) {
            return quitSocket()
        }
    }

    fun quitSocket(): String {
        if (!socket.isClosed) {
            message("/exit")
            socket.close()
        }
        return "/exit"
    }

    fun log(message: String, color: Color? = null) {
        if (color == null) {
            println("${Date()} ${hostIp()}: $message")
        } else {
            print(color)
            println("${Date()} ${hostIp()}: $message")
            print(Color.RESET)
        }
    }

    fun hostIp(): String = socket.inetAddress.hostAddress
}