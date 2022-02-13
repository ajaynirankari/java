package com.gl.JavaTrainingSession23;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {

        int input = 462676;
        System.out.println("input = " + input);
        System.out.println("input length= " + findIntLength(input));

        int[] intArray = convertIntValueIntArray(input);
        System.out.println("Arrays.toString(intArray) = " + Arrays.toString(intArray));

        int max = findMax(intArray);
        System.out.println("max = " + max);

        int[] occurrenceOfEachDigit = findOccurrenceOfEachDigit(input);
        System.out.println("occurrenceOfEachDigit = " + Arrays.toString(occurrenceOfEachDigit));

        for (int i = 0; i < occurrenceOfEachDigit.length; i++) {
            if (occurrenceOfEachDigit[i] > 0) {
                System.out.println("Digit = " + i + " -> " + occurrenceOfEachDigit[i] + " time");
            }
        }

        int max1 = findMax(occurrenceOfEachDigit);
        System.out.println("max1 = " + max1);

        int maxValueIndex = findMaxValueIndex(occurrenceOfEachDigit);
        System.out.println("maxValueIndex = " + maxValueIndex);
    }

    static int[] findOccurrenceOfEachDigit(int n) {
        int[] intArray = new int[10];
        while (n > 0) {
            int r = n % 10;
            intArray[r] = intArray[r] + 1;
            n = n / 10;
        }
        return intArray;
    }

    static int findMax(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    static int findMaxValueIndex(int[] a) {
        int max = a[0];
        int returnIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
                returnIndex = i;
            }
        }
        return returnIndex;
    }

    static int[] convertIntValueIntArray(int n) {
        int lengthForArray = findIntLength(n);
        int[] returnArray = new int[lengthForArray];
        int index = 0;
        while (n > 0) {
            int r = n % 10;
            returnArray[index] = r;
            index = index + 1;
            n = n / 10;
        }
        return returnArray;
    }

    static int findIntLength(int n) {
        int c = 0;
        while (n > 0) {
            int r = n % 10;
            n = n / 10;
            c = c + 1;
        }
        return c;
    }
}
