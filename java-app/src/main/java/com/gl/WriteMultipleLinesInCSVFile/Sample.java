package com.gl.WriteMultipleLinesInCSVFile;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Sample {
    public static void main(String[] args) {
        write("random.csv");
    }

    static void write(String fileName) {
        try {
            PrintWriter fileOut = new PrintWriter(new FileWriter(fileName));
            for (int i = 0; i < 100; i++) {
                fileOut.println("Mr" + "," + " user_" + i + "," + i + "," + (i + i) + "," + (i * i));
            }
            fileOut.close();
            System.out.println("Success...");
        } catch (
                Exception e) {
            System.out.println("ERROR = " + e);
        }
    }
}
