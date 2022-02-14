package com.gl.JavaTrainingSession24;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {
        int n = 12345;
        System.out.println("n = " + n);

        int rev = reverse(n);
        System.out.println("reverse = " + rev);

        int a = 10;
        int b = 20;
        System.out.println("before swap() call: a = " + a + ", b=" + b);
        swap(a, b);
        System.out.println("after swap() call: a = " + a + ", b=" + b);

        Data data = new Data(10, 20);
        System.out.println("before swap() call: data = " + data);
        swap(data);
        System.out.println("after swap() call:data = " + data);

        int[] intArrayObject = {10, 20};
        System.out.println("before swap() call: intArrayObject = " + Arrays.toString(intArrayObject));
        swap(intArrayObject);
        System.out.println("after swap() call: intArrayObject = " + Arrays.toString(intArrayObject));
    }

    static void swap(int[] intArray) {
        int t = intArray[0];
        intArray[0] = intArray[1];
        intArray[1] = t;
    }

    static void swap(Data objectReference) {
        int t = objectReference.a;
        objectReference.a = objectReference.b;
        objectReference.b = t;
    }

    static void swap(int x, int y) {
        System.out.println("swap x = " + x + ", y=" + y);
        int t = x;
        x = y;
        y = t;
        System.out.println("swap x = " + x + ", y=" + y);
    }
    static int reverse(int n) {
        int s = 0;
        while (n > 0) {
            s = s * 10 + n % 10;
            n = n / 10;
        }
        return s;
    }
}
class Data {
    public int a;
    public int b;

    public Data(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Data{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}