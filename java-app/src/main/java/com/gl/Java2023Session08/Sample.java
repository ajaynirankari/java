package com.gl.Java2023Session08;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {

        int y0 = 79;
        int y1 = 90;
        int y2 = 20;
        int y3 = 5;

        int a;  // Declare variable
        //System.out.println("a = " + a);   Not allowed
        a = 50; // Initialize value
        System.out.println("a = " + a);

        int b = 88; // Declare variable + Initialize value


        int[] array;  // Declare array
        array = new int[3];
        // Initialize array
        array[0] = 7;
        array[1] = 5;
        array[2] = 3;
        //array[3] = 8; Not allowed -> ArrayIndexOutOfBoundsException

        System.out.println("array.length = " + array.length);
        System.out.println("array = " + array[0]);
        System.out.println("array = " + array[2]);
        //System.out.println("array = " + array[3]); Not allowed -> ArrayIndexOutOfBoundsException


        int[] array1 = {7, 5, 3};
        System.out.println("array1.length = " + array1.length);
        System.out.println("array1 = " + array1[1]);
        System.out.println("array1 = " + array1[2]);
        //System.out.println("array1 = " + array1[3]); Not allowed -> ArrayIndexOutOfBoundsException

        int[] array2 = {4, 7};
        double[] dArray = {7.8, 9.9};
        char[] ch = {'a', 'b', 'A', 'G'};
        String[] strings = {"one", "two", "three", "four"};

        System.out.println("strings.length = " + strings.length);
        System.out.println("strings[0] = " + strings[0]);
        System.out.println("strings[1] = " + strings[1]);
        System.out.println("strings[2] = " + strings[2]);
        System.out.println("strings[3] = " + strings[3]);
        System.out.println("---------------------------------------------");

        //initial value; condition; inc/dec
        for (int i = 0; i <= strings.length - 1; i = i + 1) {
            System.out.println("strings[" + i + "] = " + strings[i]);
        }
        System.out.println("---------------------------------------------");


        int[] r = new int[6];                     // Declare array
        for (int i = 0; i <= r.length - 1; i++) {
            r[i] = i + i * 20;                    // Initialize array
        }

        for (int i = 0; i <= r.length - 1; i++) {
            System.out.print(r[i] + ", ");           // Access array
        }
        System.out.println();

        // Write program to sum for given n numbers;

        int[] numbers = {6, 3, 8, 1, 2, 99};

        int res = sumOfNumbers(numbers);
        System.out.println("res1 = " + res);

        int[] g = {7, 6, 5};
        res = sumOfNumbers(g);
        System.out.println("res2 = " + res);

        // Write program that return all even numbers
        System.out.println("---------------1st way------------------");
        int[] evens = getAllEvenNumbers(numbers);
        for (int i = 0; i < evens.length; i++) { // Normal for loop
            System.out.print(evens[i] + ", ");
        }
        System.out.println();
        System.out.println("---------------2nd way-----------------");
        for (int e : evens) {  // for enhance loop
            System.out.print(e + ", ");
        }
        System.out.println();
        System.out.println("---------------3rd way--------------");
        System.out.println(Arrays.toString(evens));
        System.out.println(" --------------------------------");

        // Write method which take input as an array of N number, return array of odd numbers
        // Write method which take input as an array of N number, return average input numbers
    }

    static int[] getAllEvenNumbers(int[] num) {
        int[] result = new int[3];
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 == 0) {
                result[index] = num[i];
                index++;
            }
        }
        return result;
    }

    static int sumOfNumbers(int[] n) {
        int sum = 0;
        for (int index = 0; index < n.length; index++) {
            sum = sum + n[index];
        }
        return sum;
    }
}
