package com.gl.leetCode.rotateImage;

public class Sample {
    public static void main(String[] args) {
        int[][] image2D = {
                {5, 9, 1, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        print2DImage(image2D);
        rotate(image2D);
        print2DImage(image2D);
    }

    static void rotate(int[][] image) {
        transposeMatrix(image);
        reverseMatrixRow(image);
    }

    static void transposeMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                swap2d(a, i, j);
            }
        }
    }

    static void reverseMatrixRow(int[][] a) {
//        for (int i = 0; i < a.length; i++) {
//            reverse1d(a[i]);
//        }
        for (int[] row : a) {
            reverse1d(row);
        }
    }

    static void reverse1d(int[] a) {
        int l = a.length - 1;
        int i = 0;
        while (i < l) {
            swap1d(a, i, l);
            i++;
            l--;
        }
    }

    static void swap1d(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static void swap2d(int[][] a, int i, int j) {
        int t = a[i][j];
        a[i][j] = a[j][i];
        a[j][i] = t;
    }

    static void print2DImage(int[][] image) {
//        for (int i = 0; i < image.length; i++) {
//            for (int j = 0; j < image[i].length; j++) {
//                System.out.print(image[i][j] + ",\t");
//            }
//            System.out.println();
//        }
//        System.out.println("---------------------------");

        for (int[] row : image) {
            for (int value : row) {
                System.out.print(value + ",\t");
            }
            System.out.println();
        }
        System.out.println("---------------------------");
    }
}
