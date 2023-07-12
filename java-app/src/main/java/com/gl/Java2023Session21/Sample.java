package com.gl.Java2023Session21;

public class Sample {
    public static void main(String[] args) {
        System.out.println("----------------------------");
        printUpTriangleShape(5);
        System.out.println("----------------------------");
        printDownTriangleShape(5);
        System.out.println("----------------------------");
        printDiamondTriangleShape(10);
        System.out.println("----------------------------");
    }

    static void printDiamondTriangleShape(int noOfRow) {

        int mid = noOfRow / 2;

        int colUpperPartCondition = 1;
        for (int r = 1; r <= mid; r++) {
            for (int s = r; s <= mid; s++) {
                System.out.print(" ");
            }
            for (int c = 1; c <= colUpperPartCondition; c++) {
                System.out.print("*");
            }
            colUpperPartCondition = colUpperPartCondition + 2;
            System.out.println();
        }

        int colLowerPartCondition = mid * 2 - 1;
        for (int r = 1; r <= mid; r++) {
            for (int s = 1; s <= r; s++) {
                System.out.print(" ");
            }
            for (int c = 1; c <= colLowerPartCondition; c++) {
                System.out.print("*");
            }
            colLowerPartCondition = colLowerPartCondition - 2;
            System.out.println();
        }

    }


    static void printUpTriangleShape(int noOfRow) {
        int colCondition = 1;

        for (int r = 1; r <= noOfRow; r++) {
            for (int s = r; s <= noOfRow; s++) {
                System.out.print(" ");
            }
            for (int c = 1; c <= colCondition; c++) {
                System.out.print("*");
            }
            colCondition = colCondition + 2;

            System.out.println();
        }
    }

    static void printDownTriangleShape(int noOfRow) {
        int colCondition = noOfRow * 2 - 1;

        for (int r = 1; r <= noOfRow; r++) {
            for (int s = 1; s <= r; s++) {
                System.out.print(" ");
            }
            for (int c = 1; c <= colCondition; c++) {
                System.out.print("*");
            }
            colCondition = colCondition - 2;

            System.out.println();
        }
    }
}
