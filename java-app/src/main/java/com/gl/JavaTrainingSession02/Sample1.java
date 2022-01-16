package com.gl.JavaTrainingSession02;

import java.util.Arrays;

public class Sample1 {
    public static void main(String[] args) {

        int[] intArray;
        intArray = new int[3];
        intArray[0] = 1;
        intArray[1] = 2;
        intArray[2] = 3;

        for (int index = 0; index < intArray.length; index++) {
            System.out.print(intArray[index] + ", ");
        }
        System.out.println();
        for (int temp : intArray) {
            System.out.print(temp + ", ");
        }
        System.out.println();
        System.out.println(Arrays.toString(intArray));


        int intArray_[] = {1, 2, 3, 4};
        System.out.println(Arrays.toString(intArray_));
        System.out.println(intArray_.length);

        int x = 1;
        int y = 2;
        int z = 3;

        int[] intArray1 = {1, 2, 3};        // intArray1[0],intArray1[1],intArray1[2]
        int[] intArray2 = {4, 5, 6, 7};     // intArray2[0],intArray2[1],intArray2[2],intArray2[3]
        int[] intArray3 = {8, 9};           // intArray3[0],intArray3[1]

        System.out.println(intArray1[0] + " " + intArray1[1] + " " + intArray1[2]);

        int twoDArray[][] = {
                {1, 2, 3},                      //twoDArray[0][0],twoDArray[0][1],twoDArray[0][2]
                {4, 5, 6, 7},                   //twoDArray[1][0],twoDArray[1][1],twoDArray[1][2],twoDArray[1][3]
                {8, 9}                          //twoDArray[2][0],twoDArray[2][1]
        };
        System.out.println("twoDArray.length = " + twoDArray.length);
        System.out.println("twoDArray[1][2] = " + twoDArray[1][2]);


        int twoDArray2[][] = {
                {21, 22, 23},                      //twoDArray[0][0],twoDArray[0][1],twoDArray[0][2]
                {24, 25, 26, 27},                  //twoDArray[1][0],twoDArray[1][1],twoDArray[1][2],twoDArray[1][3]
                {28, 29}                          //twoDArray[2][0],twoDArray[2][1]
        };


        int threeDArray[][][] = {
                {
                        {1, 2, 3},           //threeDArray[0][0][0],threeDArray[0][0][1],threeDArray[0][0][2]
                        {4, 5, 6, 7},        //threeDArray[0][1][0],threeDArray[0][1][1],threeDArray[0][1][2],threeDArray[0][1][3]
                        {8, 9}               //threeDArray[0][2][0],threeDArray[0][2][1]
                },
                {
                        {21, 22, 23},           //threeDArray[1][0][0],threeDArray[1][0][1],threeDArray[1][0][2]
                        {24, 25, 26, 27},       //threeDArray[1][1][0],threeDArray[1][1][1],threeDArray[1][1][2],threeDArray[1][1][3]
                        {28, 29}                //threeDArray[1][1][0],threeDArray[1][1][1],threeDArray[1][1][2],threeDArray[1][1][3]
                }

        };
        System.out.println("threeDArray.length = " + threeDArray.length);
        System.out.println(threeDArray[1][1][2]);
        System.out.println(threeDArray[0][0][2]);


        int intBArray[];
        intBArray = new int[3];
        intBArray[0] = 11;
        intBArray[2] = 12;
        System.out.println(Arrays.toString(intBArray));

        int[] tempArray = new int[2];
        tempArray[0] = intBArray[0];
        tempArray[1] = intBArray[2];
        intBArray = tempArray;
        System.out.println(Arrays.toString(intBArray));


        String[] sourceArray = {"one", "two", "three", "four", "five", "six", "seven"};
        String targetArray[] = new String[5];
        System.out.println(Arrays.toString(sourceArray));
        System.out.println(Arrays.toString(targetArray));
        System.arraycopy(sourceArray, 2, targetArray, 0, 3);
        System.out.println(Arrays.toString(targetArray));

        for (int i = 0; i < targetArray.length; i++) {
            targetArray[i] = sourceArray[i];
        }

        System.out.println(Arrays.toString(targetArray));

        Object[] objects = {1, 5, 2.3, "hello", 'c'}; // DO not DO
    }
}
