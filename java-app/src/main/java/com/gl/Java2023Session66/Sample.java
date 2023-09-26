package com.gl.Java2023Session66;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;

public class Sample {
    public static void main(String[] args) throws Exception {

        // Java file system operation - read data from file, write data into file
        // File I/O Stream

        // Kind or the Nature of data
        // - Byte stream    --------> InputStream/OutputStream
        // - Character stream ------> Reader/Write
        // - Object steam

        // - Byte stream - Base classes
        InputStream inputStream; //is use for read operation
        OutputStream outputStream; //is used for write operation

        // - Character stream - Base classes
        Reader reader;
        Writer writer;

        String data = "This is a test data for byte stream test";
        String fileName = "data.txt";

        writeDataUsingByteStreamViaFileInputStream(fileName, data);
        readDataUsingByteStreamViaFileInputStream(fileName);

        data = "This is a test data for character stream test";
        writeDataUsingCharacterStreamViaFileWriter(fileName, data);
        readDataUsingCharacterStreamViaFileReader(fileName);

        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;

        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
    }

    private static void writeDataUsingCharacterStreamViaFileWriter(String fileName, String data) throws Exception {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(data);
        fileWriter.close();
    }

    private static void readDataUsingCharacterStreamViaFileReader(String fileName) throws Exception {
        FileReader fileReader = new FileReader(fileName);
        int bytes = fileReader.read();
        while (bytes != -1) {
            System.out.print((char) bytes);
            bytes = fileReader.read();
        }
        fileReader.close();
        System.out.println();
    }

    private static void writeDataUsingByteStreamViaFileInputStream(String fileName, String data) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        byte[] bytes = data.getBytes();
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }

    private static void readDataUsingByteStreamViaFileInputStream(String fileName) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int bytes = fileInputStream.read();
        while (bytes != -1) {
            System.out.print((char) bytes);
            bytes = fileInputStream.read();
        }
        fileInputStream.close();
        System.out.println();
    }
}
