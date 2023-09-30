package com.gl.Java2023Session70;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Sample {
    public static void main(String[] args) throws Exception {
        // Java FileSystem

        FileSystem fileSystems = FileSystems.getDefault();

        String separator = fileSystems.getSeparator();
        System.out.println("file separator = " + separator);

        fileSystems.getRootDirectories()
                .forEach(System.out::println);

        Iterable<Path> rootDirectories = fileSystems.getRootDirectories();
        for (Path p : rootDirectories) {
            System.out.println("path = " + p);
        }

        Path directory = Files.createDirectory(Path.of("D:\\MyTest"));
        System.out.println("directory = " + directory);

        Path pathOne = Path.of("D:\\MyTest\\one.txt");

        Path file = Files.createFile(pathOne);
        System.out.println("file = " + file);

        File file1 = new File("D:\\MyTest\\one.txt");
        boolean newFile = file1.createNewFile();
        System.out.println("newFile = " + newFile);


        Files.delete(pathOne);

        boolean isDeleted = Files.deleteIfExists(pathOne);
        System.out.println("isDeleted = " + isDeleted);

        Path source = Path.of("D:\\MyTest\\first.txt");
        Path target = Path.of("D:\\MyTest\\second.txt");
        Path targetNew = Path.of("D:\\MyTest\\third.txt");

        writeMessagesInFile(source);
        readMessagesFromFile(source);

        Path copy = Files.copy(source, target);
        System.out.println("copy = " + copy);

        copy(source, target);

        Files.deleteIfExists(targetNew);

        boolean isDirectory = Files.isDirectory(targetNew);
        System.out.println("isDirectory = " + isDirectory);

        try (Stream<String> lines = Files.lines(source)) {
            lines.forEach(System.out::println);
        }

    }

    static void copy(Path path1, Path path2) throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path1);
             BufferedWriter bufferedWriter = Files.newBufferedWriter(path2)) {
            String readLine = bufferedReader.readLine();
            while (readLine != null) {
                bufferedWriter.write(readLine);
                bufferedWriter.write("\n");
                readLine = bufferedReader.readLine();
            }
        }
    }

    private static void readMessagesFromFile(Path path) throws IOException {

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String readLine = bufferedReader.readLine();
            while (readLine != null) {
                System.out.println(readLine);
                readLine = bufferedReader.readLine();
            }
        }
        //bufferedReader.close(); // No need to close manually if we use try-with-resource block
    }

    private static void writeMessagesInFile(Path path) throws IOException {
        BufferedWriter bufferedWriter = Files.newBufferedWriter(path);
        bufferedWriter.write("This is test message 1");
        bufferedWriter.write("\n");
        bufferedWriter.write("This is test message 2");
        bufferedWriter.close();
    }
}