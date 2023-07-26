package com.gl.Java2023Session29;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {
        int[] a = {5, 3, 9, 7, 4};
        System.out.println("Input Array = " + Arrays.toString(a));

        int element = 44;
        int[] output = addElementAtFirst(a, element);
        System.out.println(element+" --> addElementAtFirst Output Array = " + Arrays.toString(output));

        element=55;
        output = addElementAtSpecificIndex(a, element, 3);
        System.out.println(element+" --> addElementAtSpecificIndex Output Array = " + Arrays.toString(output));

        element=505;
        output = addElementAfterFindValue(a, element, 5);
        System.out.println(element+" --> addElementAfterFindValue Output Array = " + Arrays.toString(output));

        element = 909;
        output = addElementBeforeFindValue(a, element, 9);
        System.out.println(element+" --> addElementBeforeFindValue Output Array = " + Arrays.toString(output));

    }

    static int[] addElementAtFirst(int[] a, int addElement) {
        int[] outputArray = new int[a.length + 1];
        int index = 0;
        outputArray[index] = addElement;
        index++;

        for (int i = 0; i < a.length; i++) {
            outputArray[index] = a[i];
            index++;
        }
        return outputArray;
    }

    static int[] addElementAtSpecificIndex(int[] a, int addElement, int atIndex) {
        int[] outputArray = new int[a.length + 1];
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (i == atIndex) {
                outputArray[index] = addElement;
                index++;
                outputArray[index] = a[i];
            } else {
                outputArray[index] = a[i];
            }
            index++;
        }
        return outputArray;
    }

    static int[] addElementAfterFindValue(int[] a, int addElement, int afterValue) {
        int[] outputArray = new int[a.length + 1];
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == afterValue) {
                outputArray[index] = a[i];
                index++;
                outputArray[index] = addElement;
            } else {
                outputArray[index] = a[i];
            }
            index++;
        }
        return outputArray;
    }

    static int[] addElementBeforeFindValue(int[] a, int addElement, int beforeValue) {
        int[] outputArray = new int[a.length + 1];
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == beforeValue) {
                outputArray[index] = addElement;
                index++;
                outputArray[index] = a[i];
            } else {
                outputArray[index] = a[i];
            }
            index++;
        }
        return outputArray;
    }
}
