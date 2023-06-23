package com.gl.Java2023Session10;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {

        int x = 10;
        int y = 20;
        System.out.println("main Before x = " + x + ", y = " + y);
        //method call by value for primitive data type - actually copy the value
        swap(x, y);
        System.out.println("main After x = " + x + ", y = " + y);
        swapWithoutTempVariable(10, 20);

        int[] a = {6, 3, 9, 2, 5, 1, 7, 8, 4};
        System.out.println("main Before = " + Arrays.toString(a));
        // method call by reference - actually copy the memory address
        reverseArrayElement(a);
        System.out.println("main after = " + Arrays.toString(a));
        reverseArrayElementUsingWhileLoop(a);
    }

    static void reverseArrayElement(int[] a) {
        for (int s = 0, l = a.length - 1; s < l; s++, l--) {
            int t = a[s];
            a[s] = a[l];
            a[l] = t;
        }
        System.out.println("reverse() inside = " + Arrays.toString(a));
    }

    static void reverseArrayElementUsingWhileLoop(int[] a) {
        int s = 0;
        int l = a.length - 1;

        while (s <= l) {
            int t = a[s];
            a[s] = a[l];
            a[l] = t;

            s++;
            l--;
        }
        System.out.println("reverse() inside = " + Arrays.toString(a));
    }

    static void swap(int x, int y) {
        int t = x;
        x = y;
        y = t;
        System.out.println("swap inside x = " + x + ", y = " + y);
    }

    static void swapWithoutTempVariable(int x, int y) {
        System.out.println("before swap inside x = " + x + ", y = " + y);
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("after swap inside x = " + x + ", y = " + y);
    }
}
