package com.example.server

import java.net.ServerSocket
import kotlin.concurrent.thread


private const val PORT = 8080
val clients = mutableMapOf<String, ClientHolder>()
fun main() {

    println("Server loading ...")
    val server = ServerSocket(PORT) // final ServerSocket server = new ServerSocket(8080)
    println("Server Init! on $PORT")

    thread {
        while (true) {
            val input = readln()
            clients.values.forEach {
                it.message(input)
            }

        }
    }

    while (true) {
        val socket = server.accept()

        thread {
            val clientAddress = socket.inetAddress.hostAddress
            println("$clientAddress connected!")

            val client = ClientHolder(socket)

            if (clients.containsKey(clientAddress)) {
                clients[clientAddress]?.quitSocket()
            }

            clients[clientAddress] = client
            readFromSocketInput(client)
        }
    }

}

fun checkCommand(input: String, client: ClientHolder): Boolean? {
    if (input.startsWith('/')) {
        return executeCommand(input, client)
    }
    return false
}

private fun readFromSocketInput(client: ClientHolder) {
    while (true) {
        val message = client.readMessage()
        val c = checkCommand(message, client) ?: break
        if (!c) {
            client.log(message)
        }
    }
}

