package com.example.watch;

import lombok.SneakyThrows;

import java.nio.file.*;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.*;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {

        WatchService watchService = FileSystems.getDefault().newWatchService();

        final Path sample = Path.of("/home/mohsen/Documents/test");
        sample.register(watchService, ENTRY_MODIFY, ENTRY_CREATE, ENTRY_DELETE);

        while (true) {

            final WatchKey take = watchService.take();

            for (WatchEvent<?> pollEvent : take.pollEvents()) {
                if (pollEvent.kind().name().equalsIgnoreCase("ENTRY_MODIFY")) {
//                    if (checkOldData to newData)
                    System.out.println("User file change");
                }
            }

            take.reset();
        }


    }
}
