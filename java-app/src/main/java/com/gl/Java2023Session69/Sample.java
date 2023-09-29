package com.gl.Java2023Session69;

import java.io.Console;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Sample {
    public static void main(String[] args) throws IOException {
        // User Input from followings
        // 1. Command line arguments
        // 2. Scanner class
        // 3. java.io.Console class

        System.out.println("Main started ...");

        Console console = System.console();
        if (console == null) {
            System.out.println("console is NOT found. Please run this program from console. C:\\> java Sample.java");
            // System.exit(1);    ----> Programmer request OS to stop the JVM process
        } else {
            System.out.println("console is found, Lets go to continue application");

            String userId = console.readLine("Type your user id: ");
            char[] password = console.readPassword("Type your password: ");
            String pwd = new String(password);

            if ("test".equals(pwd)) {
                System.out.println("Welcome " + userId + ", in Application");
                String age = console.readLine("What is your age: ");
                String address = console.readLine("What is your address: ");

                System.out.println("-------------------------------------------");
                System.out.println("userId = " + userId);
                System.out.println("password = " + pwd);
                System.out.println("age = " + age);
                System.out.println("address = " + address);
                System.out.println("-------------------------------------------");

                String header = "UserId" + "," + "Password" + "," + "Age" + "," + "Address";
                String value = userId + "," + pwd + "," + age + "," + address;

                writeUserDetailsInCVSFile(header, value);

                System.out.println("-------------------------------------------");

            } else {
                System.out.println("Invalid Password");
            }
        }
        System.out.println("-------------------------------------------");
        readUserDetailsFromCVSFile();
        System.out.println("-------------------------------------------");

        String linuxFilePath = "/var/test/abc";
        String windowFilePath = "\\var\\test\\abc";

        System.out.println("linuxFilePath = " + linuxFilePath);
        System.out.println("windowFilePath = " + windowFilePath);

        System.out.println("Main completed");
    }

    private static void readUserDetailsFromCVSFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\Test\\user.csv");
        int b = fileInputStream.read();
        while (b != -1) {
            System.out.print((char) b);
            b = fileInputStream.read();
        }
        fileInputStream.close();
        System.out.println();
    }

    private static void writeUserDetailsInCVSFile(String header, String value) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Test\\user.csv");
        fileOutputStream.write(header.getBytes());
        fileOutputStream.write("\n".getBytes());
        fileOutputStream.write(value.getBytes());
        fileOutputStream.close();
    }
}
