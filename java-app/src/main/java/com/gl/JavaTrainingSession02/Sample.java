package com.gl.JavaTrainingSession02;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {
        int intArray[] = {1, 2, 3};
        String[] strings = {"one", "two", "three"};
        Object[] objects = {1, "one", 1.3}; // DO NOT DO

        System.out.println("Arrays.toString(intArray[]) = " + Arrays.toString(intArray));
        intArray[0] = 45;
        intArray[2] = 56;
        //intArray[3]=56; NOT allowed

        System.out.println("Arrays.toString(intArray[]) = " + Arrays.toString(intArray));

        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + ", ");
        }
        System.out.println();
        for (int t : intArray) {
            System.out.print(t + ", ");
        }

        int x = 1;
        int y = 2;
        int z = 3;

        // 1-Dimensional Array
        int[] intArray1 = {1, 2, 3};            // intArray1[0],intArray1[1],intArray1[2]     
        int[] intArray2 = {4, 5, 6, 7};         // intArray2[0],intArray2[1],intArray2[2]
        int[] intArray3 = {8, 9};               // intArray3[0],intArray3[1],intArray3[2]

        System.out.println(intArray1[0] + "," + intArray1[1] + " " + intArray1[2]);

        // 2- Dimensional Array (Multidimensional Array) or Array of Array
        int twoDArray[][] = {
                {1, 2, 3},              // twoDArray[0][0],twoDArray[0][1],twoDArray[0][2]
                {4, 5, 6, 7},           // twoDArray[1][0],twoDArray[1][1],twoDArray[1][2],twoDArray[1][3]
                {8, 9}                  // twoDArray[2][0],twoDArray[2][1]
        };

        System.out.println("twoDArray.length=" + twoDArray.length);
        System.out.println(twoDArray[1][2]);
        //System.out.println(twoDArray[2][2]);

        twoDArray[1][1] = 99;
        System.out.println(twoDArray[1][1]);


        int twoDArray2[][] = {
                {21, 22, 23},              // twoDArray[0][0],twoDArray[0][1],twoDArray[0][2]
                {24, 25, 27},              // twoDArray[1][0],twoDArray[1][1],twoDArray[1][2],twoDArray[1][3]
                {28, 29}                   // twoDArray[2][0],twoDArray[2][1]
        };

        // 3- Dimensional Array (Multidimensional Array)
        int threeDArray[][][] = {
                {
                        {1, 2, 3},              // threeDArray[0][0][0],threeDArray[0][0][1],threeDArray[0][0][2]
                        {4, 5, 6, 7},           // threeDArray[0][1][0],threeDArray[0][1][1],threeDArray[0][1][2],threeDArray[0][1][3]
                        {8, 9}                  // threeDArray[0][2][0],threeDArray[0][2][1]
                },
                {
                        {21, 22, 23},            // threeDArray[1][0][0],threeDArray[1][0][1],threeDArray[1][0][2]
                        {24, 25, 26, 27},        // threeDArray[1][1][0],threeDArray[1][1][1],threeDArray[1][1][2],threeDArray[1][1][3]
                        {28, 29}                 // threeDArray[1][2][0],threeDArray[1][2][1]
                }
        };
        System.out.println("threeDArray[1][1][3]=" + threeDArray[1][1][3]);
        System.out.println("threeDArray[0][1][1]=" + threeDArray[0][1][1]);


        // 4- Dimensional Array (Multidimensional Array)
        int fourDArray[][][][] = {

        };

        System.out.println();

        int[] bArray;
        bArray = new int[3];

        System.out.println("Arrays.toString(bArray) = " + Arrays.toString(bArray));
        bArray[0] = 2;
        bArray[2] = 3;
        System.out.println("Arrays.toString(bArray) = " + Arrays.toString(bArray));

        int tempArray[] = new int[2];
        tempArray[0] = bArray[0];
        tempArray[1] = bArray[1];

        bArray = tempArray;

        System.out.println("Arrays.toString(bArray) = " + Arrays.toString(bArray));

        String[] strings1 = {"one", "two", "three", "four"};
        String[] strings2 = new String[4];
        System.out.println("Arrays.toString(strings1) = " + Arrays.toString(strings1));
        System.out.println("Arrays.toString(strings2) = " + Arrays.toString(strings2));

        System.arraycopy(strings1, 0, strings2, 1, 3);

        System.out.println("Arrays.toString(strings1) = " + Arrays.toString(strings1));
        System.out.println("Arrays.toString(strings2) = " + Arrays.toString(strings2));

    }
}
