package com.gl.Java2023Session11;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {

        // Write a program to find out the max element for a given array
        int[] input = {6, 3, 8, 1, 2};
        System.out.println("input = " + Arrays.toString(input));
        int max = getMaxElementFromAnArray(input);
        System.out.println("max = " + max);

        // Write a program to find out the min element for a given array
        int min = getMinElementFromAnArray(input);
        System.out.println("min = " + min);
        System.out.println("----------------------------------------");

        // Write a program to find out the max & min both elements for a given array
        int[] result = getMaxAndMinBothElementsFromAnArray(input);
        System.out.println("min = " + result[0]);
        System.out.println("max = " + result[1]);
    }

    static int getMaxElementFromAnArray(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            int n = a[i];
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    static int getMinElementFromAnArray(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    static int[] getMaxAndMinBothElementsFromAnArray(int[] a) {
        int[] result = new int[2];
        int max = getMaxElementFromAnArray(a);
        int min = getMinElementFromAnArray(a);
        result[0] = min;
        result[1] = max;
        return result;
    }
}
