package com.gl.DataStructure.mergesort;

import java.util.Arrays;

public class SampleMergeDemo {
    public static void main(String[] args) {
        int[] a = {5, 1, 6, 2, 3, 4, 45, 98, 4, 20, 11, 9};
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

    static void merge(int[] a, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                a[k++] = leftArray[i++];
            } else {
                a[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {
            a[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            a[k++] = rightArray[j++];
        }
    }
}
