package com.gl.Java2023Session28;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {

        int[] a = {5, 7, 2, 4, 9, 8, 3, 9, 4, 4, 4, 4, 11};
        System.out.println("Before original input = " + Arrays.toString(a) + " Length = " + a.length);

        int deleteElement = 9;
        System.out.println("deleteElement = " + deleteElement);
        deleteElementWithSetDefault(a, deleteElement);
        System.out.println("After original input = " + Arrays.toString(a) + " Length = " + a.length);

        deleteElement = 4;
        System.out.println("deleteElement = " + deleteElement);
        int[] output = deleteTheExistingElement(a, deleteElement);
        System.out.println("After delete output = " + Arrays.toString(output) + " Length = " + output.length);
        System.out.println("After delete original input = " + Arrays.toString(a) + " Length = " + a.length);

        deleteElement = 4;
        System.out.println("deleteElement = " + deleteElement);
        output = deleteAllMatchedElement(a, deleteElement);
        System.out.println("After delete output = " + Arrays.toString(output) + " Length = " + output.length);
        System.out.println("After delete original input = " + Arrays.toString(a) + " Length = " + a.length);

        int addElement = 119;
        System.out.println("addElementAtLast = " + addElement);
        int[] newAddedArray = addElementAtLast(a, addElement);
        System.out.println("After newAddedArray output = " + Arrays.toString(newAddedArray) + " Length = " + newAddedArray.length);
        System.out.println("After newAddedArray original input = " + Arrays.toString(a) + " Length = " + a.length);
    }

    static int[] addElementAtLast(int[] a, int addNewElement) {
        int[] result = new int[a.length + 1];
        int index = 0;

        for (int i = 0; i < a.length; i++) {
            result[index] = a[i];  // copy element from original array to result array
            index++;
        }
        result[index] = addNewElement;

        return result;
    }

    static int[] deleteAllMatchedElement(int[] a, int deletedElement) {
        int deletedCount = 0;
        for (int e : a) {
            if (e == deletedElement) {
                deletedCount++;
            }
        }

        int[] result = new int[a.length - deletedCount];
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == deletedElement) {
                // skip element - don't copy
            } else {
                result[index] = a[i];  // copy element from original array to result array
                index++;
            }
        }
        return result;
    }

    static int[] deleteTheExistingElement(int[] a, int deletedElement) {
        int[] result = new int[a.length - 1];
        int index = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == deletedElement) {
                // skip element - don't copy
            } else {
                result[index] = a[i];  // copy element from original array to result array
                index++;
            }
        }
        return result;
    }

    static void deleteElementWithSetDefault(int[] a, int e) {
        for (int i = 0; i < a.length; i++) {
            if (e == a[i]) {
                a[i] = 0;
            }
        }
    }
}
