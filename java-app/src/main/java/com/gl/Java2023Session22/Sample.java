package com.gl.Java2023Session22;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {

        // Set of numbers -> 7, 4, 9, 5, 2, 8
        // Arrange the set of numbers - may be in Ascending order
        // Arrange the set of numbers - may be in Descending order
        // Sorting elements -> ( maybe in Ascending order or Descending order )
        // input -> Array of numbers -  {7, 4, 9, 5, 2, 8}
        // output -> Array of numbers - {2, 4, 5, 7, 8, 9}

        int[] input = {7, 4, 9, 5, 2, 8, 99, 45, 21, 1, 6};
        System.out.println("Input Array: " + Arrays.toString(input));

        selectionSortInAscendingOrder(input);
        System.out.println("Ascending order: " + Arrays.toString(input));

        selectionSortInDescendingOrder(input);
        System.out.println("Descending order: " + Arrays.toString(input));
    }

    static void selectionSortInAscendingOrder(int[] a) {
        for (int i = 0; i < a.length; i++) {

            int min_index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min_index]) {
                    min_index = j;
                }
            }
            int t = a[i];
            a[i] = a[min_index];
            a[min_index] = t;

        }
    }

    static void selectionSortInDescendingOrder(int[] a) {
        for (int i = 0; i < a.length; i++) {

            int max_index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > a[max_index]) {
                    max_index = j;
                }
            }
            int t = a[i];
            a[i] = a[max_index];
            a[max_index] = t;

        }
    }

}


