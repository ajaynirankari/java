package com.gl.Java2023Session71;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class Sample {
    public static void main(String[] args) throws Exception {

        // Java IO Operation
        // Java IO Package - java.io.
        // Java IO Package - java.nio.
        //                 - java.nio.file.Files

        Paths pathCass;
        Path pathInterface;
        Files filesClass;

        //Different way to create path variables

        Path path1 = Path.of("D:\\Test");
        Path path2 = Paths.get("D:\\Test");
        Path path3 = FileSystems.getDefault().getPath("D:\\Test");

        // Prefer way
        Path path = Path.of("D:\\First");

        boolean exists = Files.exists(path);
        System.out.println("exists = " + exists);
        if (!exists) {
            Path directory = Files.createDirectory(path);
            System.out.println("directory created = " + directory);
        }

        Path filePath = Path.of("D:\\First\\one.txt");
        boolean isFilePathExist = Files.exists(filePath);
        System.out.println("isFilePathExist = " + isFilePathExist + " " + filePath);

        if (!isFilePathExist) {
            Path file = Files.createFile(filePath);
            System.out.println("file created = " + file);
        }

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(filePath)) {
            bufferedWriter.write("Message 1 \n");
            bufferedWriter.write("Message 2 \n");
            bufferedWriter.write("Message 3 \n");
            bufferedWriter.write("Message 4 \n");
        }

        try (BufferedReader bufferedReader = Files.newBufferedReader(filePath)) {
            bufferedReader.lines()
                    .forEach(System.out::println);
        }

        Files.walkFileTree(Path.of("D:\\First"), new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("preVisitDirectory dir = " + dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("visitFile file = " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.out.println("visitFileFailed file = " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                System.out.println("postVisitDirectory dir = " + dir);
                return FileVisitResult.CONTINUE;
            }
        });


        HttpRequest request = HttpRequest
                .newBuilder(URI.create("http://www.jaduniv.edu.in/"))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder().build();

        HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
        InputStream inputStream = response.body();

        OutputStream outputStream = Files.newOutputStream(Path.of("D:\\First\\jaduniv.html"));

        int read = inputStream.read();
        while (read != -1) {
            System.out.print((char) +read);
            outputStream.write(read);
            read = inputStream.read();
        }

        inputStream.close();
        outputStream.close();
        client.close();


        Path path4 = Path.of("D:\\First\\one.txt");
        boolean exists1 = Files.exists(path4);
        System.out.println("before path4 exists1 = " + exists1);
        Files.delete(path4);
        boolean exists2 = Files.exists(path4);
        System.out.println("after path4 exists2 = " + exists2);


        Path dirPath5 = Path.of("D:\\First");

        Files.walkFileTree(dirPath5, new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });


        boolean exists11 = Files.exists(dirPath5);
        System.out.println("before path5 exists1 = " + exists11);
        Files.delete(dirPath5);
        boolean exists21 = Files.exists(dirPath5);
        System.out.println("after path4 exists2 = " + exists21);

    }
}