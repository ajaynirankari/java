package com.gl.Java2023Session23;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {

        int[] input = {4, 9, 3, 8, 6, 2, 1, 5, 7};
        System.out.println("Input = " + Arrays.toString(input));

        bubbleSortAscendingOrder(input);
        System.out.println("bubbleSortAscendingOrder Output = " + Arrays.toString(input));

        bubbleSortDescendingOrder(input);
        System.out.println("bubbleSortDescendingOrder Output = " + Arrays.toString(input));
    }

    static void bubbleSortAscendingOrder(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
    }

    static void bubbleSortDescendingOrder(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] < a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
    }

//        for (int j = 0; j < a.length - 1; j++) {
// System.out.println("j = " + j + ") ---> a[" + j + "] = " + a[j] + " a[" + (j + 1) + "] = " + a[j + 1] + "  > " + (a[j] > a[j + 1]));
//            if (a[j] > a[j + 1]) {
//                int t = a[j];
//                a[j] = a[j + 1];
//                a[j + 1] = t;
//            }
//        }
//        System.out.println("Arrays= " + Arrays.toString(a));

//        for (int j = 0; j < a.length - 2; j++) {
// System.out.println("j = " + j + ") ---> a[" + j + "] = " + a[j] + " a[" + (j + 1) + "] = " + a[j + 1] + "  > " + (a[j] > a[j + 1]));
//            if (a[j] > a[j + 1]) {
//                int t = a[j];
//                a[j] = a[j + 1];
//                a[j + 1] = t;
//            }
//        }
//        System.out.println("Arrays= " + Arrays.toString(a));

//        for (int j = 0; j < a.length - 3; j++) {
// System.out.println("j = " + j + ") ---> a[" + j + "] = " + a[j] + " a[" + (j + 1) + "] = " + a[j + 1] + "  > " + (a[j] > a[j + 1]));
//            if (a[j] > a[j + 1]) {
//                int t = a[j];
//                a[j] = a[j + 1];
//                a[j + 1] = t;
//            }
//        }

//        System.out.println("Arrays= " + Arrays.toString(a));
//
//        for (int j = 0; j < a.length - 4; j++) {
// System.out.println("j = " + j + ") ---> a[" + j + "] = " + a[j] + " a[" + (j + 1) + "] = " + a[j + 1] + "  > " + (a[j] > a[j + 1]));
//            if (a[j] > a[j + 1]) {
//                int t = a[j];
//                a[j] = a[j + 1];
//                a[j + 1] = t;
//            }
//        }
//        System.out.println("Arrays= " + Arrays.toString(a));

//        for (int j = 0; j < a.length - 5; j++) {
// System.out.println("j = " + j + ") ---> a[" + j + "] = " + a[j] + " a[" + (j + 1) + "] = " + a[j + 1] + "  > " + (a[j] > a[j + 1]));
//            if (a[j] > a[j + 1]) {
//                int t = a[j];
//                a[j] = a[j + 1];
//                a[j + 1] = t;
//            }
//        }
//        System.out.println("Arrays= " + Arrays.toString(a));


}
