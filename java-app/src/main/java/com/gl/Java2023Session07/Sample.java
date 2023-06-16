package com.gl.Java2023Session07;

public class Sample {
    public static void main(String[] args) {
        // Write a program the print first N Fibonacci number

        printFibonacci(5);

        int x = 10;
        int y = 20;
        int z = 30;
        int s = x + y + z;
        System.out.println("s = " + s);

        int g;
        g = 90;

        int[] a = {6, 7, 8, 5};
        System.out.println("a.length = " + a.length);

        System.out.println("a[3] = " + a[3]);
        System.out.println("a[0] = " + a[0]);
        System.out.println("a[2] = " + a[2]);
        //System.out.println("a[2] = " + a[4]); //ArrayIndexOutOfBoundsException - Index 4 out of bounds


        int[] a1 = new int[5];
        System.out.println("a1.length = " + a1.length);

        System.out.println("a1[0] = " + a1[0]);
        System.out.println("a1[1] = " + a1[1]);
        System.out.println("a1[2] = " + a1[2]);

        a1[0] = 99;
        a1[1] = 19;
        a1[2] = 20;
        a1[3] = 45;

        System.out.println("a1[0] = " + a1[0]);
        System.out.println("a1[1] = " + a1[1]);
        System.out.println("a1[2] = " + a1[2]);
        a1[4] = 45;
        //a1[5] = 5; ////ArrayIndexOutOfBoundsException - Index 5 out of bounds

        char[] ch = {'a', 'b', 'c'};
        double[] dd = {4.1, 5.6, 9.8};
        String[] st = {"Test", "One", "two"};


        int r[] = {3, 5};

        System.out.println("--------------------------- ");
        int[] t = {3, 5, 9, 2};
        int index = 0;
        int len = t.length;
        while (index < len) {
            System.out.println("t[" + index + "] = " + t[index]);
            index = index + 1;
        }
        System.out.println("--------------------");

        int sum = 0;
        for (int in = 0; in < t.length; in++) {
            sum = sum + t[in];
        }
        System.out.println("sum = " + sum);

    }

    static void printFibonacci(int n) {
        int l = 0;
        int r = 1;
        System.out.print(l + ", ");
        System.out.print(r + ", ");
        int s = 0;
        int c = 0;
        do
        {
            s = l + r;
            System.out.print(s + ", ");
            l = r;
            r = s;
        } while (c++ <= n);


//
//        l = r;
//        r = s;
//        s = l + r;
//        System.out.println(s);
//
//        l = r;
//        r = s;
//        s = l + r;
//        System.out.println(s);
//
//
//        l = r;
//        r = s;
//        s = l + r;
//        System.out.println(s);
//
//
//        l = r;
//        r = s;
//        s = l + r;
//        System.out.println(s);
//
//        l = r;
//        r = s;
//        s = l + r;
//        System.out.println(s);

    }

    int[] method(int[] t) {
        int[] s = {4, 5};

        return s;
    }
}
