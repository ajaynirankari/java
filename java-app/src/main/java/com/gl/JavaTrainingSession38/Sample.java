package com.gl.JavaTrainingSession38;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {
        int[] a = {7, 2, 9, 5, 2, 6, 1, 70, 23, 18, 30};
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
        mergeSort(a);
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
    }

    static void mergeSort(int[] a) {
        int n = a.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] leftSubArray = new int[mid];
        int[] rightSubArray = new int[n - mid];

        System.arraycopy(a, 0, leftSubArray, 0, mid);
        System.arraycopy(a, mid, rightSubArray, 0, n - mid);

        mergeSort(leftSubArray);
        mergeSort(rightSubArray);

        merge(a, leftSubArray, rightSubArray);
    }

    static void merge(int[] a, int[] leftSubArray, int[] rightSubArray) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftSubArray.length && j < rightSubArray.length) {
            if (leftSubArray[i] <= rightSubArray[j]) {
                a[k++] = leftSubArray[i++];
            } else {
                a[k++] = rightSubArray[j++];
            }
        }

        while (i < leftSubArray.length) {
            a[k++] = leftSubArray[i++];
        }
        while (j < rightSubArray.length) {
            a[k++] = rightSubArray[j++];
        }
    }
}
