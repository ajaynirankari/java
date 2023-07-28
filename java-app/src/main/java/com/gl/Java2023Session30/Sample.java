package com.gl.Java2023Session30;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sample {
    public static void main(String[] args) {

        int[] input = {2, 5, 3, 2, 5, 4, 7, 2, 5};
        System.out.println("input array = " + Arrays.toString(input));

        int[] output = makeUniqueInputArray(input);
        System.out.println("Unique output array = " + Arrays.toString(output));

        Set<Integer> integerSet = new HashSet<>();
        for (int e : input) {
            integerSet.add(e);
        }
        System.out.println("Unique integer set = " + integerSet);
    }

    static int[] makeUniqueInputArray(int[] a) {
        int[] outputArray = new int[a.length];
        int outputIndex = 0;
        for (int n : a) {
            if (isNumberNotExistInOutputArray(outputArray, n)) {
                outputArray[outputIndex] = n;
                outputIndex++;
            }
        }

        int[] resultArray = new int[outputIndex];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = outputArray[i];
        }
        return resultArray;
    }

    static boolean isElementExist(int[] a, int element) {
        for (int e : a) {
            if (e == element) {
                return true;
            }
        }
        return false;
    }

    static boolean isNumberNotExistInOutputArray(int[] a, int number) {
        for (int e : a) {
            if (e == number) {
                return false;
            }
        }
        return true;
    }
}
