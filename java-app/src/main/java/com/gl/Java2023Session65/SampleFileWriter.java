package com.gl.Java2023Session65;

import java.io.File;
import java.io.FileWriter;

public class SampleFileWriter {
    public static void main(String[] args) {
        // Java - file system for read and write operation
        // File I/O - Java File Input/Output

        try {
            File fileObject = new File("test");
            FileWriter fileWriter = new FileWriter(fileObject);
            fileWriter.write("Hello World !!!");
            fileWriter.close();

            System.out.println("fileWriter DONE");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
