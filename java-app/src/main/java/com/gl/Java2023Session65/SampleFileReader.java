package com.gl.Java2023Session65;

import java.io.File;
import java.io.FileReader;

public class SampleFileReader {
    public static void main(String[] args) {
        try {
            File fileObject = new File("test");
            FileReader fileReader = new FileReader(fileObject);
            char[] chars = new char[100];
            fileReader.read(chars);
            System.out.println("chars = " + new String(chars));
            fileReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
