package com.gl.javaniofileFiles;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaNIOFilesDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("Ok");

        Path path = Path.of("abc.txt");
        Files.createFile(path);

        String message="Messages New 1";
        Files.write(path,message.getBytes());

        String message2="Messages New 2";
        Files.write(path,message2.getBytes());

        List<String> stringList = Stream.of(message, message2, "Message 3", "Message 4", "Message 5").collect(Collectors.toList());

        Files.write(path,stringList);

        Files.lines(path).forEach(System.out::println);

        List<String> strings = Files.lines(path).collect(Collectors.toList());

        System.out.println(strings);

        System.out.println(Files.readAllLines(path));

        //Files.delete(path);
        Files.deleteIfExists(path);
        System.out.println("Done");
    }
}