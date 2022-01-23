package com.gl.JavaTrainingSession07;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {

        int[] a = {4, 6, 3, 1};
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));

        a = deleteLastElement(a);
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));

        a = deleteElement(a, 4);
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));

        a = deleteElementAtIndex(a, 0);
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
    }

    static int[] deleteLastElement(int[] a) {
        int[] newArray = new int[a.length - 1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = a[i];
        }
        return newArray;
    }

    static int[] deleteElement(int[] a, int element) {
        int[] newArray = new int[a.length - 1];
        int indexA = 0;
        int indexB = 0;
        for (indexA = 0; indexA < a.length; indexA++) {
            if (a[indexA] == element) {

            } else {
                newArray[indexB] = a[indexA];
                indexB = indexB + 1;
            }
        }
        return newArray;
    }

    static int[] deleteElementAtIndex(int[] a, int index) {
        if (index > a.length - 1 || index < 0) {
            throw new RuntimeException("Input index=[" + index + "], It must be between [0] to [" + a.length + "]");
        }
        int[] newArray = new int[a.length - 1];
        int indexA = 0;
        int indexB = 0;
        for (indexA = 0; indexA < a.length; indexA++) {
            if (indexA == index) {

            } else {
                newArray[indexB] = a[indexA];
                indexB = indexB + 1;
            }
        }
        return newArray;
    }
}
