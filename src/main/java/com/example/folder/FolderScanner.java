package com.example.folder;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;

public class FolderScanner implements Runnable{

    private final Path path;
    private final boolean onlyFiles;

    public FolderScanner(Path path) {
        this(path, false);
    }

    public FolderScanner(Path path, boolean onlyFiles) {
        this.path = path.toAbsolutePath();
        this.onlyFiles = onlyFiles;
    }

    @Override
    @SneakyThrows
    public void run() {
        Files.list(path).forEach(x -> {
            if (Files.isDirectory(x)) {
                final FolderScanner folderScanner = new FolderScanner(x);
                final Thread thread = new Thread(folderScanner);
                thread.start();

                if (!onlyFiles){
                    System.out.println(x);
                }
            } else {
                System.out.println(x);
            }
        });
    }
}
