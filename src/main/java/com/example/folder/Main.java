package com.example.folder;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        final Thread thread = new Thread(new FolderScanner(Path.of("./"), true));
        thread.start();
    }
}
