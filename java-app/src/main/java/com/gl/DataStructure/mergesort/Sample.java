package com.gl.DataStructure.mergesort;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {
        int[] a = {3, 5, 8, 10};
        int[] b = {1, 2, 4, 6, 7, 9};
        System.out.println("Arrays.toString(merge(a,b)) = " + Arrays.toString(merge(a, b)));

        int[] c = {5, 2, 8, 1, 7, 3, 6, 9};
        System.out.println("Arrays.toString(c) = " + Arrays.toString(c));
        mergeSort(c);
        System.out.println("Arrays.toString(c) = " + Arrays.toString(c));
    }

    static void mergeSort(int[] a) {
        int left = 0;
        int right = a.length - 1;
        mergeSort(a, left, right);
    }

    static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    static void merge(int[] a, int left, int mid, int right) {
        int leftLen = mid - left + 1;
        int rightLen = right - mid;

        int[] leftArray = new int[leftLen];
        int[] rightArray = new int[rightLen];

        for (int k = 0; k < leftLen; k++) {
            leftArray[k] = a[left + k];
        }
        for (int m = 0; m < rightLen; m++) {
            rightArray[m] = a[mid + 1 + m];
        }

        int i = 0;
        int j = 0;
        int k = left;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
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

    static int[] merge(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int[] temp = new int[a.length + b.length];
        int k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = b[j++];
            }
        }
        while (i < a.length) {
            temp[k++] = a[i++];
        }
        while (j < b.length) {
            temp[k++] = b[j++];
        }
        return temp;
    }
}
