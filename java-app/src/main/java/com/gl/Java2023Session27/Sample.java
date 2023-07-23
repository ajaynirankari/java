package com.gl.Java2023Session27;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {

        int[] numbers = {2000, 6, 9, 7, 6, 7, 9, 7, 3, 3, 3, 3, 3, 3, 9, 2000, 2000, 500};
        System.out.println("input numbers = " + Arrays.toString(numbers));

        System.out.println("---------------------allDuplicateCountInArray----------------------------");
        allDuplicateCountInArray(numbers);
        System.out.println("---------------------allUniqueDuplicateCountInArray----------------------------");
        allUniqueDuplicateCountInArray(numbers);
        System.out.println("---------------------allUniqueDuplicateViaFrequencyTable----------------------------");
        allUniqueDuplicateViaFrequencyTable(numbers);
    }

    static int duplicateCountInArray(int[] intArray, int inputNumber) {
        int count = 0;
        for (int number : intArray) {
            if (number == inputNumber) {
                count++;
            }
        }
        return count;
    }

    static void allDuplicateCountInArray(int[] intArray) {
        for (int number : intArray) {
            int count = duplicateCountInArray(intArray, number);
            if (count > 1) {
                System.out.println("count of duplicate number: (" + number + ") is = " + count + " times");
            }
        }
    }

    static void allUniqueDuplicateCountInArray(int[] intArray) {
        int[] duplicateNumberOutputArray = new int[intArray.length];
        int[] duplicateCount = new int[intArray.length];
        int indexForOutputArray = 0;

        for (int number : intArray) {
            if (isNumberNotExistInOutputArray(duplicateNumberOutputArray, number)) {
                int count = duplicateCountInArray(intArray, number);
                if (count > 1) {
                    duplicateNumberOutputArray[indexForOutputArray] = number;
                    duplicateCount[indexForOutputArray] = count;
                    indexForOutputArray++;
                }
            }
        }

        for (int i = 0; i < indexForOutputArray; i++) {
            System.out.println("count of duplicate number: (" + duplicateNumberOutputArray[i] + ") is = " + duplicateCount[i] + " times");
        }
    }

    static void allUniqueDuplicateViaFrequencyTable(int[] intArray) {
        //int[] frequency = new int[intArray.length]; ?????
        //int[] frequency = new int[?????];
        int[] frequency = new int[max(intArray) + 1];
        for (int numberAsIndex : intArray) {
            frequency[numberAsIndex]++;
        }
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 1) {
                System.out.println("count of duplicate number: (" + i + ") is = " + frequency[i] + " times");
            }
        }
    }

    static int max(int[] a) {
        int max = 0;
        for (int e : a) {
            if (max < e) {
                max = e;
            }
        }
        return max;
    }

    static boolean isNumberNotExistInOutputArray(int[] a, int n) {
        return duplicateCountInArray(a, n) == 0;
    }
}