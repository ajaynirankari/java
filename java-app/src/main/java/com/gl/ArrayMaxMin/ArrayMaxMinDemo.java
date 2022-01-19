package com.gl.ArrayMaxMin;

import java.util.Arrays;

public class ArrayMaxMinDemo {
    public static void main(String[] args) {
        int[] a = {6, 3, 8, 5, 1, 9, 7};
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));

        System.out.println("max(a) = " + max(a));
        System.out.println("min(a) = " + min(a));

        int[][] twoDArray = {
                {3, 7, 5, 1},
                {4, 16},
                {6, 9, 8}
        };
        System.out.println("twoDArray.length = " + twoDArray.length);
        System.out.println("max2DArray(twoDArray) = " + max2DArray(twoDArray));
        System.out.println("min2DArray(twoDArray) = " + min2DArray(twoDArray));
    }

    static int max2DArray(int[][] a) {
        int max = a[0][0];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (max < a[i][j]) {
                    max = a[i][j];
                }
            }
        }
        return max;
    }
    static int min2DArray(int[][] a) {
        int min = a[0][0];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (min > a[i][j]) {
                    min = a[i][j];
                }
            }
        }
        return min;
    }
    static int max(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    static int min(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
            }
        }
        return min;
    }
}