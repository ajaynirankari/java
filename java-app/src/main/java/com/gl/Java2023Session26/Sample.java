package com.gl.Java2023Session26;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {

        int[] input = {6, 2, 9, 4, 1, 3, 5};
        System.out.println("input = " + Arrays.toString(input));

        insertionSortInAscendingOrder(input);
        System.out.println("input = " + Arrays.toString(input));

        insertionSortInDescendingOrder(input);
        System.out.println("input = " + Arrays.toString(input));

        // Time complexity    ------   depend upon the number of elements
        // Space complexity   ------   depend upon the number of elements
    }

    static void insertionSortInAscendingOrder(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && key < a[j]) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
    }

    static void insertionSortInDescendingOrder(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && key > a[j]) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
    }
}
