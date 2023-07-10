package com.gl.Java2023Session19;

public class Sample {
    public static void main(String[] args) {
        printShape(6);
        printShape1(6);
    }

    static void printShape1(int noOfRow) {
        for (int r = 1; r <= noOfRow; r++) {
            for (int c = 1; c <= noOfRow - r; c++) {
                System.out.print(" ");
            }
            for (int c = 1; c <= r; c++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void printShape(int noOfRow) {
        for (int r = 0; r <= noOfRow; r++) {
            for (int c = 1; c <= noOfRow - r; c++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
