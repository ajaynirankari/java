package com.gl.JavaTrainingSession28;

public class Sample {
    public static void main(String[] args) {
        displayTriangleShape(7);
    }

    static void displayTriangleShape(int row) {
        for (int i = 0; i < row; i++) {
            for (int k = row - i; k > 1; k--) {
                System.out.print(" ");
            }
            for (int j = 0; j < (i * 2 + 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
