package com.gl.leetCode.SearchInRotatedSortedArray;

public class Sample {
    public static void main(String[] args) {

        int[] a = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("linearSearch(a,0) = " + usingLinearSearch(a, 0));
        System.out.println("binarySearch(a,0) = " + usingBinarySearch(a, 0));

        int[] b = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("linearSearch(a,0) = " + usingLinearSearch(b, 3));
        System.out.println("binarySearch(a,0) = " + usingBinarySearch(b, 3));

        int[] c = {0};
        System.out.println("linearSearch(a,0) = " + usingLinearSearch(c, 0));
        System.out.println("binarySearch(a,0) = " + usingBinarySearch(c, 0));
    }

    static int usingLinearSearch(int[] a, int t) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == t) {
                return i;
            }
        }
        return -1;
    }

    static int usingBinarySearch(int[] a, int t) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            if (a[left] == t) {
                return left;
            }
            if (a[right] == t) {
                return right;
            }

            int mid = (left + right) / 2;

            if (a[mid] == t) {
                return mid;
            }

            if (a[left] <= a[mid]) {
                if (t >= a[left] && t <= a[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (t >= a[mid] && t <= a[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
