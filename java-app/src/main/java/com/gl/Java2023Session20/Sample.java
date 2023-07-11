package com.gl.Java2023Session20;

public class Sample {
    public static void main(String[] args) {
        printTriangleShape(10);
    }

    static void printTriangleShape(int noOfRow) {
        int n = 0;
        for (int r = 1; r <= noOfRow; r++) {
            for (int s = r; s <= noOfRow; s++) {
                System.out.print(" ");
            }
            for (int c = 1; c <= r + n; c++) {
                System.out.print("*");
            }
            n = n + 1;
            System.out.println();
        }
    }
}
