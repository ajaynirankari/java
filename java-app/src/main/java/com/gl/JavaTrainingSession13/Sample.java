package com.gl.JavaTrainingSession13;

import java.util.Scanner;

public class Sample {
    public static void main(String[] args) {

        System.out.println("Started ");
        Scanner scanner = new Scanner(System.in);

        Scanner scanner1 = new Scanner("Any message");
        String next = scanner1.next();
        System.out.println("next = " + next);
        String next1 = scanner1.next();
        System.out.println("next1 = " + next1);

        scanner = new Scanner(System.in);
        System.out.println("Scanner object created ");
        next = scanner.next();
        System.out.println("next = " + next);
        next1 = scanner.next();
        System.out.println("next1 = " + next1);

        String nextLine = scanner.nextLine();
        System.out.println("nextLine = " + nextLine);

        double v = Double.parseDouble(nextLine);
        System.out.println("v = " + v);

        System.out.print("Type double value - ");
        double nextDouble = scanner.nextDouble();
        System.out.println("nextDouble = " + nextDouble);

        System.out.print("Type length in double: ");
        double length = scanner.nextDouble();
        System.out.print("Type width in double: ");
        double width = scanner.nextDouble();
        System.out.print("Type height in int: ");
        int height = scanner.nextInt();

        System.out.println("length = " + length);
        System.out.println("width = " + width);
        System.out.println("height = " + height);

        long nextLong = scanner.nextLong();

        // Data types for integer number
        byte b = 1;
        short s = 23;
        int i = 45;
        long lon = 56L;

        // Data types for decimal number
        float f = 5.6f;
        double d = 67.9;

        // Data types for character
        char c = 'A';

        // Data types for boolean
        boolean bool = true;

        System.out.println("Done");

        MyScanner myScanner = new MyScanner(4);
        myScanner.me();
    }
}

class MyScanner {
    MyScanner(int s) {

    }

    void me() {
    }
}

