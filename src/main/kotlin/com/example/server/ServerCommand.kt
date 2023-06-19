package com.example.server

import com.example.utils.Color


fun executeCommand(command: String, client: ClientHolder): Boolean? {
    client.log(command, Color.RED)

    if (command.startsWith("/msg", true)) {
        message(command, client)
        return true
    } else if (command.startsWith("/block", true)) {
        block(command, client)
        return true
    }  else if (command.startsWith("/unblock", true)) {
        unblock(command, client)
        return true
    } else if (command.startsWith("/list-block", true)) {
        listBlock(command, client)
        return true
    } else if (command.startsWith("/list-ips", true)) {
        listIps(command, client)
        return true
    } else if (command.equals("/exit", true)) {
        exit(client)
        return null
    }

    return false
}

fun listIps(command: String, client: ClientHolder) {
    if (command.equals("/list-ips", true)){
        client.message(clients.keys.toString())
    }
}

private fun exit(client: ClientHolder) {
    val address = client.socket.inetAddress.hostAddress
    clients.remove(address)
    println("$address exit!")
}

private fun listBlock(command: String, client: ClientHolder) {
    val strings = command.split(" ")
    if (strings.size == 1) {
        client.message(client.blackList.toString())
    }
}

private fun unblock(command: String, client: ClientHolder) {
    val strings = command.split(" ")
    if (strings.size == 2) {
        client.log(command, Color.GREEN)
        client.blackList.remove(strings[1])
    }
}

private fun block(command: String, client: ClientHolder) {
    val strings = command.split(" ")
    if (strings.size == 2) {
        client.log(command, Color.YELLOW)
        client.blackList.add(strings[1])
    }
}

private fun message(command: String, client: ClientHolder) {
    val strings = command.split(" ", limit = 3)
    client.log(command, Color.GREEN)
    val target = clients[strings[1]]
    if (target != null && !target.blackList.contains(client.hostIp())) {
        target.message(client.hostIp() + " :" + strings[2])
    }
}
