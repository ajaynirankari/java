package com.gl.leetCode.sortColors;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {
        int[] a = {2, 0, 2, 1, 1, 0, 0, 2, 1, 0, 2, 1, 1, 0, 2};
        System.out.println("Input = " + Arrays.toString(a));
        sortColors(a);
        System.out.println("Output = " + Arrays.toString(a));
    }

    static void sortColors(int[] numbs) {
        usingDutchNationalFlagAlgo(numbs);
        //usingBubbleSort(numbs);                // O(n^2)
        //usingCountSort(numbs);                 // 2O(n)
        //usingDutchNationalFlagAlgo(numbs);     // O(n/2)
    }

    static void usingBubbleSort(int[] numbs) {
        for (int i = 0; i < numbs.length; i++) {
            for (int j = 0; j < numbs.length - 1; j++) {
                if (numbs[j] > numbs[j + 1]) {
                    swap(numbs, j, j + 1);
                }
            }
        }
    }

    static void usingCountSort(int[] numbs) {
        int count_0s = 0;
        int count_1s = 0;
        int count_2s = 0;
        for (int n : numbs) {
            if (n == 0) {
                count_0s++;
            } else if (n == 1) {
                count_1s++;
            } else if (n == 2) {
                count_2s++;
            }
        }
        for (int i = 0; i < numbs.length; i++) {
            if (count_0s > 0) {
                numbs[i] = 0;
                count_0s--;
            } else if (count_1s > 0) {
                numbs[i] = 1;
                count_1s--;
            } else if (count_2s > 0) {
                numbs[i] = 2;
                count_2s--;
            }
        }
    }

    static void usingDutchNationalFlagAlgo(int[] numbs) {
        int first = 0;
        int mid = 0;
        int last = numbs.length - 1;
        while (mid <= last) {
            if (numbs[mid] == 0) {
                swap(numbs, mid, first);
                mid++;
                first++;
            } else if (numbs[mid] == 1) {
                mid++;
            } else if (numbs[mid] == 2) {
                swap(numbs, mid, last);
                last--;
            }
        }
    }

    static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
