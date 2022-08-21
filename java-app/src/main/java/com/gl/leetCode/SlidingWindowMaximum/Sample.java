package com.gl.leetCode.SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Sample {
    public static void main(String[] args) {
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
        System.out.println("max(a) = " + max(a));

        System.out.println("Arrays.toString(findSlidingWindowMaximum(a,3)) = " + Arrays.toString(findSlidingWindowMaximum(a, 3)));

        System.out.println("Arrays.toString(findSlidingWindowMaximumUsingDeque(a,3)) = " + Arrays.toString(findSlidingWindowMaximumUsingDeque(a, 3)));
    }

    static int[] findSlidingWindowMaximumUsingDeque(int[] a, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] resultMax = new int[a.length - k + 1];
        int ri = 0;

        for (int i = 0; i < a.length; i++) {
            if (!deque.isEmpty() && deque.getFirst() == i - k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && a[deque.getLast()] < a[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (i >= k - 1) {
                resultMax[ri++] = a[deque.getFirst()];
            }
        }
        return resultMax;
    }

    static int[] findSlidingWindowMaximum(int[] a, int windowSize) {
        int[] resultMax = new int[a.length - windowSize + 1];
        int ti;
        int max;
        int ai;

        for (int i = 0; i < resultMax.length; i++) {
            ti = 0;
            max = a[i];
            ai = i;
            while (ti < windowSize) {
                if (max < a[ai]) {
                    max = a[ai];
                }
                ai++;
                ti++;
            }
            resultMax[i] = max;
        }
        return resultMax;
    }

    static int max(int[] a) {
        int max = a[0];
        int len = a.length - 1;

        int i = 0;
        while (i <= len) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[len] > max) {
                max = a[len];
            }
            i++;
            len--;
        }
        return max;
    }
}
