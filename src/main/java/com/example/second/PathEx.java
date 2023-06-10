package com.example.second;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PathEx {

    public static void main(String[] args) throws IOException {
//        Files.createDirectories(Paths.get("./TEMP2/X2/Y3"));


        final Path source = Paths.get("./file.txt");
        final Path copy = Paths.get("./new-file.txt");

        Files.copy(source, copy);

//        Files.createFile(Path.of("./newNew-File.txt"));

        Files.deleteIfExists(Path.of("./new-file.txt"));

        final List<String> strings = Files.readAllLines(source);

        System.out.println(strings);
    }
}
