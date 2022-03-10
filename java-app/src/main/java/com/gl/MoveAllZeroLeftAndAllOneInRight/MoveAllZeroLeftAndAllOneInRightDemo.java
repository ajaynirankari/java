package com.gl.MoveAllZeroLeftAndAllOneInRight;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class MoveAllZeroLeftAndAllOneInRightDemo {
    public static void main(String[] args) {

        int[] a = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0};
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
        moveAllZeroLeftAndAllOneInRightOneWay(a);
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));

        int[] b = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0};
        System.out.println("Arrays.toString(b) = " + Arrays.toString(b));
        moveAllZeroLeftAndAllOneInRightAnotherWay(b);
        System.out.println("Arrays.toString(b) = " + Arrays.toString(b));

        int[] c = {0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0};

        var lists = Arrays.stream(c)
                .boxed()
                .collect(Collectors.partitioningBy(e -> e == 1))
                .values()
                .stream()
                .flatMap(Collection::stream)
                .toList();
        System.out.println("lists = " + lists);

    }

    static void moveAllZeroLeftAndAllOneInRightAnotherWay(int[] a) {
        int l = 0;
        int r = a.length - 1;
        boolean flag = true;
        while (l < r) {
            while (a[l] == 0) {
                l++;
            }
            while (a[r] == 1) {
                r--;
            }
            swap(a, l++, r--);
            if (r < l && flag) {
                int t = l;
                l = r;
                r = t;
                flag = false;
            }
        }
    }

    static void moveAllZeroLeftAndAllOneInRightOneWay(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                swap(a, i - 1, i);
                i = i - 2;
            }
        }
    }

    static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
