package com.gl.Java2023Session67;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) throws Exception {
        System.out.println("Command Line Input, args length = " + args.length + ", values = " + Arrays.toString(args));

        // Java File I/O system

        // Byte Stream
        InputStream inputStream;
        OutputStream outputStream;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;

        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;

        // Character Stream
        Reader reader;
        Writer writer;
        FileReader fileReader;
        FileWriter fileWriter;

        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;

        // Example
        String fileName = "data.txt";
        String data = "This is a test data only for testing";

        writeDataUsingBufferedOutputStream(fileName, data);
        readDataUsingBufferedOutputStream(fileName);
        data = "This is a test data only for testing readDataUsingBufferedWriter";

        writeDataUsingBufferedWriter(fileName, data);
        readDataUsingBufferedReader(fileName);

        // Command-line input from user
        for (String inputData : args) {
            System.out.println(inputData);
        }

        String collectInputData = Arrays.stream(args)
                .collect(Collectors.joining(" "));

        System.out.println("collected inputData = " + collectInputData);

        writeDataUsingBufferedWriter(fileName, collectInputData);
        readDataUsingBufferedReader(fileName);

        // User input from console
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type Some Name (type bye for exit) - ");
        while (scanner.hasNext()) {
            String next = scanner.next();
            System.out.println("Inside loop - " + next);
            if (next.equals("bye")) {
                break;
            }
        }
        System.out.println("outside loop - ");

        String fileNameNew = null;
        String fileData = "";
        System.out.println("File Name - ");
        if (scanner.hasNext()) {
            fileNameNew = scanner.next();
        }
        System.out.println("File Data (type bye for exit) - ");
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (next.equals("bye")) {
                break;
            }
            fileData = fileData + " " + next;
        }
        scanner.close();

        System.out.println("fileData = " + fileData + ",  fileNameNew = " + fileNameNew);

        writeDataUsingBufferedWriter(fileNameNew, fileData);
        readDataUsingBufferedReader(fileNameNew);

        System.out.println("Main Done");
    }

    private static void readDataUsingBufferedReader(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String readLine = bufferedReader.readLine();
        while (readLine != null) {
            System.out.println(readLine);
            readLine = bufferedReader.readLine();
        }
        bufferedReader.close();

        System.out.println("------------------Via Stream API-------------------------------");
        bufferedReader = new BufferedReader(new FileReader(fileName));
        bufferedReader.lines()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    private static void writeDataUsingBufferedWriter(String fileName, String data) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    private static void readDataUsingBufferedOutputStream(String fileName) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName));
        int b = bufferedInputStream.read();
        while (b != -1) {
            System.out.print((char) b);
            b = bufferedInputStream.read();
        }
        System.out.println();
        bufferedInputStream.close();
    }

    private static void writeDataUsingBufferedOutputStream(String fileName, String data) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName));
        byte[] bytes = data.getBytes();
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();
    }
}
