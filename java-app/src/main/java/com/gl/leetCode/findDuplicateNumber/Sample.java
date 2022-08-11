package com.gl.leetCode.findDuplicateNumber;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 2, 2};
        int[] b = {3, 1, 3, 4, 2};
        System.out.println("DuplicateNumber is (" + findDuplicateNumber(a) + ") of " + Arrays.toString(a));
        System.out.println("DuplicateNumber is (" + findDuplicateNumber(b) + ") of " + Arrays.toString(b));

        System.out.println("DuplicateNumber is (" + findDuplicateNumberUsingHash(a) + ") of " + Arrays.toString(a));
        System.out.println("DuplicateNumber is (" + findDuplicateNumberUsingHash(b) + ") of " + Arrays.toString(b));

        System.out.println("DuplicateNumber is (" + findDuplicateNumberUsingIndexBasesCircularLinkedListWithSlowFastPointer(a) + ") of " + Arrays.toString(a));
        System.out.println("DuplicateNumber is (" + findDuplicateNumberUsingIndexBasesCircularLinkedListWithSlowFastPointer(b) + ") of " + Arrays.toString(b));
    }

    static int findDuplicateNumberUsingHash(int[] a) {
        int[] t = new int[a.length];

        for (int n : a)
            t[n]++;

        for (int i = 0; i < t.length; i++)
            if (t[i] > 1) return i;

        return 0;
    }

    static int findDuplicateNumber(int[] a) {
        for (int t : a)
            if (isDuplicate(a, t)) return t;

        return 0;
    }

    static int findDuplicateNumberUsingIndexBasesCircularLinkedListWithSlowFastPointer(int[] numbers) {
        int slow = numbers[0];
        int fast = numbers[0];

        do {
            slow = numbers[slow];
            fast = numbers[numbers[fast]];
        } while (slow != fast);

        fast = numbers[0];
        while (slow != fast) {
            slow = numbers[slow];
            fast = numbers[fast];
        }

        return slow;
    }

    static boolean isDuplicate(int[] a, int n) {
        int c = 0;

        for (int t : a)
            if (t == n) c++;

        return c > 1;
    }
}
