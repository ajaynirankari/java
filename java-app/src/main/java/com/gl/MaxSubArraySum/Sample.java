package com.gl.MaxSubArraySum;

public class Sample {
    public static void main(String[] args) {
        int[] a = {4, 3, -2, 6, -12, 7, -1, 6};

        System.out.println("maximumSubArraySum = " + maximumSubArraySum(a));
        System.out.println("maximumSubArraySum = " + maximumSubArraySumUsingKadanesAlgo(a));
    }

    static int maximumSubArraySum(int[] a) {
        int maxSum = a[0];
        for (int i = 1; i < a.length; i++) {
            int currentSum = 0;
            for (int j = i; j < a.length; j++) {
                currentSum += a[j];
                if (maxSum < currentSum) {
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }

    static int maximumSubArraySumUsingKadanesAlgo(int[] a) {
        int maxSoFar = a[0];
        int currentSum = a[0];
        for (int i = 1; i < a.length; i++) {
            currentSum += a[i];      // Should I become the part of current sub-array
            if (currentSum < a[i]) { //  or
                currentSum = a[i];   // Should I start new sub-array
            }
            if (maxSoFar < currentSum) {
                maxSoFar = currentSum;
            }
        }
        return maxSoFar;
    }
}
