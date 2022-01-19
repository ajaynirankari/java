package com.gl.JavaTrainingSession04;

public class Sample {
    public static void main(String[] args) {
        int[] a = {6, 2, 8, 4, 3, 1};
        System.out.println("a.length = " + a.length);
        printArray(a);
        bubbleSort(a);
        printArray(a);
        selectionSort(a);
        printArray(a);
    }

    static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 1; j < a.length - i; j++) {
                if (a[j] < a[j - 1]) {
                    swap(a, j - 1, j);
                }
            }
        }
    }

    static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    swap(a, minIndex, j);
                }
            }
        }
    }

    static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }
}