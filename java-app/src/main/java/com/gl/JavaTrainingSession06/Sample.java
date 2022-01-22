package com.gl.JavaTrainingSession06;

public class Sample {
    public static void main(String[] args) {
        // Insertion sort algorithm

        int[] a = {6, 2, 8, 4, 3, 1};
        printArray(a);
        insertionSort(a);
        printArray(a);

        // to Add element on array
        int[] updatedArray = addElement(a, 45);
        printArray(updatedArray);

        a = addElement(a, 45);
        printArray(a);
        a = addElementAtGivenIndex(a, 37, 6);
        printArray(a);
    }

    static int[] addElementAtGivenIndex(int[] a, int e, int index) {
        if (index > a.length) {
            throw new RuntimeException("Input index is " + index + ", It cannot be greater than " + a.length);
        }
        int[] newArray = new int[a.length + 1];
        int r = 0;
        boolean flag = true;
        for (int i = 0; i < newArray.length; i++) {
            if (index == i) {
                newArray[i] = e;
                flag = false;
                r = i;
            } else {
                if (flag) {
                    newArray[i] = a[i];
                } else {
                    newArray[i] = a[r++];
                }
            }
        }
        return newArray;
    }

    static int[] addElement(int[] a, int e) {
        int[] newArray = new int[a.length + 1];
        int i;
        for (i = 0; i < a.length; i++) {
            newArray[i] = a[i];
        }
        newArray[i] = e;
        return newArray;
    }

    static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int currentValue = a[i];
            int j = i - 1;
            while (j >= 0 && currentValue < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = currentValue;
        }
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }
}